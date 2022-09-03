

import model.*;
import service.CustomerService;
import service.ReservationService;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static service.CustomerService.customers;
import static service.CustomerService.getAllCustomers;
import static service.ReservationService.*;
import static service.ReservationService.rooms;



public class Main {
    //Customer customer = new Customer("Deepa", "Gopalarathnam", "deepashankar1979@gmail.com");
    /*public static void main(String[] args){
        Customer customer;
        customer = new Customer("first", "second", "j@email.com");
        System.out.println(customer);
    }*/
    /*HotelResource hr = new HotelResource();*/

    //MAIN SECTION


    public static void mainMenu() {
        System.out.println("Main Menu");
        System.out.println("Press 1, 2, 3 ,4 or 5");
        System.out.print("1.) Find and reserve a room. \n");
        System.out.print("2.) See my reservation.\n");
        System.out.print("3.) Create an account.\n");
        System.out.print("4.) Admin.\n");
        System.out.print("5.) Exit.\n");
        System.out.print("\nEnter Your Menu Choice: ");


    }//end of mainMenu()


    public static int mainMenuChoice() throws IOException {
        System.out.println("***************************************************");
        System.out.println("**************HOTEL RESERVATION SYSTEM*************");
        System.out.println("***************************************************");
        int choice1;

        while (true) {

            mainMenu();
            //Scanner input;

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String choice1_string = input.readLine();
            try {
                choice1 = Integer.parseInt(choice1_string);
                if (choice1 == 1 || choice1 == 2 || choice1 == 3 || choice1 == 4 || choice1 == 5) {
                    return choice1;

                }//end of if
                else {
                    System.out.println("Your number must be in the range 1 to 5!");
                    mainMenuChoice();

                }//end of else

            } //end of try
            catch (java.lang.NumberFormatException e) {
                System.out.println("*****INPUT ERROR****");
                System.out.println("Your number must be in the range 1 to 5!");
                System.out.println("Please enter a number in the range 1 to 5-->[1,2,3,4,5]");
            }//end of catch
        }//end of while(true){}
    }//end of mainMenuchoice()



    public static void mainMenu_switch(int ch) throws IOException, ParseException {
        int choice1 = ch;
        switch (choice1) {
            case 1 -> {
                System.out.println("You entered 1!");
                System.out.println("******ROOM RESERVATION******");
                System.out.println("This option helps you to find and reserve a room!");
                System.out.println("You need to be an existing customer to make a reservation!");
                int customerIndex=1;
                for (Customer customer : CustomerService.getAllCustomers()) {
                    System.out.println(customerIndex+". \n"+customer.toString());
                    customerIndex+=1;
                }
                Scanner customerObj=new Scanner(System.in);
                System.out.println("Please enter the customer index against your name");
                int customer_Index=customerObj.nextInt();
                if (customer_Index<customerIndex) {
                    Customer checkCustomer = getAllCustomers().get(customer_Index - 1);
                        System.out.println("Congratulations,"+checkCustomer.getLastName()+"\n !You are already in our system!");
                        System.out.println("You can go ahead and select a room!");
                        int count=0;
                        System.out.println("LIST OF ALL ROOMS");
                        System.out.println("It is the responsibility of the person making the reservation to ensure dates do not overlap");
                        System.out.println("\n for a succesful reservation!");


                        System.out.println("List of rooms already reserved with dates they are booked");



                        for(Reservation reservedRoom:reservations)
                        {
                            System.out.println(reservedRoom.getRoom()+" is reserved :");
                            System.out.println("from "+reservedRoom.getCheckInDate());
                            System.out.println("until "+reservedRoom.getCheckOutDate());
                        }

                        System.out.println("List of Rooms not yet booked!");
                        for(Room room:available_rooms){
                            count+=1;
                            System.out.println(count+". "+room.toString());

                        }
                        System.out.println("Please enter index number of room choice, for example, first room-please enter 1");
                        Scanner roomObj=new Scanner(System.in);
                        int roomIndex=roomObj.nextInt();
                        if(roomIndex>(available_rooms.size()))
                        {
                            System.out.println("Invalid room index!");
                            System.out.println("Please try after sometime!");
                            break;

                        }
                        Room reserveRoom=available_rooms.get(roomIndex-1);
                        System.out.println("Please enter checkin date(mm/dd/yyyy) !\n");

                        java.util.Date checkinDt=user_date();
                        System.out.println("Please enter checkOut date(mm/dd/yyyy) !\n");

                        java.util.Date checkOutDt=user_date();
                        java.util.Date today=new Date();
                        //int compareDt=compareDate(checkinDt,checkOutDt);
                        if (checkinDt.after(checkOutDt) || checkinDt.equals(checkOutDt) || checkinDt.equals(today))
                            System.out.println("Dates data not valid for proper reservation procedures!");
                        else
                        {
                            System.out.println("Updating available rooms list....!\n");
                            System.out.println("Please wait....................\n");
                            //if there are no reservations made until now
                            if(reservations.size()==0)
                            {
                                Reservation newReservation = new Reservation(checkCustomer, reserveRoom, checkinDt, checkOutDt);
                                reservations.add(newReservation);
                                available_irooms.remove(reserveRoom);
                                available_rooms.remove(reserveRoom);
                                System.out.println("Reservation Succesful....Congratulations!!!");
                                System.out.println("Back to admin menu!");
                                adminMenu();


                            }
                            for(Reservation existingReservation:reservations)
                            {


                                        Reservation newReservation = new Reservation(checkCustomer, reserveRoom, checkinDt, checkOutDt);
                                        for(Reservation reservation:reservations){
                                            boolean reserve=overlapsWithExisting(reservation);
                                            if(reserve==true)
                                            {
                                                reservations.add(newReservation);
                                                available_irooms.remove(newReservation.getRoom());
                                                available_rooms.remove(newReservation.getRoom());
                                            }

                                        }


                                }



                            /*
                            ***************************
                            *IMPLEMENTED HERE*
                            * ***********************
                            *Search for available rooms
                            Search for recommended rooms
                            Search for available rooms
                            First, you should get from the user the dates that he wants
                            *  a reservation and then show him the list of available rooms for the requested dates.
                             */

                        }
                    }

                    System.out.println("Invalid details!Please try after sometime!");




                do_likemain();

            }//end of case1
            case 2 -> {
                System.out.println("You entered 2!");
                System.out.println("******YOUR ROOM RESERVATION DETAILS...******");
                System.out.println("This option displays your room reservation details!");
                do_likemain();


            }//end of case2
            case 3 -> {
                System.out.println("You entered 3!");
                System.out.println("******DEAR FIRST TIME CUSTOMER, PLEASE CREATE YOUR ACCOUNT!!!******");
                System.out.println("This option helps first time customers to create their account in this system!");
                Customer customer = new Customer("","","");
                System.out.println("Dear Customer,please enter customer first name");
                Scanner sc = new Scanner(System.in);
                String fn = sc.nextLine();
                System.out.println("Dear " + fn + ", please enter your last name");
                String ln = sc.nextLine();
                System.out.println("Dear " + fn + " " + ln + " ,please enter your email");
                String em = sc.nextLine();
                customer.setFirstName(fn);
                customer.setLastName(ln);
                customer.setEmail(em);
                customers.add(customer);
                System.out.println(customer);
                do_likemain();
            }
            /*HotelResource hr = new HotelResource();*/


            case 4 -> {
                System.out.println("You entered 4!");
                System.out.println("******DEAR ADMIN,YOU WILL BE GUIDED TO THE ADMINISTRATION MENU******");
                System.out.println("Displays admin menu!");
                adminMenu();
                break;
            }//end of case4
            case 5 -> {
                System.out.println("Do you really want to exit the Hotel Reservation System?");
                yesOrNo();


            }//end of case5
            default -> throw new IllegalStateException("Unexpected value: " + choice1);

        }//end of switch


    }//end of mainMenuswitch()

    public static String yesOrNo() throws IOException {
        //Source:
        Scanner myObj = new Scanner(System.in);
        String userName;
        while (true) {
            System.out.println("Enter 'y' for Yes or 'n'for No:");
            userName = myObj.nextLine();
            userName = userName.toLowerCase();
            System.out.println("You typed :" + userName);

            if (userName.equals("y")) {
                System.out.println("Thank you!Have a nice day!");
                System.exit(0);


            } else if (userName.equals("n")) {
                mainMenuChoice();


            }
            System.out.println("The answer should be 'y'or'Y' for YES\n");
            System.out.println("The answer should be 'n' or 'N' for NO\n");
        }


    }

    /*HOTEL RESERVATION ADMINISTRATION SYSTEM*/
    public static int adminMenuChoice() throws IOException {
        System.out.println("/n***************************************************");
        System.out.println("**************HOTEL RESERVATION ADMINISTRATION SYSTEM*************");
        System.out.println("***************************************************");
        int choice2;

        while (true) {


            //Scanner input;

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String choice1_string = input.readLine();
            try {
                choice2 = Integer.parseInt(choice1_string);
                if (choice2 == 1 || choice2 == 2 || choice2 == 3 || choice2 == 4 || choice2 == 5) {
                    return choice2;

                }//end of if
                else {
                    System.out.println("Your number must be in the range 1 to 5!");
                    adminMenuChoice();

                }//end of else

            } //end of try
            catch (java.lang.NumberFormatException e) {
                System.out.println("*****INPUT ERROR****");
                System.out.println("Your number must be in the range 1 to 5!");
                System.out.println("Please enter a number in the range 1 to 5-->[1,2,3,4,5]");
            }//end of catch
        }//end of while(true){}
    }//end of adminMenuchoice()

    public static void adminMenu() throws IOException, ParseException {
        System.out.println("***HOTEL RESERVATION ADMINISTRATION SYSTEM***");
        System.out.println("Press 1, 2, 3 ,4 or 5");
        System.out.print("1.) See all customers. \n");
        System.out.print("2.) See all rooms\n");
        System.out.print("3.) Show all reservations.\n");
        System.out.print("4.) Add a room.\n");
        System.out.print("5.) Back to Main Menu.\n");
        System.out.print("\nEnter Your Admin Menu Choice: ");
        int choice = 0;
        choice = adminMenuChoice();
        adminMenu_switch(choice);


    }//end of adminMenu()


    public static void adminMenu_switch(int ch) throws IOException, ParseException {
        int choice1 = ch;
        switch (choice1) {
            case 1 -> {
                System.out.println("You entered 1!");
                System.out.println("******LIST OF CUSTOMERS******");
                System.out.println("This option displays the list of customers!");
                ArrayList<Customer> CustomerList = new ArrayList<Customer>();
                for (Customer customer : CustomerList = CustomerService.getAllCustomers()) {
                    System.out.println(customer);

                }

                adminMenu();
            }//end of case1
            case 2 -> {
                System.out.println("You entered 2!");
                System.out.println("******LIST OF ROOMS...******");
                System.out.println("This option displays ALL the rooms in the hotel reservation system!");
                System.out.println("The rooms available for reservation shows up only when you attempt\n to reserve a room!Thank you!");
                ArrayList<Room> RoomList = new ArrayList<Room>();

                for (Room room1 : RoomList = ReservationService.rooms) {
                    System.out.println(room1);
                System.out.println("These are the available rooms!\n");

             }


                adminMenu();

            }//end of case2
            case 3 -> {
                System.out.println("You entered 3!");
                System.out.println("******LIST OF RESERVATIONS******");
                System.out.println("This option displays a list of all reservations!");
                for(Reservation reservation : reservations)
                {
                    System.out.println(reservation);
                }
                adminMenu();
            }//end of case3
            case 4 -> {
                System.out.println("You entered 4!");
                System.out.println("******DEAR ADMIN,ADD A ROOM******");
                System.out.println("Admins can add a new room to the list of rooms in this hotel reservation system!");
                System.out.println("AddRoom() in ReservationService not showing up here");
                addRoom();
                adminMenu();
                //break;
            }//end of case4
            case 5 -> {
                System.out.println("Do you really want to exit the Admin Menu of the  Hotel Reservation System?");
                do_likemain();
               // break;

            }//end of case5
            default -> throw new IllegalStateException("Unexpected value: " + choice1);

        }//end of switch


    }//end of adminMenuswitch()

    public static void do_likemain() throws IOException, ParseException {
        int choice_main = 0;
        choice_main = mainMenuChoice();
        System.out.println("You are in Main();You chose " + choice_main);
        mainMenu_switch(choice_main);

    }

    public static String admin_yesOrNo() throws IOException, ParseException {
        //Source:
        Scanner myObj = new Scanner(System.in);
        String userName;
        while (true) {
            System.out.println("Enter 'y' for Yes or 'n'for No:");
            userName = myObj.nextLine();
            userName = userName.toLowerCase();
            System.out.println("You typed :" + userName);

            if (userName.equals("y")) {
                System.out.println("Thank you!Have a nice day!");
                System.out.println("You shall be guided back to the main menu shortly......");
                mainMenu();


            } else if (userName.equals("n")) {
                adminMenu();

            } else {
                System.out.println("The answer should be 'y'or'Y' for YES\n");
                System.out.println("The answer should be 'n' or 'N' for NO\n");
                admin_yesOrNo();
            }

        }


    }

    //DATE FORMATTING
    public static java.util.Date user_date() throws ParseException {
        java.util.Date validDate;
        System.out.println("Please enter valid date in the format mm/dd/yyyy\n::");
        Scanner dateObj = new Scanner(System.in);
        String userDate = "";
        userDate = dateObj.nextLine();
        validDate = new SimpleDateFormat("MM/dd/yyyy").parse(userDate);
        //System.out.println(validDate);
        //Date validDate2=new Date();
        //System.out.println(validDate2);

        return validDate;
    }

    public static int compareDate(java.util.Date date1, java.util.Date date2)
    {
        Date dt1=date1;
        Date dt2=date2;
        Date today=new Date();
        int return_value=dt1.compareTo(dt2);
        if(dt1.before(today))
        {
            System.out.println("Check-in date is earlier than today!!!");
            return(0);

        }
        if(dt1==dt2)
        {
            System.out.println("The checkin date and checkout dates are the same!");
            System.out.println("Cannot book a room and sign out on the same day!");
            System.out.println("Please try again!");
            return(0);
        }
        if(dt1.after(dt2))
        {
            System.out.println("Check in date is after the check out date");
            return(0);
        }
        return(1);

    }

    //Source:https://stackoverflow.com/questions/8156078/java-days-bookings

    public static boolean overlapsWithExisting(Reservation reservation) {
        final Date early = reservation.getCheckInDate();
        final Date late = reservation.getCheckOutDate();
        for(Reservation existing : reservations) {
            if(!(early.after(existing.getCheckOutDate() )|| late.before(existing.getCheckInDate())))
            return true;
        }
        return false;
    }
    public static void feed_customer_data()
    {
        Customer newCustomer=new Customer("Deepa","G","deepag@gmail.com");
        boolean add = customers.add(newCustomer);
        Customer newCustomer1=new Customer("Deepa","G","deepag@gmail.com");
        newCustomer1.setFirstName("Tom");
        newCustomer1.setLastName("Thumb");
        newCustomer1.setEmail("tomthumb@gmail.com");
        customers.add(newCustomer1);

    }
    public static void feed_room_data()
    {
        Room newRoom=new Room("101",100.0,"DOUBLE");
        rooms.add(newRoom);
        available_rooms.add(newRoom);
        available_irooms.add(newRoom);

        Room newRoom1=new Room("",0.0,"");
        newRoom1.setRoomNumber("102");
        newRoom1.setPrice(110.0);
        newRoom1.setRoomtype(RoomType.valueOf("SINGLE"));
        rooms.add(newRoom1);
        available_rooms.add(newRoom1);
        available_irooms.add(newRoom1);


    }


    public static void main(String[] args) throws IOException, ParseException {
        /*test code----
        java.util.Date dt,dt2;

        dt=user_date();
        System.out.println(dt);
        dt2=user_date();
        System.out.println(dt2);
        int res=compareDate(dt,dt2);
        System.out.println(res);
        if(res==0)
            System.out.println("improper value!");
        else{
            System.out.println("Please go ahead with reservation!");
        }
        */
        feed_customer_data();
        feed_room_data();




        int choice=0;
        choice=mainMenuChoice();
        System.out.println("You are in Main();You chose "+choice);
        mainMenu_switch(choice);

        //System.out.println("Hotel Reservation Project");
        // */
    }//end of main



}//end of class
