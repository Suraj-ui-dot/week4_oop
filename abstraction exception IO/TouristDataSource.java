// File: TouristDataSource.jav

import java.util.List;

// Custom checked exception: DataSourceAccessException
class DataSourceAccessException extends Exception {
    public DataSourceAccessException(String message) {
        super(message);
    }
}

// Abstract class: TouristDataSource
public abstract class TouristDataSource {
    protected String sourceName;

    // Constructor to initialize sourceName
    public TouristDataSource(String sourceName) {
        this.sourceName = sourceName;
    }

    // Abstract method that may throw a checked exception
    public abstract List<String> fetchData() throws DataSourceAccessException;
}

