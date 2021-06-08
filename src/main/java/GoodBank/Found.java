package GoodBank;

import Registration.ConnectDataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Found implements FoundHelp {
    private ConnectDataBase connectDataBase = new ConnectDataBase(); //создаем объект нашего класса
    private Connection connection = connectDataBase.connectDB("Good"); // создаем объект класса Connection
    private Statement statement = connection.createStatement();
    ArrayList<String> columnHelp = new ArrayList<>();
    HashMap<Integer, ArrayList<String>> selectHelp = new HashMap<>();

    public Found() throws SQLException, IOException, ClassNotFoundException {
    }

    @Override
    public HashMap<Integer, ArrayList<String>> foundLocation(String location) throws SQLException {
        ResultSet resultSet = statement.executeQuery((String.format("select AllHelp.id, AllHelp.name, AllHelp.type, AllHelp.location, AllHelp.textHelp, " +
                "AllHelp.sumHelp, AllHelp.status, AllHelp.dateStart, AllHelp.dateFinished , AllHelp.ratingHistoryLike, AllHelp.ratingHistoryDislike, " +
                "userdata.login from allhelp join userdata on AllHelp.idCreator = userdata.id where location  = '%s';", location)));
        while (resultSet.next()) {
            columnHelp.add(resultSet.getString(2));
            columnHelp.add(resultSet.getString(3));
            columnHelp.add(resultSet.getString(4));
            columnHelp.add(resultSet.getString(5));
            columnHelp.add(String.valueOf(resultSet.getInt(6)));
            columnHelp.add(resultSet.getString(7));
            columnHelp.add(resultSet.getString(8));
            columnHelp.add(resultSet.getString(9));
            columnHelp.add(String.valueOf(resultSet.getInt(10)));
            columnHelp.add(String.valueOf(resultSet.getInt(11)));
            columnHelp.add(resultSet.getString(12));
            selectHelp.put(resultSet.getInt(1), new ArrayList<>(columnHelp));
            columnHelp.clear();
        }
        return selectHelp;
    }

    @Override
    public HashMap<Integer, ArrayList<String>> foundType(String type) throws SQLException {
        ResultSet resultSet = statement.executeQuery((String.format("select AllHelp.id, AllHelp.name, AllHelp.type, AllHelp.location, AllHelp.textHelp, " +
                "AllHelp.sumHelp, AllHelp.status, AllHelp.dateStart, AllHelp.dateFinished, AllHelp.ratingHistoryLike, AllHelp.ratingHistoryDislike, " +
                "userdata.login from allhelp join userdata on AllHelp.idCreator = userdata.id where type  = '%s';", type)));
        while (resultSet.next()) {
            columnHelp.add(resultSet.getString(2));
            columnHelp.add(resultSet.getString(3));
            columnHelp.add(resultSet.getString(4));
            columnHelp.add(resultSet.getString(5));
            columnHelp.add(String.valueOf(resultSet.getInt(6)));
            columnHelp.add(resultSet.getString(7));
            columnHelp.add(resultSet.getString(8));
            columnHelp.add(resultSet.getString(9));
            columnHelp.add(String.valueOf(resultSet.getInt(10)));
            columnHelp.add(String.valueOf(resultSet.getInt(11)));
            columnHelp.add(resultSet.getString(12));
            selectHelp.put(resultSet.getInt(1), new ArrayList<>(columnHelp));
            columnHelp.clear();
        }
        return selectHelp;
    }

    @Override
    public HashMap<Integer, ArrayList<String>> foundName(String name) throws SQLException {
        ResultSet resultSet = statement.executeQuery((String.format("select AllHelp.id, AllHelp.name, AllHelp.type, AllHelp.location, AllHelp.textHelp, " +
                "AllHelp.sumHelp, AllHelp.status, AllHelp.dateStart, AllHelp.dateFinished, AllHelp.ratingHistoryLike, AllHelp.ratingHistoryDislike, " +
                "userdata.login from allhelp join userdata on AllHelp.idCreator = userdata.id where AllHelp.name  = '%s';", name)));
        while (resultSet.next()) {
            columnHelp.add(resultSet.getString(2));
            columnHelp.add(resultSet.getString(3));
            columnHelp.add(resultSet.getString(4));
            columnHelp.add(resultSet.getString(5));
            columnHelp.add(String.valueOf(resultSet.getInt(6)));
            columnHelp.add(resultSet.getString(7));
            columnHelp.add(resultSet.getString(8));
            columnHelp.add(resultSet.getString(9));
            columnHelp.add(String.valueOf(resultSet.getInt(10)));
            columnHelp.add(String.valueOf(resultSet.getInt(11)));
            columnHelp.add(resultSet.getString(12));
            selectHelp.put(resultSet.getInt(1), new ArrayList<>(columnHelp));
            columnHelp.clear();
        }
        return selectHelp;
    }


}

