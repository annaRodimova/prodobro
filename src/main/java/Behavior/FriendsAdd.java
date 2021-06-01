package Behavior;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public interface FriendsAdd {

    public void deleteFriends(String loginFriend) throws SQLException, IOException, ClassNotFoundException;
    public void addFriendsByLogin (String loginFriend) throws SQLException, IOException, ClassNotFoundException;
    public HashMap<Integer, String> foundFriendsByName(String surname, String name, String patronymic) throws SQLException;
    public int idUser(String loginUser) throws SQLException;
    public int myID () throws SQLException, IOException, ClassNotFoundException;
}
