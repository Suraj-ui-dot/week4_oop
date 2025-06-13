// SmartHomeSystem.java

class Device {
    String deviceName;

    public Device(String deviceName) {
        this.deviceName = deviceName;
    }

    public void operate() {
        System.out.println(deviceName + " is operating.");
    }
}

class Light extends Device {
    public Light(String deviceName) {
        super(deviceName);
    }

    @Override
    public void operate() {
        System.out.println(deviceName + " is now ON.");
    }
}

class Thermostat extends Device {
    public Thermostat(String deviceName) {
        super(deviceName);
    }

    @Override
    public void operate() {
        System.out.println(deviceName + " is set to 22°C.");
    }
}

class SecurityCamera extends Device {
    public SecurityCamera(String deviceName) {
        super(deviceName);
    }

    @Override
    public void operate() {
        System.out.println(deviceName + " is now recording.");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Device[] devices = new Device[3];

        devices[0] = new Light("Living Room Light");
        devices[1] = new Thermostat("Main Thermostat");
        devices[2] = new SecurityCamera("Front Door Camera");

        System.out.println(" Smart Home Operation ");
        for (Device d : devices) {
            d.operate(); 
        }
    }
}


