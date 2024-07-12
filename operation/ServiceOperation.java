package operation;

import dao.ServiceDao;
import model.Service;
import java.util.List;

public class ServiceOperation {
    private ServiceDao serviceDao;

    public ServiceOperation(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    public void createService(Service service) {
        serviceDao.createService(service);
    }

    public Service getService(int id) {
        return serviceDao.getService(id);
    }

    public List<Service> getAllServices() {
        return serviceDao.getAllServices();
    }

    public void updateService(Service service) {
        serviceDao.updateService(service);
    }

    public void deleteService(int id) {
        serviceDao.deleteService(id);
    }
}
