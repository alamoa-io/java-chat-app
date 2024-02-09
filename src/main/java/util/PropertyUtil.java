package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    private static PropertyUtil instance;
    static final String PROPERTY_FILE_PATH = "src/main/resources/application.properties";
    private static final Properties properties = new Properties();

    public static void makeInstance(){
        if(instance == null){
            instance = new PropertyUtil();
        }
    }
    private PropertyUtil(){
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTY_FILE_PATH);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }

}
