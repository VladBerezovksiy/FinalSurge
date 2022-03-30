package finalsurge.utils;

import org.openqa.selenium.Dimension;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private static final String CONFIG_PATH = "src/test/resources/config.properties";
    private static Properties PROPERTIES = null;

    private static void readProperties() {
        PROPERTIES = System.getProperties();
        try {
            PROPERTIES.load(new FileInputStream(CONFIG_PATH));
        } catch (IOException e) {
            System.out.println("WARNING: There is no property file " + CONFIG_PATH);
        }
    }

    public static String get(String propertyKey) {
        if (PROPERTIES == null) {
            readProperties();
        }
        return PROPERTIES.getProperty(propertyKey);
    }

    public static String getEnv(String propertyKey) {
        String envProp = System.getenv(propertyKey);
        if (envProp == null) {
            envProp = get(propertyKey);
        }
        return envProp;
    }
}