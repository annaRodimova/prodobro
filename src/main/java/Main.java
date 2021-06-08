import GoodBank.Create;
import GoodBank.Found;
import Registration.Registrate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
       /*Registrate registrate = new Registrate("777thyae", "rxxx@mail.ru", "sova", 9035556677L, "Сова", "Андрей",
                "Михайлович", "1990-11-12");
        registrate.registration("777thyae", "rxxx@mail.ru", "sova", 9035556677L, "Сова", "Андрей",
                "Михайлович", "1990-11-12");


*/
        /*Create create2 =  new Create();
        create2.createHelp("сбор денег на лечение", "лечение", "Россия", "бла бла бла", 100000000, "1 февраля 2022");

         */



        ArrayList<String> columnHelp = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> selectHelp = new HashMap<>();
        Found found = new Found();
        selectHelp = found.foundName("сбор денег на лечение");
        System.out.println(selectHelp.size());
        for (int y = 2; y < selectHelp.size()+2; y++) {
            columnHelp = selectHelp.get(y);
            System.out.println(columnHelp);
        }




    }
}
