// DeusiBhailo.java
import java.util.List;

// Base custom checked exception
class FestivalPlanningException extends Exception {
    public FestivalPlanningException(String message) {
        super(message);
    }
}

// Custom exception for no planned routes
class NoRouteException extends FestivalPlanningException {
    public NoRouteException(String message) {
        super(message);
    }
}

// Abstract class
abstract class FestivalActivity {
    protected String activityName;
    protected double estimatedCost;

    public FestivalActivity(String activityName, double estimatedCost) {
        this.activityName = activityName;
        this.estimatedCost = estimatedCost;
    }

    public abstract void planActivity() throws FestivalPlanningException;

    public void displayOverview() {
        System.out.println("Activity Name: " + activityName);
        System.out.println("Estimated Cost: Rs. " + estimatedCost);
    }
}

// Concrete class DeusiBhailo
public class DeusiBhailo extends FestivalActivity {
    private List<String> plannedRoutes;
    private int numberOfPerformers;

    public DeusiBhailo(double estimatedCost, List<String> plannedRoutes, int numberOfPerformers) {
        super("Deusi Bhailo Program", estimatedCost);
        this.plannedRoutes = plannedRoutes;
        this.numberOfPerformers = numberOfPerformers;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (plannedRoutes == null || plannedRoutes.isEmpty()) {
            throw new NoRouteException("No routes planned for Deusi Bhailo! Are we just singing in the living room?");
        }

        if (numberOfPerformers < 3) {
            throw new FestivalPlanningException("Need at least 3 performers for a proper Deusi Bhailo!");
        }

        System.out.println("Deusi Bhailo program with " + numberOfPerformers + " performers planned for " + plannedRoutes.size() + " routes!");
    }

    // Main method for testing
    public static void main(String[] args) {
        List<String> routes1 = List.of("Route A", "Route B", "Route C");
        List<String> routes2 = List.of();
        
        DeusiBhailo[] testCases = {
            new DeusiBhailo(40000, routes1, 5),  // valid
            new DeusiBhailo(30000, routes1, 2),  // too few performers
            new DeusiBhailo(35000, routes2, 4),  // no routes
        };

        for (DeusiBhailo program : testCases) {
            System.out.println("----------");
            program.displayOverview();
            try {
                program.planActivity();
            } catch (NoRouteException e) {
                System.out.println("Route Error: " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("Planning Error: " + e.getMessage());
            }
        }
    }
}

