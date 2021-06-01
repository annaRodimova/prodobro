package Behavior;

import Registration.ConnectDataBase;
import Registration.Registrate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Friends implements FriendsAdd {
    private ConnectDataBase connectDataBase = new ConnectDataBase(); //создаем объект нашего класса
    private Connection connection = connectDataBase.connectDB("Good"); // создаем объект класса Connection
    private Statement statement = connection.createStatement();

    public Friends() throws SQLException, ClassNotFoundException, IOException {
    }

    @Override
    public void deleteFriends(String loginFriend) throws SQLException, IOException, ClassNotFoundException {
        int idFriend = idUser(loginFriend); // вызов метода, который ищет  id друга по логину
        int idMy = myID(); // вызов метода который ищет мой id по email
        statement.executeUpdate(String.format("delete id_friend from friends where id_user = %s;", idMy));

    }


    @Override
    public void addFriendsByLogin (String loginFriend) throws SQLException, IOException, ClassNotFoundException { // ищу друга по логину и добавляю в таблицу друзей
        int idFriend = idUser(loginFriend); // вызов метода, который ищет  id друга по логину
        int idMy = myID(); // вызов метода который ищет мой id по email
        statement.executeUpdate(String.format("insert into friends (id_user, id_friend) values ('%s');", idMy, idFriend));
    }

    @Override
    public HashMap<Integer, String> foundFriendsByName (String surname, String name, String patronymic) throws SQLException { // поиск друзей по фио, запись результата в мап, в формате id, фио
        ResultSet resultSet = statement.executeQuery(String.format("select id from userData where surname = '%s' and name = '%s' and patronymic = '%s';", surname, name, patronymic));
        int idFriend = 0;
        String fio = surname + " " + name  + " " + patronymic;
        HashMap<Integer, String> friends = new HashMap<>();
        while (resultSet.next()) {
            idFriend = resultSet.getInt(1);
            friends.put(idFriend, fio);
        }
        return  friends;
    }

    @Override public int idUser(String loginUser) throws SQLException { // поиск id любого пользователя по логину
        ResultSet resultSet = statement.executeQuery(String.format("select id userData where login = '%s';", loginUser));
        int idUser = 0;
        while (resultSet.next()) { // обязательно результат resultSet записываем через цикл
            idUser = resultSet.getInt(1);
        }
        return  idUser;
    }

    @Override public int myID () throws SQLException, IOException, ClassNotFoundException { // узнаю свой id
        Registrate emailUser = new Registrate();
        String email = emailUser.getEmail();
        ResultSet resultSet = statement.executeQuery(String.format("select id userData where email = '%s';", email));
        int idUser = 0;
        while (resultSet.next()) { // обязательно результат resultSet записываем через цикл
            idUser = resultSet.getInt(1);
        }
        return  idUser;
   }

}