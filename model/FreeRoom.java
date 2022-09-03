package model;

public class FreeRoom extends Room{

    private FreeRoom(String roomNumber, double Price, String RoomTypeValue) {
        super(roomNumber, Price, RoomTypeValue);
    }

    public void FreeRoom()
    {
        this.setPrice(0.0);
    }
}
