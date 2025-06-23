
public class commutePlanner {

    public static void planMyCommute(String origin, String destination, RouteValidator validator, NavigationService navigator) {
        System.out.println("Planning your commute from " + origin + " to " + destination + "...");
        try {
            navigator.navigate(origin, destination, validator);
        } catch (NavigationFailedException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                if (cause instanceof InvalidRouteException) {
                    System.out.println("Cannot plan: Invalid route details.");
                } else if (cause instanceof SameLocationException) {
                    System.out.println("Cannot plan: Origin and destination are the same.");
                } else {
                    System.out.println("Cannot plan: " + cause.getMessage());
                }
            } else {
                if (e.getMessage().toLowerCase().contains("gps")) {
                    System.out.println("Cannot plan: GPS issue.");
                } else {
                    System.out.println("Cannot plan: " + e.getMessage());
                }
            }
        } finally {
            System.out.println("Commute planning for " + origin + " to " + destination + " completed.");
        }
    }

    public static void main(String[] args) {
        KathmanduTrafficValidator validator = new KathmanduTrafficValidator();
        GPSNavigationModule navigator = new GPSNavigationModule();

        // Testing various routes
        planMyCommute("Baneshwor", "Baneshwor", validator, navigator);  n
        System.out.println("-----");
        planMyCommute("Thamel", "Patan", validator, navigator);        e
        System.out.println("-----");
        planMyCommute("Kalanki", "Balaju", validator, navigator);      
        System.out.println("-----");
        planMyCommute("Lagankhel", "Thankot", validator, navigator);   
        
        System.out.println("-----");

        System.out.println("Humor: This app might not fix the traffic, but at least it tells you why you're stuck (or why your route won't work)!");
    }
}
 {
    
}
