package Registration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDataBase {
    public static ConnectDataBase connectDataBase;

    public ConnectDataBase () {
    }

    public static ConnectDataBase getConnectDataBase() {
        if (connectDataBase == null) {
            connectDataBase = new ConnectDataBase ();
        }
        return connectDataBase;
    }

    public Connection connectDB (String nameDB) throws ClassNotFoundException, SQLException, IOException {
        Properties properties = new Properties();
        String root = System.getProperty("user.dir") + "\\target\\" + "DB.xml";
        properties.loadFromXML(new FileInputStream(root));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String connections = properties.getProperty("connections");

        connections = connections + nameDB+ "?serverTimezone=Europe/Moscow";

        Connection connection = DriverManager.getConnection(connections, user, password);
        return connection;
    }


}

