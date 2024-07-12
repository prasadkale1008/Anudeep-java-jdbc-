package dao;

import model.Date;
import java.util.List;

public interface DateDao {
    void createDate(Date date);
    Date getDate(int id);
    List<Date> getAllDates();
    void updateDate(Date date);
    void deleteDate(int id);
}

