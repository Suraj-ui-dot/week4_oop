// File: KathmanduTrafficValidator.java

// Custom checked exception: InvalidRouteException
class InvalidRouteException extends Exception {
    public InvalidRouteException(String message) {
        super(message);
    }
}

// Custom checked exception: SameLocationException
class SameLocationException extends Exception {
    public SameLocationException(String message) {
        super(message);
    }
}

// Interface: RouteValidator
interface RouteValidator {
    boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
            throws InvalidRouteException, SameLocationException;
}

// KathmanduTrafficValidator class implementing RouteValidator
public class KathmanduTrafficValidator implements RouteValidator {

    @Override
    public boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
            throws InvalidRouteException, SameLocationException {

        if (origin.equalsIgnoreCase(destination)) {
            throw new SameLocationException(
                    "Origin and destination cannot be the same! Are you just spinning in circles, Damodar?");
        }

        if (distanceKm < 0.1 || distanceKm > 30) {
            throw new InvalidRouteException(
                    "Distance " + distanceKm + "km is unrealistic for Kathmandu commute!");
        }

        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        KathmanduTrafficValidator validator = new KathmanduTrafficValidator();

        // Test cases
        String[][] testRoutes = {
                {"Koteshwor", "Koteshwor", "5.0"},
                {"Kalanki", "Balaju", "0.05"},
                {"Lagankhel", "Thankot", "35"},
                {"Baneshwor", "Thamel", "7.5"}
        };

        for (String[] test : testRoutes) {
            String origin = test[0];
            String destination = test[1];
            double distance = Double.parseDouble(test[2]);

            try {
                boolean isValid = validator.isValidCommuteRoute(origin, destination, distance);
                System.out.println("Route from " + origin + " to " + destination + " (" + distance + " km) is valid: " + isValid);
            } catch (SameLocationException | InvalidRouteException e) {
                System.out.println("Validation failed for route from " + origin + " to " + destination + ": " + e.getMessage());
            }
        }
    }
}
