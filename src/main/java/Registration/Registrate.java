package Registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Registrate extends User implements RegistrateUser{
    public Registrate( String password, String email, String login, long phone, String surname, String name, String patronymic, String birthday) throws SQLException, ClassNotFoundException, IOException {
        super(id, password, email, login, phone, surname, name, patronymic, birthday);
    }
    public Registrate() throws SQLException, IOException, ClassNotFoundException {
        super();

    }
    private ConnectDataBase connectDataBase = new ConnectDataBase(); //создаем объект нашего класса
    private Connection connection = connectDataBase.connectDB("Good"); // создаем объект класса Connection
    private Statement statement = connection.createStatement();

    @Override
    public void registration(String password, String email, String login, long phone, String surname, String name,
                             String patronymic, String birthday) throws SQLException, ClassNotFoundException {

        String emailUser = "";
        ResultSet resultSet = statement.executeQuery(String.format("select emailUser from userdata where phone = '%s';", phone));
        while (resultSet.next()) { // обязательно результат resultSet записываем через цикл
            emailUser = resultSet.getString(1);
        }

        if (emailUser.equals("")) { // на то, что пользователь ранее не регистрировался
            System.out.println("пользователь зарегистрирован" + "1");
            statement.executeUpdate(String.format("insert into userData values(%s, '%s', '%s', '%s', '%s', '%s', %s, '%s');",id, password, surname, name, patronymic, email, phone, login));
            statement.executeUpdate(String.format("insert into userInfo values('%s', %s, %s);", birthday, 0, id ));
            System.out.println("пользователь зарегистрирован" + "2");
            statement.executeUpdate(String.format("insert into friends (id_user) values(%s);",id));
            System.out.println("пользователь зарегистрирован" + "3");
        }
    }

    @Override
    public boolean comeIn(String password, String email) throws SQLException {
        String password2 = "";
        String email2 = "";
        ResultSet resultSetpassword = statement.executeQuery(String.format("select password from userData where email = '%s';", email));
        ResultSet resultSetEmail = statement.executeQuery(String.format("select email from userData where email = '%s';", password));
        boolean result = false;
        while (resultSetpassword.next()) { // обязательно результат resultSet записываем через цикл
            password2 = resultSetpassword.getString(1);
        }
        while (resultSetEmail.next()) { // обязательно результат resultSet записываем через цикл
            email2 = resultSetEmail.getString(1);
        }
        if (password2 == password && email2 ==email) {
            // открываем доступ к приложению
            System.out.println("доступ разрешен");
            result = true;
        }
        return result;
    }

    @Override
    public boolean comeIn(String password, long phone) throws SQLException {
        String password2 = "";
        long phone2 = 0;
        ResultSet resultSetpassword = statement.executeQuery(String.format("select password from userData where email = '%s';", phone));
        ResultSet resultSetphone = statement.executeQuery(String.format("select phone from userData where password = '%s';", password));
        boolean result = false;
        while (resultSetpassword.next()) { // обязательно результат resultSet записываем через цикл
            password2 = resultSetpassword.getString(1);
        }
        while (resultSetphone.next()) { // обязательно результат resultSet записываем через цикл
            phone2 = resultSetphone.getLong(1);
        }
        if (password2 == password && phone2 == phone) {
            // открываем доступ к приложению
            System.out.println("доступ разрешен");
            result = true;
        }
        return result;
    }


    @Override
    public void exit() {

    }
}
