// File: CourseEnrollmentManager.jav

public class CourseEnrollmentManager {

    // Static method to handle student enrollment
    public static void enrollStudent(String studentId, String courseId, EligibilityRule rule) {
        System.out.println("Attempting to enroll " + studentId + " in " + courseId + "...");
        try {
            if (rule.isEligible(studentId, courseId)) {
                System.out.println("Enrollment successful for " + studentId + " in " + courseId + "! Happy learning!");
            } else {
                System.out.println("Enrollment failed for " + studentId + ": Not eligible for this course.");
            }
        } catch (EnrollmentDeniedException e) {
            System.out.println("Enrollment failed for " + studentId + ": " + e.getMessage());
        }
    }

    // Main method for testing various enrollment scenarios
    public static void main(String[] args) {
        // Define EligibilityRule using a lambda expression
        EligibilityRule rule = (studentId, courseId) -> {
            if (studentId.equals("SKILL999")) {
                throw new EnrollmentDeniedException("Student account suspended due to outstanding fees, Roshan!");
            } else if (courseId.equals("JAVA101")) {
                if (!studentId.startsWith("SKILL")) {
                    throw new EnrollmentDeniedException("Invalid student ID format. Please use 'SKILL' prefix, Anisha!");
                } else {
                    return true;
                }
            }
            return false; // Not eligible for other courses
        };

        // Test cases
        enrollStudent("SKILL123", "JAVA101", rule);     
        System.out.println("-----");
        enrollStudent("SKILL999", "JAVA101", rule);   
        System.out.println("-----");
        enrollStudent("USER001", "JAVA101", rule);      
        System.out.println("-----");
        enrollStudent("SKILL123", "PYTHON101", rule);   
        System.out.println("-----");

        System.out.println("Humor: Even online learning needs rules! Your lambda ensures no one sneakily enrolls without paying.");
    }
}

