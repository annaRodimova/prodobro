package GoodBank;

import Registration.ConnectDataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Behavior extends Create implements BehaviorHistory { // правильно ли я использовала наследование, уместно ?
    private ConnectDataBase connectDataBase = new ConnectDataBase();
    private Connection connection = connectDataBase.connectDB("Good");
    private Statement statement = connection.createStatement();

    public Behavior() throws SQLException, IOException, ClassNotFoundException {
    }

    //не указала внешние ключи к новым таблицам!!!
    @Override
    public void addLike(int idHistiry, int idUser) throws SQLException {//создала 2 таблицы, лайки и дизлайки, в каждой id истории и id пользователя
        //суть метода, если в таблице нет еще лайка от этого пользователя, то при вызове метода ставим лайк, в противном случае ничего не произойдет
        ResultSet resultSet = statement.executeQuery(String.format("select id_user from likeHistory where id_history = %s;", idHistiry));
        Boolean result = false;
        ArrayList<Integer> id = new ArrayList<>(); //Вопрос о целесообразности использования array
        while (resultSet.next()) {
            id.add(resultSet.getInt(1));
        }
        for (int i = 0; i < id.size(); i++) {
            if(id.get(i) == idUser) {
                result = true;
            }
        }

        if (result == false) {
            statement.executeUpdate(String.format("update allhelp set ratingHistoryLike = ratingHistoryLike + 1 where id = %s;"), idHistiry);
        }
    }

    @Override
    public void addDisLike(int idHistiry, int idUser) throws SQLException { //создала 2 таблицы, лайки и дизлайки, в каждой id истории и id пользователя
        //суть метода, если в таблице нет еще дизлайка от этого пользователя, то при вызове метода ставим дизлайк, в противном случае ничего не произойдет
        ResultSet resultSet = statement.executeQuery(String.format("select idUser from dislike where idHistory = %s;", idHistiry));
        Boolean result = false;
        ArrayList<Integer> id = new ArrayList<>(); //Вопрос о целесообразности использования array
        while (resultSet.next()) {
            id.add(resultSet.getInt(1));
        }
        for (int i = 0; i < id.size(); i++) {
            if(id.get(i) == idUser) {
                result = true;
            }
        }
        if (result == false) {
            statement.executeUpdate(String.format("update allhelp set ratingHistoryDislike = ratingHistoryDislike + 1 where id = %s;"), idHistiry);
        }
    }

    @Override
    public void HistoryComplaint(int idHistiry, int idUser, String description) {

    }

    @Override
    public void deletionHistiry(int idHistiry, int idUser, String description) {

    }
}
