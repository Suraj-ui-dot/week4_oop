// File: EmployeeSystem.java

// Base class Employee
class Employee {
    private String name;
    private int id;
    private double baseSalary;

    // Constructor
    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Method to be overridden
    public double calculateSalary() {
        return baseSalary;
    }
}

// Manager subclass
class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

// Developer subclass
class Developer extends Employee {
    private int overtimeHours;
    private double ratePerHour;

    public Developer(String name, int id, double baseSalary, int overtimeHours, double ratePerHour) {
        super(name, id, baseSalary);
        this.overtimeHours = overtimeHours;
        this.ratePerHour = ratePerHour;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (overtimeHours * ratePerHour);
    }
}

// Main class
public class EmployeeSystem {
    public static void main(String[] args) {
        // Create Manager and Developer objects
        Manager manager = new Manager("Alice", 101, 60000, 15000);
        Developer developer = new Developer("Bob", 102, 50000, 10, 200);

        // Array of base-class references (polymorphism)
        Employee[] employees = { manager, developer };

        // Print details
        for (Employee emp : employees) {
            System.out.println("Employee: " + emp.getName() +
                               " | ID: " + emp.getId() +
                               " | Salary: " + emp.calculateSalary());
        }
    }
}

