package operation;

import dao.TimeDao;
import model.Time;
import java.util.List;

public class TimeOperation {
    private TimeDao timeDao;

    public TimeOperation(TimeDao timeDao) {
        this.timeDao = timeDao;
    }

    public void createTime(Time time) {
        timeDao.createTime(time);
    }

    public Time getTime(int id) {
        return timeDao.getTime(id);
    }

    public List<Time> getAllTimes() {
        return timeDao.getAllTimes();
    }

    public void updateTime(Time time) {
        timeDao.updateTime(time);
    }

    public void deleteTime(int id) {
        timeDao.deleteTime(id);
    }
}
