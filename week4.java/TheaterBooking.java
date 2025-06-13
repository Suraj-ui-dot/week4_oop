// TheaterBooking.java

class Seat {
      int seatNumber;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void bookSeat() {
        System.out.println("Seat " + seatNumber + " booked.");
    }
}

class RegularSeat extends Seat {

    public RegularSeat(int seatNumber) {
        super(seatNumber);
    }

    @Override
    public void bookSeat() {
        System.out.println("Regular Seat " + getSeatNumber() + " booked. Enjoy your show!");
    }
}

class PremiumSeat extends Seat {

    public PremiumSeat(int seatNumber) {
        super(seatNumber);
    }

    @Override
    public void bookSeat() {
        System.out.println("Premium Seat " + getSeatNumber() + " booked.");
        System.out.println("Includes free snack and luxury tax added.");
    }
}

public class TheaterBooking {
    public static void main(String[] args) {
                Seat[] seats = new Seat[2];

        seats[0] = new RegularSeat(5);
        seats[1] = new PremiumSeat(1);

        for (Seat seat : seats) {
            System.out.println("----- Booking Info -----");
            seat.bookSeat();
            System.out.println();
        }
    }
}

