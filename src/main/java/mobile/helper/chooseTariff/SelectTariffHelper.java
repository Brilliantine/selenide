package mobile.helper.chooseTariff;

import mobile.pages.base.BasePage;
import mobile.pages.dataPassenger.DataPassenger;

public class SelectTariffHelper extends BasePage {
    static DataPassenger dataPassenger = new DataPassenger();

    public static boolean checkNoSelectedTariff(){
        return dataPassenger.checkNoSelectedTariff();
    }

    public static void selectFullTariff(){
        if(checkNoSelectedTariff()){
            dataPassenger.expandTariffList();
            dataPassenger.selectFullTariff();
        }else {
            dataPassenger.clickButtonNext();
        }
    }
}
