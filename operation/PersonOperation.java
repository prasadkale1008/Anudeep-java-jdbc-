package operation;

import dao.PersonDao;
import model.Person;

import java.util.Scanner;

public class PersonOperation {
    private PersonDao personDao = new PersonDao();
    private Scanner scanner = new Scanner(System.in);

    public void createPerson() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        Person person = new Person(name, phoneNumber);
        personDao.addPerson(person);
        System.out.println("Person added successfully.");
    }

    public void readPerson() {
        System.out.println("Enter person ID:");
        int id = Integer.parseInt(scanner.nextLine());
        Person person = personDao.getPerson(id);
        if (person != null) {
            
            System.out.println("Name: " + person.getName());
            System.out.println("Phone Number: " + person.getPhoneNumber());
        } else {
            System.out.println("Person not found.");
        }
    }

    public void updatePerson() {
        System.out.println("Enter person ID:");
        int id = Integer.parseInt( scanner.nextLine() );
        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        System.out.println("Enter new phone number:");
        String phoneNumber = scanner.nextLine();
        Person person = new Person(name, phoneNumber);
        person.setId(id);
        personDao.updatePerson(person);
        System.out.println("Person updated successfully.");
    }

    public void deletePerson() {
        System.out.println("Enter person ID:");
        int id = Integer.parseInt(scanner.nextLine());
        personDao.deletePerson(id);
        System.out.println("Person deleted successfully.");

    }

    

    public void listPersons() {
        System.out.println("Person List:");
        for (Person person : personDao.getAllPersons()) {
            System.out.println("ID: " +"ID: " + person.getId()+  ", Name: " + person.getName() + ", Phone Number: " + person.getPhoneNumber());
        }
    }

    
}


