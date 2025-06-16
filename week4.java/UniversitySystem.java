// Base class
class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void getRoleDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Student subclass
class Student extends Person {
    private String program;

    public Student(String name, int id, String program) {
        super(name, id);
        this.program = program;
    }

    @Override
    public void getRoleDetails() {
        super.getRoleDetails();
        System.out.println("Role: Student");
        System.out.println("Program: " + program);
    }
}

// Teacher subclass
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int id, String subject) {
        super(name, id);
        this.subject = subject;
    }

    @Override
    public void getRoleDetails() {
        super.getRoleDetails();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Admin subclass
class Admin extends Person {
    private String department;

    public Admin(String name, int id, String department) {
        super(name, id);
        this.department = department;
    }

    @Override
    public void getRoleDetails() {
        super.getRoleDetails();
        System.out.println("Role: Admin");
        System.out.println("Department: " + department);
    }
}

// Main class
public class UniversitySystem {
    public static void main(String[] args) {
        Person p1 = new Student("suraj", 1001, "Computer Science");
        Person p2 = new Teacher("ram", 2001, "Mathematics");
        Person p3 = new Admin("Charlie", 3001, "IT Department");

        p1.getRoleDetails();
        System.out.println();
        p2.getRoleDetails();
        System.out.println();
        p3.getRoleDetails();
    }
}
