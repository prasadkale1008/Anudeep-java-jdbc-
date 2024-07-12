package operation;

import dao.BookingDao;
import model.Booking;
import java.util.List;

public class BookingOperation {
    private BookingDao bookingDao;

    public BookingOperation(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public void createBooking(Booking booking) {
        bookingDao.createBooking(booking);
    }

    public Booking getBooking(int id) {
        return bookingDao.getBooking(id);
    }

    public List<Booking> getAllBookings() {
        return bookingDao.getAllBookings();
    }

    public void updateBooking(Booking booking) {
        bookingDao.updateBooking(booking);
    }

    public void deleteBooking(int id) {
        bookingDao.deleteBooking(id);
    }
}
