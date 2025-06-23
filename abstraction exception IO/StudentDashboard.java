// File: StudentDashboard.java

public class StudentDashboard {

    // Method to display course enrollment status
    public void displayCourseStatus(String studentId, String courseId, EligibilityRule rule) {
        System.out.println("Checking enrollment status for " + studentId + " in " + courseId + "...");
        try {
            if (rule.isEligible(studentId, courseId)) {
                System.out.println(" You are enrolled! Access course materials now.");
            } else {
                System.out.println(" You are not enrolled in this course.");
            }
        } catch (EnrollmentDeniedException e) {
            System.out.println(" Enrollment denied: " + e.getMessage() + ". Please contact support.");
        } finally {
            System.out.println("Status check completed for " + studentId + ".");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        StudentDashboard dashboard = new StudentDashboard();

        // Reusing the same lambda logic from CourseEnrollmentManager
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
            return false;
        };

        // Test scenarios
        dashboard.displayCourseStatus("SKILL123", "JAVA101", rule);    // ✅ Valid
        System.out.println("-----");
        dashboard.displayCourseStatus("SKILL999", "PYTHON202", rule); // ❌ Suspended
        System.out.println("-----");
        dashboard.displayCourseStatus("STUDENT001", "JAVA101", rule); // ❌ Invalid ID format
    }
}

