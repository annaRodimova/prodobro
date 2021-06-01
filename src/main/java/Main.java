import GoodBank.Create;
import Registration.Registrate;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
       /* Registrate registrate = new Registrate("112233abc", "abc@mail.ru", "anna_rodimova", 9055554455L, "Rodimova", "Anna",
                "Ivanovna", "1993-12-15");
        registrate.registration("112233abc", "abc@mail.ru", "anna_rodimova",9055554455L, "Rodimova", "Anna",
                "Ivanovna", "1993-12-15");

        */
        Create create =  new Create("как я провел это лето", "помощь животным", "Кипр", "бла бла бла", 1000);
        create.createHelp("как я провел это лето", "помощь животным", "Кипр", "бла бла бла", 1000);
    }
}
