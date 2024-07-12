package dao;

import model.Time;
import java.util.List;

public interface TimeDao {
    void createTime(Time time);
    Time getTime(int id);
    List<Time> getAllTimes();
    void updateTime(Time time);
    void deleteTime(int id);
}
