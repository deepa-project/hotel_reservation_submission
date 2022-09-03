package api;



import model.*;
import java.util.ArrayList;
import java.util.Collection;
import service.CustomerService;
import service.ReservationService;

public class HotelResource {
    Customer thisCustomer=new model.Customer("","","");
    static model.IRoom thisRoom = null;
    static service.ReservationService thisReservationService=null;
    static service.CustomerService thisCustomerService=null;
    public model.Customer getCustomer(String email)
    {
        thisCustomer=this.getCustomer(email);

        Customer thisCustomer1 = thisCustomer;
        return thisCustomer1;
    }
    public void createACustomer(String fname,String lname,String email)
    {
        thisCustomerService.addCustomer(email,fname,lname);

    }
    public model.IRoom getRoom(String roomNumber)
    {
        thisRoom=this.getRoom(roomNumber);
        model.IRoom thisRoom1=thisRoom;
        return thisRoom1;

    }
    public Reservation bookARoom(String customerEmail, IRoom room, java.util.Date checkInDate, java.util.Date CheckOutDate)
    {
        Customer x=getCustomer(customerEmail);
        if (x==null){
            System.out.println("You need to first add the Customer details for this new Customer!!!\n");
            System.out.println("Please go back to main menu!");
            return null;

        }
        else
        {
            //to be completed
           return thisReservationService.reserveARoom(x,room,checkInDate,CheckOutDate);


        }
    }
    public Collection<Reservation> getCustomersReservations(String customerEmail)
    {
        thisCustomer= thisCustomerService.getCustomer(customerEmail);

        return thisReservationService.getCustomersReservation(thisCustomer);
    }
    public Collection<IRoom> findARoom(java.util.Date checkIn, java.util.Date checkOut)
    {
        return thisReservationService.findRooms(checkIn,checkOut);
    }

}
