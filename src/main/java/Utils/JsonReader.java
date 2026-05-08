package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

public class JsonReader {
    private static JSONObject jsonObject;

    // Static block يتم تنفيذه مرة واحدة فقط عند استدعاء الكلاس
    static {
        JSONParser parser = new JSONParser();
        try {
            // استخدام FileReader مع تحديد الترميز لضمان قراءة النصوص العربية أو الخاصة صح
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json", StandardCharsets.UTF_8));
            jsonObject = (JSONObject) obj;
        } catch (Exception e) {
            System.err.println("CRITICAL: Could not load testData.json! Check path: src/test/resources/testData.json");
            e.printStackTrace();
        }
    }

    public static String getTestData(String key) {
        if (jsonObject == null) return null;

        Object value = jsonObject.get(key);
        if (value == null) {
            System.err.println("WARNING: Key [" + key + "] not found in JSON file!");
            return null;
        }
        return value.toString();
    }
}