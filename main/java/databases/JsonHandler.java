package databases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class JsonHandler <T> {
    private final File file;
    private final ObjectMapper objectMapper;
    
    public  JsonHandler(String filePath) {
        this.file = new File(filePath);
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }
    
    
    // Method to save an ArrayList of objects to the file
    public void save(ArrayList<T> list) throws IOException { 
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, list);
    }
    
    // Method to load an ArrayList of objects from the file
    public ArrayList<T> load(Class<T> clazz) throws IOException {
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
    }
}
