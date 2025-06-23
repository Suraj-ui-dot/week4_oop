// File: DashainPlanner.java

import java.util.*;

// Custom checked exceptions
class FestivalPlanningException extends Exception {
    public FestivalPlanningException(String message) {
        super(message);
    }
}

class InvalidGuestCountException extends FestivalPlanningException {
    public InvalidGuestCountException(String message) {
        super(message);
    }
}

class BudgetExceededException extends FestivalPlanningException {
    public BudgetExceededException(String message) {
        super(message);
    }
}

class NoRouteException extends FestivalPlanningException {
    public NoRouteException(String message) {
        super(message);
    }
}

// Abstract class
abstract class FestivalActivity {
    String activityName;
    double estimatedCost;

    public FestivalActivity(String activityName, double estimatedCost) {
        this.activityName = activityName;
        this.estimatedCost = estimatedCost;
    }

    public abstract void planActivity() throws FestivalPlanningException;

    public String displayOverview() {
        return "Planning Activity: " + activityName + " | Estimated Cost: Rs. " + estimatedCost;
    }
}

// TikaCeremony class
class TikaCeremony extends FestivalActivity {
    int guestCount;

    public TikaCeremony(String activityName, double estimatedCost, int guestCount) {
        super(activityName, estimatedCost);
        this.guestCount = guestCount;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (guestCount <= 0) {
            throw new InvalidGuestCountException("Guest count must be greater than 0.");
        }
        if (estimatedCost > 100000) {
            throw new BudgetExceededException("Tika ceremony budget exceeded!");
        }
        System.out.println("Tika Ceremony with " + guestCount + " guests planned successfully!");
    }
}

// DeusiBhailo class
class DeusiBhailo extends FestivalActivity {
    List<String> plannedRoutes;
    int numberOfPerformers;

    public DeusiBhailo(List<String> plannedRoutes, int numberOfPerformers) {
        super("Deusi Bhailo Program", 3000 + (numberOfPerformers * 100));
        this.plannedRoutes = plannedRoutes;
        this.numberOfPerformers = numberOfPerformers;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (plannedRoutes == null || plannedRoutes.isEmpty()) {
            throw new NoRouteException("No Deusi routes provided.");
        }
        if (estimatedCost > 10000) {
            throw new BudgetExceededException("Deusi Bhailo cost too high!");
        }
        System.out.println("Deusi Bhailo with " + numberOfPerformers + " performers on routes " + plannedRoutes + " planned successfully!");
    }
}

// DashainPlanner class with main
public class DashainPlanner {

    public static void executeFestivalPlan(List<FestivalActivity> activities) {
        for (FestivalActivity activity : activities) {
            System.out.println(activity.displayOverview());
            try {
                activity.planActivity();
            } catch (InvalidGuestCountException e) {
                System.out.println("Planning Warning (Guests): " + e.getMessage());
            } catch (BudgetExceededException e) {
                System.out.println("Planning Warning (Budget): " + e.getMessage());
            } catch (NoRouteException e) {
                System.out.println("Planning Warning (Routes): " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Error: " + e.getMessage());
            } finally {
                System.out.println("Activity planning attempt for " + activity.activityName + " completed.");
                System.out.println("--------------------------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        List<FestivalActivity> activities = new ArrayList<>();

        // Valid activity
        activities.add(new TikaCeremony("Tika Ceremony - Home", 5000, 50));

        // Guest count error
        activities.add(new TikaCeremony("Tika Ceremony - No Guests", 4000, 0));

        // Budget error
        activities.add(new TikaCeremony("Tika Ceremony - Over Budget", 150000, 30));

        // Valid Deusi
        activities.add(new DeusiBhailo(Arrays.asList("Ward 1", "Ward 2"), 5));

        // No route error
        activities.add(new DeusiBhailo(new ArrayList<>(), 10));

        // Cost too high
        activities.add(new DeusiBhailo(Arrays.asList("Ward 3", "Ward 4"), 80));

        executeFestivalPlan(activities);
    }
}

