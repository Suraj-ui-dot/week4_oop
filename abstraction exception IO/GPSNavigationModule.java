// File: GPSNavigationModule.jav

// Interface definition
interface NavigationService {
    void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException;
}

// Custom checked exception
class NavigationFailedException extends Exception {
    public NavigationFailedException(String message) {
        super(message);
    }

    public NavigationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Supporting interface
interface RouteValidator {
    boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
        throws InvalidRouteException, SameLocationException;
}

// Supporting checked exceptions
class InvalidRouteException extends Exception {
    public InvalidRouteException(String message) {
        super(message);
    }
}

class SameLocationException extends Exception {
    public SameLocationException(String message) {
        super(message);
    }
}

// Class: GPSNavigationModule
public class GPSNavigationModule implements NavigationService {

    @Override
    public void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException {
        System.out.println("Attempting to navigate from " + startPoint + " to " + endPoint + "...");

        if (startPoint.equalsIgnoreCase("Kalanki")) {
            throw new NavigationFailedException("GPS signal lost near Kalanki! Welcome to Kathmandu traffic!");
        }

        try {
            double distance = simulatedDistance(startPoint, endPoint);
            if (validator.isValidCommuteRoute(startPoint, endPoint, distance)) {
                System.out.println("Navigation successful! Estimated time: 20 minutes (or 2 hours depending on traffic).");
            }
        } catch (InvalidRouteException | SameLocationException e) {
            throw new NavigationFailedException("Route validation failed!", e);
        }
    }

    // Helper method
    private double simulatedDistance(String start, String end) {
        return 5.0; // fixed distance
    }

    // Main method for testing
    public static void main(String[] args) {
        NavigationService gps = new GPSNavigationModule();

        // Implement RouteValidator inline
        RouteValidator validator = new RouteValidator() {
            @Override
            public boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
                    throws InvalidRouteException, SameLocationException {
                if (origin.equalsIgnoreCase(destination)) {
                    throw new SameLocationException("Origin and destination cannot be the same.");
                }
                if (distanceKm > 100) {
                    throw new InvalidRouteException("Distance exceeds maximum allowed limit.");
                }
                return true;
            }
        };

        // Test Case 1: Valid Route
        try {
            gps.navigate("Baneshwor", "Jawalakhel", validator);
        } catch (NavigationFailedException e) {
            System.out.println("Navigation Failed: " + e.getMessage());
            if (e.getCause() != null)
                System.out.println("Caused by: " + e.getCause().getMessage());
        }

        System.out.println("------------------------------------------------");

        // Test Case 2: GPS Lost at Kalanki
        try {
            gps.navigate("Kalanki", "Thamel", validator);
        } catch (NavigationFailedException e) {
            System.out.println("Navigation Failed: " + e.getMessage());
        }

        System.out.println("------------------------------------------------");

        // Test Case 3: Same start and end point
        try {
            gps.navigate("Bhaktapur", "Bhaktapur", validator);
        } catch (NavigationFailedException e) {
            System.out.println("Navigation Failed: " + e.getMessage());
            if (e.getCause() != null)
                System.out.println("Caused by: " + e.getCause().getMessage());
        }

        System.out.println("------------------------------------------------");

        // Test Case 4: Distance too far
        try {
            gps.navigate("Kathmandu", "Pokhara", new RouteValidator() {
                @Override
                public boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
                        throws InvalidRouteException {
                    throw new InvalidRouteException("Too far to travel by this route.");
                }
            });
        } catch (NavigationFailedException e) {
            System.out.println("Navigation Failed: " + e.getMessage());
            if (e.getCause() != null)
                System.out.println("Caused by: " + e.getCause().getMessage());
        }
    }
}






