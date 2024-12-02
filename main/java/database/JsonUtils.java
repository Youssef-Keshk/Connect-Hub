package database;

import org.json.JSONObject;
import java.lang.reflect.Field;


public class JsonUtils {
    public static <T> T convertFromJson(JSONObject jsonObject, Class<T> type) {
        try {
            T instance = type.getDeclaredConstructor().newInstance();
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                if (jsonObject.has(field.getName())) {
                    Object value = jsonObject.get(field.getName());
                    field.set(instance, value);
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("JSON deserialization error: " + e.getMessage(), e);
        }
    }

    public static <T> JSONObject convertToJson(T object) {
        JSONObject jsonObject = new JSONObject();
        try {
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                jsonObject.put(field.getName(), field.get(object));
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("JSON serialization error: " + e.getMessage(), e);
        }
        return jsonObject;
    }
}
