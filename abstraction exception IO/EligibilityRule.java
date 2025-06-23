// File: EligibilityRule.java

// Custom checked exception: EnrollmentDeniedException
public class EnrollmentDeniedException extends Exception {
    public EnrollmentDeniedException(String message) {
        super(message);
    }
}

// Functional interface for eligibility checks
@FunctionalInterface
public interface EligibilityRule {
    /**
     * Checks if a student is eligible to enroll in a course.
     * 
     * @param studentId the student's ID
     * @param courseId  the course's ID
     * @return true if eligible, false otherwise
     * @throws EnrollmentDeniedException if enrollment is denied for any reason
     */
    boolean isEligible(String studentId, String courseId) throws EnrollmentDeniedException;
}

