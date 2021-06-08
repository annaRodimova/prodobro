package GoodBank;
 // Поиск нуждающихся среди размещенных запросов.

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface FoundHelp {
    public HashMap<Integer, ArrayList<String>> foundLocation(String location) throws SQLException;
    public HashMap<Integer, ArrayList<String>> foundType(String type) throws SQLException;
    public HashMap<Integer, ArrayList<String>> foundName(String name) throws SQLException;
}
