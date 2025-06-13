// Base class
class SmartDevice {
    String brand;
    String model;



    SmartDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    void turnOn() {
        System.out.println(brand + " " + model + " is turning on...");
    }

    void turnOff() {
        System.out.println(brand + " " + model + " is turning off...");
    }
}

// Subclass: SmartPhone
class SmartPhone extends SmartDevice {

    SmartPhone(String brand, String model) {
        super(brand, model);
    }

    @Override
    void turnOn() {
        System.out.println(brand + " " + model + " smartphone is booting up with fingerprint sensor.");
    }

    @Override
    void turnOff() {
        System.out.println(brand + " " + model + " smartphone is powering off and locking the screen.");
    }
}

// Subclass: SmartWatch
class SmartWatch extends SmartDevice {

    SmartWatch(String brand, String model) {
        super(brand, model);
    }

    @Override
    void turnOn() {
        System.out.println(brand + " " + model + " smartwatch is turning on with a swipe.");
    }

    @Override
    void turnOff() {
        System.out.println(brand + " " + model + " smartwatch is turning off and saving battery.");
    }
}

// Main class to test runtime polymorphism
public class Main {
    public static void main(String[] args) {
        SmartDevice phone = new SmartPhone("Apple", "iPhone 14");
        SmartDevice watch = new SmartWatch("Samsung", "Galaxy Watch 5");

        phone.turnOn();
        phone.turnOff();
        System.out.println("----------------------------");

        watch.turnOn();
        watch.turnOff();
    }
}

