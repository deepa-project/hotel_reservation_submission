package model;

import java.util.Date;

public class Reservation {
    private  Customer customer;
    private IRoom room;
    private  Date checkInDate;
    private Date checkOutDate;
    public Reservation(Customer c, IRoom r, Date checkIn, Date checkOut)
    {
        this.customer=c;
        this.room=r;
        this.checkInDate=checkIn;
        this.checkOutDate=checkOut;

    }//end of Reservation class
    @Override
    public String toString()
            {
                return (customer.toString()+" checked in on "+checkInDate+" and is checking out on "+checkOutDate);


    }//end of override

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }
    public IRoom getRoom(){
        return this.room;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

}//end of class
