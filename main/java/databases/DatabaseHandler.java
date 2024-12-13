package databases;

import java.io.IOException;
import java.util.ArrayList;

public abstract class DatabaseHandler<T> {
    final JsonHandler<T> database;
    protected ArrayList<T> records;
    private final Class<T> type;

    public DatabaseHandler(String filePath, Class<T> type) {
        this.database = new JsonHandler<>(filePath);
        this.type = type;
        this.records = loadRecords();
    }

    public ArrayList<T> loadRecords() {
        try {
            ArrayList<T> t = database.load(type);
            return t != null ? t : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error loading records: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveRecords() {
        try {
            database.save(records);
        } catch (IOException ex) {
            System.out.println("Error saving records: " + ex.getMessage());
        }
    }

    public ArrayList<T> getAllRecords() {
        return records;
    }

    public boolean insertRecord(T t) {
        boolean success = records.add(t);
        saveRecords();
        return success;
    }

    public boolean removeRecord(T t) {
        boolean success = records.remove(t);
        saveRecords();
        return success;
    }
    
    public void refreshRecords() {
        records = loadRecords();
    }
}
