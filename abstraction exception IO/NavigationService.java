// Interface: NavigationService
public interface NavigationService {
    void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException;
}

// Custom checked exception: NavigationFailedException
class NavigationFailedException extends Exception {
    public NavigationFailedException(String message) {
        super(message);
    }

    public NavigationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Supporting interface: RouteValidator
interface RouteValidator {
    boolean isValidCommuteRoute(String origin, String destination, double distanceKm) throws InvalidRouteException;
}

// Supporting custom checked exception: InvalidRouteException
class InvalidRouteException extends Exception {
    public InvalidRouteException(String message) {
        super(message);
    }
}

// Example implementation of NavigationService
class SimpleNavigationService implements NavigationService {
    @Override
    public void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException {
        try {
            double dummyDistance = 10.5; // simulated distance
            if (validator.isValidCommuteRoute(startPoint, endPoint, dummyDistance)) {
                System.out.println("Navigating from " + startPoint + " to " + endPoint + "...");
            } else {
                throw new NavigationFailedException("Route is not valid.");
            }
        } catch (InvalidRouteException e) {
            throw new NavigationFailedException("Navigation failed: " + e.getMessage(), e);
        }
    }
}

// Main class for testing
class NavigaationServiceTest {
    public static void main(String[] args) {
        NavigationService service = new SimpleNavigationService();

        RouteValidator validator = new RouteValidator() {
            @Override
            public boolean isValidCommuteRoute(String origin, String destination, double distanceKm) throws InvalidRouteException {
                if (origin.equalsIgnoreCase(destination)) {
                    throw new InvalidRouteException("Origin and destination must be different.");
                }
                return distanceKm <= 100;
            }
        };

        try {
            service.navigate("Pokhara", "Kathmandu", validator); // should work
            service.navigate("Kathmandu", "Kathmandu", validator); // should throw exception
        } catch (NavigationFailedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
