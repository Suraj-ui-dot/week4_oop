// File: EligibilityRule.java

// Custom checked exception for enrollment denial
class EnrollmentDeniedException extends Exception {
    public EnrollmentDeniedException(String message) {
        super(message);
    }

    public EnrollmentDeniedException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Functional interface for eligibility rule
@FunctionalInterface
public interface EligibilityRule {
    boolean isEligible(String studentId, String courseId) throws EnrollmentDeniedException;
}


