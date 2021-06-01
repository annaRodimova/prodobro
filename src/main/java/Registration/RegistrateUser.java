package Registration;

import java.sql.SQLException;

public interface RegistrateUser {
    public void registration(String password, String email, String login, long phone, String surname, String name,
                             String patronymic, String birthday) throws SQLException, ClassNotFoundException;
    public boolean comeIn (String password, String login) throws SQLException;
    public boolean comeIn (String password, long phone) throws SQLException;
    public void exit ();

}