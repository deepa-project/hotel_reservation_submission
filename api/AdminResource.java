package api;


import model.Customer;
import model.IRoom;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

import static service.ReservationService.rooms;

public abstract class AdminResource {
    static service.ReservationService thisReservationService=null;
    static{
        thisReservationService=null;
    }
    static service.CustomerService thisCustomerService;

    static {
        thisCustomerService = null;
    }

    public Customer getCustomer(String email)
    {
        return thisCustomerService.getCustomer(email);

    }
    public void addRoom(List<IRoom> rooms)
    {
        for(IRoom iroom:rooms)
        {
            thisReservationService.addRoom();
        }

    }

    public java.util.Collection<IRoom> getAllRooms()
    {

        return  ReservationService.available_irooms;
    }

    public Collection<Customer> getAllCustomers()
    {
        return thisCustomerService.getAllCustomers();
    }

    public void displayAllReservations()
    {
        thisReservationService.printAllReservation();
    }
}
