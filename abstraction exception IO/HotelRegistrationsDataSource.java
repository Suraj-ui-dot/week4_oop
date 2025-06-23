// File: HotelRegistrationsDataSource.java

import java.util.List;
import java.util.ArrayList;

// Custom checked exception
class AuthenticationFailedException extends Exception {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}

// Custom checked exception (already assumed from previous abstract class)
class DataSourceAccessException extends Exception {
    public DataSourceAccessException(String message) {
        super(message);
    }
}

// Abstract class TouristDataSource
abstract class TouristDataSource {
    protected String sourceName;

    public TouristDataSource(String sourceName) {
        this.sourceName = sourceName;
    }

    public abstract List<String> fetchData() throws DataSourceAccessException;
}

// Concrete class
public class HotelRegistrationsDataSource extends TouristDataSource {

    // Constructor
    public HotelRegistrationsDataSource() {
        super("Kathmandu Hotels Registrations");
    }

    // Override fetchData method
    @Override
    public List<String> fetchData() throws DataSourceAccessException {
        try {
            if (sourceName.contains("Hotels") && Math.random() < 0.2) {
                throw new AuthenticationFailedException("Hotel API authentication failed! Did someone forget the password again?");
            }

            List<String> data = new ArrayList<>();
            data.add("Hotel: Yak & Yeti, Guest: Ram Thapa, NP");
            data.add("Hotel: Annapurna, Guest: Alice Smith, AU");
            return data;

        } catch (AuthenticationFailedException e) {
            throw new DataSourceAccessException("Failed to fetch hotel data: " + e.getMessage());
        }
    }

    // Main method to test
    public static void main(String[] args) {
        HotelRegistrationsDataSource hotelSource = new HotelRegistrationsDataSource();

        try {
            List<String> registrations = hotelSource.fetchData();
            System.out.println("Hotel Registrations:");
            for (String entry : registrations) {
                System.out.println(entry);
            }
        } catch (DataSourceAccessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
