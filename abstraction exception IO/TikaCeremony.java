// TikaCeremony.java

// Custom base checked exception
class FestivalPlanningException extends Exception {
    public FestivalPlanningException(String message) {
        super(message);
    }
}

// Custom checked exception for guest count
class InvalidGuestCountException extends FestivalPlanningException {
    public InvalidGuestCountException(String message) {
        super(message);
    }
}

// Custom checked exception for budget issues
class BudgetExceededException extends FestivalPlanningException {
    public BudgetExceededException(String message) {
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

// Concrete class: TikaCeremony
public class TikaCeremony extends FestivalActivity {
    private int expectedGuests;
    private String mainFamilyElder;

    public TikaCeremony(double estimatedCost, int expectedGuests, String mainFamilyElder) {
        super("Tika Ceremony", estimatedCost);
        this.expectedGuests = expectedGuests;
        this.mainFamilyElder = mainFamilyElder;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (expectedGuests < 5) {
            throw new InvalidGuestCountException("Not enough guests for a lively Tika! Is everyone on vacation?");
        }

        if (estimatedCost > 50000) {
            throw new BudgetExceededException("Tika budget too high! Is this for the whole village?");
        }

        System.out.println("Tika ceremony with " + mainFamilyElder + " planned successfully for " + expectedGuests + " guests!");
    }

    // Main method for testing
    public static void main(String[] args) {
        // Array of TikaCeremony test cases
        TikaCeremony[] ceremonies = {
            new TikaCeremony(30000, 10, "Grandfather Krishna"),
            new TikaCeremony(60000, 15, "Uncle Ram"),
            new TikaCeremony(25000, 3, "Aunt Sita"),
            new TikaCeremony(48000, 7, "Grandmother Devi")
        };

        for (TikaCeremony ceremony : ceremonies) {
            System.out.println("------------");
            ceremony.displayOverview();
            try {
                ceremony.planActivity();
            } catch (InvalidGuestCountException e) {
                System.out.println("Guest Error: " + e.getMessage());
            } catch (BudgetExceededException e) {
                System.out.println("Budget Error: " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Error: " + e.getMessage());
            }
        }
    }
}

