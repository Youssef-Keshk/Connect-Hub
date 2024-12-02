package database;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class JsonHandler<T> {
    private final String filePath;
    private final Class<T> type;

    public JsonHandler(String filePath, Class<T> type) {
        this.filePath = filePath;
        this.type = type;
    }

    public ArrayList<T> readAll() {
        ArrayList<T> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            JSONArray jsonArray = new JSONArray(content.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                T item = JsonUtils.convertFromJson(jsonObject, type);
                items.add(item);
            }
        } catch (IOException e) {
            // Return empty list if file doesn't exist or error occurs
            System.err.println("File read error: " + e.getMessage());
        }
        return items;
    }

    public void saveAll(ArrayList<T> items) {
        JSONArray jsonArray = new JSONArray();
        for (T item : items) {
            JSONObject jsonObject = JsonUtils.convertToJson(item);
            jsonArray.put(jsonObject);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(jsonArray.toString(4));
        } catch (IOException e) {
            System.err.println("File write error: " + e.getMessage());
        }
    }
}
