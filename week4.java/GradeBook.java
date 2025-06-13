// Base class: Student
class Student {
    private String name;
    private int rollNumber;
    private double[] marks;

    public Student(String name, int rollNumber, double[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double[] getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
    }

    // Method to calculate average marks
    public double calculateAverage() {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return marks.length > 0 ? sum / marks.length : 0;
    }
}

// Subclass: GraduateStudent
class GraduateStudent extends Student {
    private String thesisTopic;

    public GraduateStudent(String name, int rollNumber, double[] marks, String thesisTopic) {
        super(name, rollNumber, marks);
        this.thesisTopic = thesisTopic;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }

    public void printThesisTitle() {
        System.out.println("Thesis Topic: " + thesisTopic);
    }
}

// Main class to demonstrate
public class GradeBook {
    public static void main(String[] args) {
        double[] marks1 = {85, 90, 78};
        Student student = new Student("Alice", 101, marks1);
        System.out.println("Student: " + student.getName());
        System.out.println("Average Marks: " + student.calculateAverage());
        System.out.println();

        double[] marks2 = {88, 92, 95};
        GraduateStudent gradStudent = new GraduateStudent("Bob", 202, marks2, "Machine Learning Applications");
        System.out.println("Graduate Student: " + gradStudent.getName());
        System.out.println("Average Marks: " + gradStudent.calculateAverage());
        gradStudent.printThesisTitle();
    }
}

