package GoodBank;

import java.sql.SQLException;

public interface BehaviorHistory {
    public void addLike(int idHistiry, int idUser) throws SQLException;
    public void addDisLike(int idHistiry, int idUser) throws SQLException;
    public void HistoryComplaint(int idHistiry, int idUser, String description);
    public void deletionHistiry(int idHistiry, int idUser, String description);
}
