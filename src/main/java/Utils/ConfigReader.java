package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private  static Properties properties;
    public static double expectedTotal = 0.0;
    // to open file of config.properties

    static {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(file);
        }catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("config.properties not found");
        }
    }
    public  static  String getProperty(String key){
        return  properties.getProperty(key);
    }
        }


