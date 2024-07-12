package operation;

import dao.DateDao;
import model.Date;
import java.util.List;

public class DateOperation {
    private DateDao dateDao;

    public DateOperation(DateDao dateDao) {
        this.dateDao = dateDao;
    }

    public void createDate(Date date) {
        dateDao.createDate(date);
    }

    public Date getDate(int id) {
        return dateDao.getDate(id);
    }

    public List<Date> getAllDates() {
        return dateDao.getAllDates();
    }

    public void updateDate(Date date) {
        dateDao.updateDate(date);
    }

    public void deleteDate(int id) {
        dateDao.deleteDate(id);
    }
}

