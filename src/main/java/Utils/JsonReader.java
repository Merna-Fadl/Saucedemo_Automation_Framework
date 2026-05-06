package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonReader {
    public static String getTestData(String key) {
        JSONParser parser = new JSONParser();
        try {
            // حددي مسار الملف بتاعك صح
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}