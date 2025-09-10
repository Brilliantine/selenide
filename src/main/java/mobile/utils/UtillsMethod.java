package mobile.utils;

import java.io.InputStream;
import java.util.Properties;

public class UtillsMethod {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = UtillsMethod.class.getClassLoader()
                .getResourceAsStream("config.properties")){
            if(inputStream == null){
                throw new IllegalStateException("Файл config.properties не найден");
            }
            properties.load(inputStream);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String getValue(String key){
        return properties.getProperty(key);
    }
}
