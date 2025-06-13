// HospitalRecords.java

class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getTreatmentPlan() {
        System.out.println("Name:"+ name);
        System.out.println("Age:"+ age);
    }

    }


class InPatient extends Patient {
    private int roomNumber;
    private String InPatient;


    public InPatient(String name, int age, int roomNumber) {
        super(name, age);
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void getTreatmentPlan() {
        super.getTreatmentPlan();
        
        System.out.println("InPatient:"+InPatient);   
     }
}

class OutPatient extends Patient {
    private String appointmentDate;

    public OutPatient(String name, int age, String appointmentDate) {
        super(name, age);
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public void getTreatmentPlan() {
        super.getTreatmentPlan();
        System.out.println("AppointementDate:"+appointmentDate);
    }
}

public class HospitalRecords {
    public static void main(String[] args) {
        Patient[] patients = new Patient[2];

        patients[0] = new InPatient("Ram", 30, 10);
        patients[1] = new OutPatient("Hari", 25, "2025-7-10");

        for (Patient p : patients) {
            System.out.println();
        }
    }
}

