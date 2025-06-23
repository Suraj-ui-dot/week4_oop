// File: AirportArrivalsDataSource.java

import java.util.List;
import java.util.ArrayList;

// Custom checked exception
class ConnectionLostException extends Exception {
    public ConnectionLostException(String message) {
        super(message);
    }
}

// Custom checked exception already defined in TouristDataSource.java
class DataSourceAccessException extends Exception {
    public DataSourceAccessException(String message) {
        super(message);
    }
}

// Abstract class
abstract class TouristDataSource {
    protected String sourceName;

    public TouristDataSource(String sourceName) {
        this.sourceName = sourceName;
    }

    public abstract List<String> fetchData() throws DataSourceAccessException;
}

// Concrete class
public class AirportArrivalsDataSource extends TouristDataSource {

    // Constructor
    public AirportArrivalsDataSource() {
        super("Tribhuvan Airport Arrivals");
    }

    // Override fetchData
    @Override
    public List<String> fetchData() throws DataSourceAccessException {
        try {
            if (sourceName.contains("Tribhuvan") && Math.random() < 0.3) {
                throw new ConnectionLostException("Airport data connection lost! Maybe a pigeon sat on the antenna?");
            }

            List<String> data = new ArrayList<>();
            data.add("Visitor: John Doe, USA");
            data.add("Visitor: Emily White, UK");
            return data;

        } catch (ConnectionLostException e) {
            throw new DataSourceAccessException("Failed to fetch data: " + e.getMessage());
        }
    }

    // Main method to test
    public static void main(String[] args) {
        AirportArrivalsDataSource source = new AirportArrivalsDataSource();

        try {
            List<String> visitors = source.fetchData();
            System.out.println("Arrivals:");
            for (String visitor : visitors) {
                System.out.println(visitor);
            }
        } catch (DataSourceAccessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
