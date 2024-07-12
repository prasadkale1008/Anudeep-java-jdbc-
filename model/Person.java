package model;

public class Person {
    private int id;
    private String name;
    private String phoneNumber = "";

    public Person() {}

    public Person(String name, String phoneNumber) {
        this.name = name;
        if (phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        } else {
            System.err.println("invalid phone Number :(");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        } else {
            System.err.println("invalid phone Number :(");
        }
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number:  " + phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        Person c = (Person) obj;
        if (c.getName().equalsIgnoreCase(this.name) && c.getPhoneNumber().equals(this.phoneNumber)) {
            return true;
        } else {
            return false;
        }
    }

   
}
