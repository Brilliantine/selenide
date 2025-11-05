package mobile.permission;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import mobile.utils.AppConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class PermissionManager {
    // Получение версии Android (API level)
    private static int getApiLvl() {
        try {
            String[] command = {"adb", "shell", "getprop", "ro.build.version.sdk"};
            Process process = new ProcessBuilder(command).start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            int exitCode = process.waitFor();

            if (exitCode == 0 && output != null) {
                return Integer.parseInt(output.trim());
            }
        } catch (Exception e) {
            log.warn("Не удалось определить версию Android: {}", e.getMessage());
        }

        // Если не смогли определить, считаем что это старая версия
        return 30;
    }

    @Step("Выдача систменых разрешений через ADB")
    public static void grantPermission(){
        String packageName = AppConfig.getInstance().getAppPackage();
        int apiLvl = getApiLvl();

        if(apiLvl < 33){
            log.info("API level {} - выдача разрешений не требуется", apiLvl);
            return;
        }
        String[][] commands = {
                {"adb", "shell", "pm", "grant", packageName, "android.permission.POST_NOTIFICATIONS"},
                {"adb", "shell", "pm", "grant", packageName, "android.permission.ACCESS_FINE_LOCATION"},
                {"adb", "shell", "pm", "grant", packageName, "android.permission.ACCESS_COARSE_LOCATION"}
        };
        for (String[] command : commands) {
            try {
                Process process = new ProcessBuilder(command).start();
                int exitCode = process.waitFor();

                if (exitCode == 0) {
                    log.info("✓ Разрешение выдано: " + command[5]);
                } else {
                    System.out.println("✗ Ошибка выдачи: " + command[5] + " для " + packageName);
                }
            } catch (IOException | InterruptedException exception) {
                log.info("❌ Ошибка при выполнении команды для " + packageName);
                log.info("Детали: " + exception.getMessage());
            }
        }
        /*try {
            Runtime.getRuntime().exec("adb shell pm grant " +  packageName +  " android.permission.POST_NOTIFICATIONS");
            Runtime.getRuntime().exec("adb shell pm grant " + packageName + " android.permission.ACCESS_FINE_LOCATION");
            Runtime.getRuntime().exec("adb shell pm grant " + packageName + " android.permission.ACCESS_COARSE_LOCATION");
        }catch (IOException exception){
            System.out.println("Ошибка при выдаче разрешения через ADB "+exception.getMessage());
        }*/
    }
}
