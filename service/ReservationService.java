package service;
import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collection;
import java.util.Scanner;

public  class ReservationService {
    public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    public static ArrayList<Room>rooms=new ArrayList<Room>();
    public static ArrayList<Room> available_rooms=new ArrayList<Room>();
    public static ArrayList<IRoom> available_irooms=new ArrayList<IRoom>();

    public ReservationService()
    {



    }

    public static void addRoom()
    {


        Scanner roomObj=new Scanner(System.in);
        System.out.println("Enter the room number!");
        String roomNumber="";
        roomNumber=roomObj.nextLine();
        System.out.println("Please enter price of room!");
        float price = roomObj.nextFloat();
        System.out.println("Please enter 'SINGLE' for Single or 'DOUBLE' for double");
        String roomType= roomObj.nextLine();



        if (roomType.equals('S') ){
        roomType = String.valueOf("SINGLE");
    }
        if (roomType.equals('D') ){
            roomType = String.valueOf("DOUBLE");
        }


        Room room1=new Room(roomNumber,price,roomType);



            rooms.add(room1);
        available_irooms.add(room1);
        available_rooms.add(room1);


    }
    public IRoom getARoom(String roomID)
    {
        //to be worked on

        for(Room roomX:rooms)
        {
            if (roomX.getRoomNumber().equals(roomID))
            {
                if (roomX.isFree())
                    return roomX;
                else
                    System.out.println(roomID+" is not free!");
            }
            else
            {
                System.out.println(roomID+" does not exist in our database!");
            }
        }
        return null;
    }
    public Reservation reserveARoom(Customer customer, IRoom room,Date checkInDate, Date checkOutDate)
    {


        Reservation x;
        x = new Reservation(customer,room,checkInDate,checkOutDate);
        reservations.add(x);
        return x;

    }
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate)
    {

        //check rooms in rooms-if they are not in reservations, add them
        //if in reservation, if their checkin/checkout does not overlap with given checkin checkout, add them
        //ref:https://www.tutorialspoint.com/how-to-compare-two-dates-in-java
        for(Room room_search:rooms)
        {
           for(model.Reservation x:reservations)
           {
               if (room_search.equals(x))
               {
                  if (x.getCheckOutDate().compareTo(checkInDate)>0 || x.getCheckInDate().compareTo(checkOutDate)<0)
                  {
                      //x checkout date is sooner than given checkin date
                      //x checkin date after given checkout date

                      available_rooms.add(room_search);
                      available_irooms.add(room_search);
                  }

               }
               else
               {

                   available_rooms.add(room_search);
               }


           }

        }
        return available_irooms;
    }
    public Collection<Reservation> getCustomersReservation(Customer customer)
    {
        return reservations;

    }
    public void printAllReservation()
    {
        for (Reservation x : reservations)
        {
            System.out.println(x.toString());
        }

    }


}
