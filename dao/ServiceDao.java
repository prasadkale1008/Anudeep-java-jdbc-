package dao;

import model.Service;
import java.util.List;

public interface ServiceDao {
    void createService(Service service);
    Service getService(int id);
    List<Service> getAllServices();
    void updateService(Service service);
    void deleteService(int id);
}
