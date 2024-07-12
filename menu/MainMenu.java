package menu; 

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import connection.DatabaseConnection;
import dao.BookingDao;
import dao.CustomerDao;
import dao.StylistDao;
import model.Service;
import model.Stylist;
import model.Customer;
import model.Date;
import model.Hair;
import model.Time;
import model.Booking;


public class MainMenu {
    /**
     * The main method of the SalonBooking class manages user interactions and reservation operations.
     * It facilitates making, displaying, updating, and reviewing reservations within the beauty salon.
     * @param args The array of String arguments passed to the program (not utilized in this implementation).
     */
    public static void main(String[] args) {
        // Initializes a scanner object to handle user input
        Scanner in = new Scanner(System.in);

        BookingDao bookingDao = new BookingDao();
        StylistDao stylistDao = new StylistDao();
        CustomerDao customerDao = new CustomerDao();

        // This Arraylist should hold all booking instances made by customers
        List<Booking> allBooking = bookingDao.getAllBookings();

        // Instantiates Stylist objects to enable user selection later on
        // Stylist stylistCnD = new Stylist("Ameera", "0508245322");

        // // // add into database 
        // stylistDao.addStylist(stylistCnD);

        Stylist stylistCnD = stylistDao.getStylist(1);
        Service hair = new Hair();

        // Declares a Customer object for later use in the program
        Customer customer;

        /*
         * Here, an integer is created to store the customer's choice of salon services.
         * The while loop continues until the customer chooses to exit (chooses a number above 2).
         */
        int choice = 0;
        while (choice <= 2) {
            System.out.println("Welcome to GLOW Beauty Salon!!\n"
                    + "Here is where Glamour, Luxury, Opulence, and Wonder converge to create an unparalleled beauty experience.\n"
                    + "Step into a realm where each visit transcends expectations, where indulgence meets sophistication.\n"
                    + "Our expert team crafts personalized services tailored to elevate your natural radiance,\n"
                    + "ensuring every moment at GLOW Beauty Salon is a journey of elegance and enchantment.\n\n"
                    + "To start, please press the number of the operation you want to perform:\n"
                    + "(1) Make a reservation\n"
                    + "(2) Display a reservation\n"
                    + "Note that entering any other number will cause the program to exit!");
            choice = in.nextInt(); // User input is stored in the 'choice' variable.
            // Switch statement to handle user's choice
            switch (choice) {

                /*
                 * Case 1: Make a reservation
                 * Gathering customer information for reservation creation. This information will be passed
                 * to the customer object we declared previously.
                 */
                case 1:
                    System.out.println("Phone number: *kindly, make sure it is 10 numbers :)*");
                    String phone = in.next();
                    // Validate phone number format
                    // Error handling: this part makes sure the runtime error will not exit the program
                    while(phone.length()!=10){
                        System.err.println("Invalid Phone Number! Try again!");
                        phone = in.next();
                    }

                    customer = customerDao.getCustomerByPhoneNumber( phone ); 
                    if( customer == null ) {
                        System.out.println("You information is not saved in Database please register first!");
                        
                        System.out.println("Please enter your info:");
                        System.out.println("Full name:");
                        in.nextLine(); // Clears the input buffer (gets rid of \n in the previous input)
                        String name = in.nextLine();

                        System.out.println("CreditCard number: *kindly, make sure it is all integer, and 16 numbers :)*");
                        String ccNo = in.next();
                        // Validate credit card number format
                        // Error handling: this part makes sure the runtime error will not exit the program
                        while(ccNo.length()!=16){
                            System.err.println("Invalid Credit Card number! Try again!");
                            ccNo = in.next();
                        }
                        customer = new Customer(name, phone, ccNo);
                        // add into database
                        customerDao.addCustomer( customer );
                    }
                    else {
                        System.out.println("You are already registered! Please continue");
                    }
                    
                    // Gathering reservation date
                    System.out.println("Enter the day, month and year, respectively: (kindly, leave a space between each of them)");
                    int day = in.nextInt();
                    int month = in.nextInt();
                    int year = in.nextInt();
                    Date date = new Date(day, month, year);
                    // Check for a valid date
                    while(!date.check()){
                        day = in.nextInt();
                        month = in.nextInt();
                        year = in.nextInt();
                        date = new Date(day, month, year);
                    }

                    // Gathering reservation time
                    System.out.println("Enter the hour(in 24 system) and minutes, respectively: (kindly, leave a space between the hour and minutes)"
                            +"\nNote: Our opening hours are from 10 to 22");
                    int hour = in.nextInt();
                    int minute = in.nextInt();
                    Time time = new Time(hour, minute);
                    // Check for a valid time
                    while(!time.check()){
                        hour = in.nextInt();
                        minute = in.nextInt();
                        time = new Time(hour, minute);
                    }

                    // Check availability for the selected date and time
                    boolean available = true;
                    for (int i=0; i<allBooking.size(); i++) {
                        if (!allBooking.get(i).checkAvailability(date, time)) {
                            available = false;
                            break;
                        }
                    }

                    if( available ) {
                        System.out.println("the time you picked is available :)!");
                    }
                    else {
                        System.err.println("Sorry! The time you picked is not available!");
                        break;
                    }

                    
                    System.out.println("Which one of these describes your hair length best?\n"
                    + "(1) Short hair\n"
                    + "(2) Mid-length hair\n"
                    + "(3) Long hair");
                    int l = in.nextInt();

                    hair = new Hair(date, time, stylistCnD, 3, l);
                    ((Hair) hair).setStyle(3);
                    hair.calculatePrice();
                    System.out.println("The price for this service is: "+hair.getPrice());
                    System.out.println("Your stylist's info:\n" + stylistCnD);

                    Booking booking = new Booking(customer, stylistCnD, date, time, hair.getPrice());
                    booking.setStylist(stylistCnD);
                    bookingDao.createBooking( booking );
                    allBooking.add( booking );
                    System.out.println("Are there any more operations you want to perform? (please answer with yes or no only)");
                    String boo = in.next();
                    if (boo.equalsIgnoreCase("yes")) {
                        continue; // continue with the loop
                    } else {
                        System.out.println("Thank you, sir. Please visit next time.");
                    }
                    break;
                        
                    

                

                /*
                 * Case 2 of the outer switch: Display a reservation
                 * Operations requiring an existing reservation.
                 * Prompt user for their phone number and check if it exists in the system.
                 * If it exists, the inner loop and switch statement will be entered. Otherwise, exit.
                 */
                
                case 2:
                    System.out.println("Please write your phone number:");
                    in.nextLine(); // Clears the input buffer (gets rid of \n in the previous input)
                    phone = in.nextLine();
                    Booking  b= null;

                    customer = customerDao.getCustomerByPhoneNumber( phone ); 
                    if( customer == null ) {
                        System.out.println("No reservation for this customer!");
                        break;
                    }

                    // Check if the phone number exists in the system
                    boolean flag = true;
                    for (int i = 0; i < allBooking.size(); i++) {
                        if (allBooking.get(i).getCustomer().getPhoneNumber().equals(phone)) {
                            b = allBooking.get(i);
                        }else{
                            System.err.println("Sorry! The phone number you entered is not in our system :(");
                            flag = false;
                            break;
                        }
                    }

                    if( !flag ) {
                        break;
                    }

                    
                    System.out.println("Your Booking Details:");

                    System.out.println("Date: " + b.getDate() + ", Time: " + b.getTime() + ", Price " + b.getPrice() + ",\nStylist Name : " + b.getStylist().getName() + ", Stylist Phone: " + b.getStylist().getPhoneNumber() );

                    // Inner switch in case 2 for various operations on an existing reservation.
                    int ch=0;
                    while(ch<=2){
                        System.out.println("What else do you want to do with this reservation?\n" +
                                "(1) Update date and time\n" +
                                "(2) Delete reservation\n" +
                                "(3) Exit");
                        choice = in.nextInt(); // User input for operation selection
                        switch (choice) {
                            // Cases for different operations on the reservation...
                            /*
                             * Case 1 in inner switch for updating time and date
                             */
                            case 1:
                                System.out.println("Enter the new day, month and year of your reservation, respectively: (kindly, leave a space between each of them)");
                                day = in.nextInt();
                                month = in.nextInt();
                                year = in.nextInt();
                                Date d1 = new Date(day, month, year);
                                while(!d1.check()){
                                    day = in.nextInt();
                                    month = in.nextInt();
                                    year = in.nextInt();
                                    d1 = new Date(day, month, year);
                                }


                                System.out.println("Enter the new hour(in 24 system) and minutes of your reservation, respectively: (kindly, leave a space between the hour and minutes)"
                                        +"\nNote: Our opening hours are from 10 to 22");
                                hour = in.nextInt();
                                minute = in.nextInt();
                                Time t1 = new Time(hour, minute);
                                while(!t1.check()){
                                    hour = in.nextInt();
                                    minute = in.nextInt();
                                    t1 = new Time(hour,minute);
                                }

                                for (int j = 0; j < allBooking.size(); j++) {
                                    if (b.checkAvailability(d1, t1)) {
                                        b.updateDate(d1);
                                        b.updateTime(t1);
                                    }else{
                                        System.err.println("Sorry! The time you picked is not available!");
                                    }
                                }
                                allBooking.add(b);
                                System.out.println("Your date/time has been updated!");
                                System.out.println("Are there any more operations you want to perform? (please answer with yes or no only)");
                                String yon = in.next();
                                if (yon.equalsIgnoreCase("yes")) {
                                    continue;
                                }else{
                                    ch=6;
                                    choice=3;
                                }
                                break;
                            // End of case 1 in inner switch

                            /*
                             * Case 2 in inner switch for deleting reservation
                             */
                            case 2:
                                System.out.println(b.getId());
                                // delete from database 
                                boolean success = bookingDao.deleteBooking( b.getId() );
                                    
                                if( !success ) {
                                    System.out.println("Unable to Delete");
                                    break;
                                }
                                else {
                                    System.out.println("Your reservation has been deleted");
                                }
                                allBooking.remove(b);
                                break;
                            // End of case 2 in inner switch

                            case 3:
                                ch=3;
                                break;
                            // End of case 3 in inner switch

                            default:
                                System.err.println("Invalid input! There is no case with this character!");
                        }
                        if(b==null) {
                            System.out.println("Sorry! The phone number you entered is not in our system :(");
                        }
                    } // Closing curly braces for the inner while loop and switch statement

                // The default statement for the outer switch
                default:
                    System.out.println("Invalid input! Exiting the program...");
                    System.exit(0);
                    break;
            }
        } 
        in.close();

        // Closing curly braces for the outer while loop and switch statement
        System.out.println("Your request have been processed.\nThank you for choosing Beauty Salon. Have a nice day!");
    } // Closing the main method
}//SalonBooking class (main)

