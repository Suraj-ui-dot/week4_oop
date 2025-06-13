// TicketSystem.java

class Ticket {
    public String ticketNumber;
    public double price;

    public Ticket(String ticketNumber, double price) {
        this.ticketNumber = ticketNumber;
        this.price = price;
    }

    public void generateTicket() {
        System.out.println("Ticket No: " + ticketNumber);
        System.out.println("Price: $" + price);
    }
}

class BusTicket extends Ticket {
    public int seatNumber;

    public BusTicket(String ticketNumber, double price, int seatNumber) {
        super(ticketNumber, price);
        this.seatNumber = seatNumber;
    }

    @Override
    public void generateTicket() {
        super.generateTicket();
        System.out.println("Type: Bus");
        System.out.println("Seat No: " + seatNumber);
    }
}

class TrainTicket extends Ticket {
    public String coachType;

    public TrainTicket(String ticketNumber, double price, String coachType) {
        super(ticketNumber, price);
        this.coachType = coachType;
    }

    @Override
    public void generateTicket() {
        super.generateTicket();
        System.out.println("Type: Train");
        System.out.println("Coach Type: " + coachType);
    }
}

class FlightTicket extends Ticket {
    public String boardingGate;

    public FlightTicket(String ticketNumber, double price, String boardingGate) {
        super(ticketNumber, price);
        this.boardingGate = boardingGate;
    }

    @Override
    public void generateTicket() {
        super.generateTicket();
        System.out.println("Type: Flight");
        System.out.println("Boarding Gate: " + boardingGate);
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        Ticket[] tickets = new Ticket[3];

        tickets[0] = new BusTicket("B123", 15.50, 12);
        tickets[1] = new TrainTicket("T456", 35.75, "AC First Class");
        tickets[2] = new FlightTicket("F789", 150.99, "Gate A3");

        for (Ticket t : tickets) {
            System.out.println("----- Ticket Info -----");
            t.generateTicket();
            System.out.println();
        }
    }
}

