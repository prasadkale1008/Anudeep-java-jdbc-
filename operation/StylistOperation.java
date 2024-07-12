package operation;

import dao.StylistDao;
import model.Stylist;
import model.Service;

import java.util.Scanner;

public class StylistOperation {
    private StylistDao stylistDao = new StylistDao();
    private Scanner scanner = new Scanner(System.in);

    public void createStylist() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter ID:");
        int id = Integer.parseInt( scanner.nextLine() );
        
    
        Stylist stylist = new Stylist(name, phoneNumber, id);
        stylistDao.addStylist(stylist);
        System.out.println("Stylist added successfully.");
    }

    public void readStylist() {
        System.out.println("Enter stylist ID:");
        int id = Integer.parseInt( scanner.nextLine() );
        Stylist stylist = stylistDao.getStylist( id );
        if (stylist != null) {
            System.out.println("Stylist ID: " + stylist.getId());
            System.out.println("Name: " + stylist.getName());
            System.out.println("Phone Number: " + stylist.getPhoneNumber());
        } else {
            System.out.println("Stylist not found.");
        }
    }

    public void updateStylist() {
        System.out.println("Enter stylist ID:");
        int id = Integer.parseInt( scanner.nextLine() );
        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        System.out.println("Enter new phone number:");
        String phoneNumber = scanner.nextLine();
        
        Stylist stylist = new Stylist( name, phoneNumber, id );

        stylistDao.updateStylist(stylist);
        System.out.println("Stylist updated successfully.");
    }

    public void deleteStylist() {
        System.out.println("Enter stylist ID:");
        String id = scanner.nextLine();
        stylistDao.deleteStylist(id);
        System.out.println("Stylist deleted successfully.");
    }

    public void listStylists() {
        System.out.println("Stylist List:");
        for (Stylist stylist : stylistDao.getAllStylists()) {
            System.out.println("ID: " + stylist.getId() + ", Name: " + stylist.getName() + ", Phone Number: " + stylist.getPhoneNumber() );
        }
    }
}
