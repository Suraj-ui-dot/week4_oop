// File: RouteValidator.jav

// Custom checked exception
class InvalidRouteException extends Exception {
    public InvalidRouteException(String message) {
        super(message);
    }
}

// Interface definition
public interface RouteValidator {
    boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
        throws InvalidRouteException;
}

