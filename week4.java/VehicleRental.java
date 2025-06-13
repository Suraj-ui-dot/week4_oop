    // VehicleRental.java

class Vehicle {
    String plateNumber;
    double baseRate;

    public Vehicle(String plateNumber, double baseRate) {
        this.plateNumber = plateNumber;
        this.baseRate = baseRate;
    }

    public double calculateRental(int days) {
        return baseRate * days;
    }
}

class Car extends Vehicle {
    public Car(String plateNumber, double baseRate) {
        super(plateNumber, baseRate);
    }

    @Override
    public double calculateRental(int days) {
        return baseRate * days;
    }
}

class Truck extends Vehicle {
    private double loadFee;

    public Truck(String plateNumber, double baseRate, double loadFee) {
        super(plateNumber, baseRate);
        this.loadFee = loadFee;
    }

    @Override
    public double calculateRental(int days) {
        return (baseRate * days) + loadFee;
    }
}

class Bike extends Vehicle {
    private double fixedRate;

    public Bike(String plateNumber, double fixedRate) {
        super(plateNumber, 0); // baseRate not used for Bike
        this.fixedRate = fixedRate;
    }

    @Override
    public double calculateRental(int days) {
        return fixedRate; // regardless of days
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("ABC123", 40);
        vehicles[1] = new Truck("XYZ789", 60, 100);
        vehicles[2] = new Bike("BIKE001", 50);

        int rentalDays = 3;
        for (Vehicle v : vehicles) {
            System.out.println("Plate: " + v.plateNumber + ", Rental for " + rentalDays + " days = $" + v.calculateRental(rentalDays));
        }
    }
}
