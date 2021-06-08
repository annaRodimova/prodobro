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



        Create create2 =  new Create();
        create2.createHelp("накормить бродячих псов", "помощь собакам", "Италия", "бла бла бла", 800);


        */
        ArrayList<String> columnHelp = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> selectHelp = new HashMap<>();
        Found found = new Found();
        selectHelp = found.foundLocation("Кипр");

        for (int y = 2; y < selectHelp.size()+2; y++) {
            columnHelp = selectHelp.get(y);
            System.out.println(columnHelp);
        }


    }
}
