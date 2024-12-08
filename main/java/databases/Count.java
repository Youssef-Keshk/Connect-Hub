package databases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public abstract class Count {
    protected int count;
    protected final String filePath;

    public Count(String filePath) {
        this.filePath = filePath;
        loadCount();
    }
    
    public void loadCount() {
        try {
            if (Files.exists(Paths.get(filePath))) {
                String content = Files.readString(Paths.get(filePath)).trim();
                count = Integer.parseInt(content);
            } else {
                throw new IOException();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error opening file: " + e.getMessage());
        }
    }

    // Save user count to the file
    public void saveCount() {
        try {
            Files.writeString(Paths.get(filePath), String.valueOf(count));
        } catch (IOException e) {
           System.out.println("Error opening file: " + e.getMessage());
        }
    }

    public synchronized int incrementAndGetCount() {
        loadCount();
        count++;
        saveCount();
        return count;
    }

    public synchronized int getCount() {
        return count;
    }
}
