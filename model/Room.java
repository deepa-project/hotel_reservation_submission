package model;
import java.lang.Override;


public class Room implements IRoom {
    private String roomNumber;
    private Double Price;
    private RoomType roomtype;



    public Room(String roomNumber, double Price, String RoomTypeValue)
    {
        this.roomNumber=roomNumber;
        this.Price=Price;
        try {
            this.roomtype = RoomType.valueOf(RoomTypeValue);
        }
        catch(java.lang.IllegalArgumentException e)
        {
            System.out.println(e.toString());
            System.out.println("Default value DOUBLE shall be used!");
        }
        finally
        {
            this.roomtype=RoomType.DOUBLE;
        }
    }




    @Override
    public String toString(){
        String s="This room is of type "+roomtype.toString()+"\n"+"It costs "+this.Price+" per night!\n"+"The room number is :"+this.roomNumber+".";
        return(s);

  }

    public void setPrice(Double price) {
        Price = price;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomtype(RoomType roomtype) {
        this.roomtype = roomtype;
    }

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public double getRoomPrice() {
        return this.Price;
    }

    @Override
    public String getRoomType() {
        return this.roomtype.toString();
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
