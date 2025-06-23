import java.util.*;

// Custom checked exception
class EmptyDataException extends Exception {
    public EmptyDataException(String message) {
        super(message);
    }
}

// Interface
interface DataProcessor {
    List<String> process(List<String> rawData) throws EmptyDataException;
}

// UniqueVisitorCounter class
public class UniqueVisitorCounter implements DataProcessor {

    @Override
    public List<String> process(List<String> rawData) throws EmptyDataException {
        if (rawData == null || rawData.isEmpty()) {
            throw new EmptyDataException("No raw data to process! Did all tourists go missing?");
        }

        Set<String> uniqueVisitors = new HashSet<>();

        for (String entry : rawData) {
            if (entry.startsWith("Visitor: ") || entry.startsWith("Guest: ")) {
                String[] parts = entry.split(": ")[1].split(",");
                String name = parts[0].trim();
                uniqueVisitors.add(name);
            }
        }

        return Collections.singletonList("Unique Visitors: " + uniqueVisitors.size());
    }

    // Main method for testing
    public static void main(String[] args) {
        UniqueVisitorCounter counter = new UniqueVisitorCounter();

        // Test with empty list
        try {
            List<String> emptyData = new ArrayList<>();
            System.out.println(counter.process(emptyData));
        } catch (EmptyDataException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Test with dummy data
        try {
            List<String> dummyData = Arrays.asList(
                "Visitor: ram, USA",
                "Guest: shyam, UK",
                "Visitor: gobinda, USA",
                "Guest: gaurav, Canada"
            );
            System.out.println(counter.process(dummyData));
        } catch (EmptyDataException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
