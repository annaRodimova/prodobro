package GoodBank;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public interface CreateHelp {
    public void createHelp(String name, String type, String location, String text, int sumHelp, String dataFinished) throws SQLException, IOException, ClassNotFoundException;
}
