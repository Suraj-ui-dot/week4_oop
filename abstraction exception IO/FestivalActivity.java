// Custom checked exception: FestivalPlanningException
class FestivalPlanningException extends Exception {
    public FestivalPlanningException(String message) {
        super(message);
    }

    public FestivalPlanningException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Abstract class: FestivalActivity
abstract class FestivalActivity {
    protected String activityName;
    protected double estimatedCost;

    // Constructor
    public FestivalActivity(String activityName, double estimatedCost) {
        this.activityName = activityName;
        this.estimatedCost = estimatedCost;
    }

    // Abstract method
    public abstract void planActivity() throws FestivalPlanningException;

    // Concrete method
    public void displayOverview() {
        System.out.println("Festival Activity: " + activityName);
        System.out.println("Estimated Cost: Rs. " + estimatedCost);
    }
}


