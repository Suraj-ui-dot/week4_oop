  
// File: DataProcessor.java

import java.util.List;

// Custom checked exception
class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }
}

// Interface for processing data
public interface DataProcessor {
    // Abstract method that processes data and might throw an exception
    List<String> process(List<String> rawData) throws DataProcessingException;
}

