package model;
import model.Person;

public class Stylist extends Person {
    private int id;
    private Service job;

    public Stylist() {}

    public Stylist(String name, String phoneNumber, int id) {
        super(name, phoneNumber);
        this.id = id;
     }

    public Stylist(String name, String phoneNumber) {
        super(name, phoneNumber);
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public Service getJob() {
        return job;
    }

    public void setJob(Service job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + "\nPhone Number: " + super.getPhoneNumber() + "\nID: " + id;
    }
}
