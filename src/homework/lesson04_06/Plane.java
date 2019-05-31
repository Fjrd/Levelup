package homework.lesson04_06;

import java.util.ArrayList;

public class Plane {

    private int planeId = 0;
    final private int numberOfSeats = 0;
    private ArrayList<Seat> orderedSeatList = new ArrayList<>();

    public Plane(int planeId) {
        this.planeId = planeId;
    }

    public void orderSeat(int number){
        orderedSeatList.add(new Seat(number));
    }

    public void cancelOrderSeat(Seat seat){
        orderedSeatList.remove(seat);
    }
}
