package operation;

import dao.CustomerDao;
import model.Customer;

import java.util.Scanner;

public class CustomerOperation {
    private CustomerDao customerDao = new CustomerDao();
    private Scanner scanner = new Scanner(System.in);

    public void createCustomer() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter credit card number:");
        String creditCardNo = scanner.nextLine();
        Customer customer = new Customer(name, phoneNumber, creditCardNo);
        customerDao.addCustomer(customer);
        System.out.println("Customer added successfully.");
    }

    public void readCustomer() {
        System.out.println("Enter customer ID:");
        int id = Integer.parseInt(scanner.nextLine());
        Customer customer = customerDao.getCustomer(id);
        if (customer != null) {
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Phone Number: " + customer.getPhoneNumber());
            System.out.println("Credit Card: " + customer.getCreditCardNo());
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void updateCustomer() {
        System.out.println("Enter customer ID:");
        int id = Integer.parseInt( scanner.nextLine() );
        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        System.out.println("Enter new phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter new credit card number:");
        String creditCardNo = scanner.nextLine();
        Customer customer = new Customer(name, phoneNumber, creditCardNo);
        customer.setId(id);
        customerDao.updateCustomer(customer);
        System.out.println("Customer updated successfully.");
    }

    public void deleteCustomer() {
        System.out.println("Enter customer ID:");
        int id = Integer.parseInt(scanner.nextLine());
        customerDao.deleteCustomer(id);
        System.out.println("Customer deleted successfully.");
    }

    public void listCustomers() {
        System.out.println("Customer List:");
        for (Customer customer : customerDao.getAllCustomers()) {
            System.out.println("ID: " + customer.getId() + ", Name: " + customer.getName() + ", Phone Number: " + customer.getPhoneNumber() + ", Credit Card: " + customer.getCreditCardNo());
        }
    }
}
