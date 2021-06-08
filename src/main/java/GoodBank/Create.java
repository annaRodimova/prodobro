package GoodBank;

import Registration.ConnectDataBase;
import Registration.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Create extends User implements CreateHelp{

    private String type = "";
    private String text = "";
    private String location = "";
    private int sumHelp = 0;
    private String name = "";
    private String dataRegistration;
    private String dataFinished;
    public static int id = 1;
    private int idCreator = 0;

    public Create(int id, String name, String type, String location, String text, int sumHelp) throws SQLException, IOException, ClassNotFoundException {
        this.name = name;
        this.type = type;
        this.location = location;
        this.text = text;
        this.sumHelp = sumHelp;
        this.id = ++id;
        System.out.println(id + "конструктор");
    }
    public Create() throws SQLException, IOException, ClassNotFoundException {

    }

    public HashSet<String> typehelp = new HashSet<>();
    private ConnectDataBase connectDataBase = new ConnectDataBase(); //создаем объект нашего класса
    private Connection connection = connectDataBase.connectDB("Good"); // создаем объект класса Connection
    private Statement statement = connection.createStatement();

    public HashSet<String> typeHelp () throws SQLException { //метод позволяющий получить разделы помощи
        typehelp.add("Help for children");
        typehelp.add("Help for animals");
        typehelp.add("Help for helping those in need");
        typehelp.add("Help for helping those in need");
        typehelp.add("Help for nature");
        return typehelp;
    }

    @Override
    public void createHelp(String name, String type, String location, String text, int sumHelp) throws SQLException, IOException, ClassNotFoundException {
        Create newCreateHelp = new Create(id, name, type,  location,  text,  sumHelp);
        System.out.println(id + "метод");
        Date dateRegistrate = new Date();
        dataRegistration = dateRegistrate.toString();

        statement.executeUpdate(String.format("insert into allHelp values(%s, '%s', '%s', '%s', '%s', %s, '%s', '%s', '%s', %s);",
                id, name, type, location, text, sumHelp, "create", dataRegistration, dataFinished, super.id));
    }
}
