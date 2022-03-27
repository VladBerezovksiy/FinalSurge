package finalsurge.utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

@Log4j2
public class CapabilitiesGenerator {

    // В дальнейшем изменить RESOURCE_PATH путь!
    public static final String RESOURCE_PATH = "src/test/resources";
    public static final File RESOURCE_PATH_FILE = new File(RESOURCE_PATH);
    public static final String ABSOLUTE_RESOURCE_PATH = RESOURCE_PATH_FILE.getAbsolutePath();

    // В дальнейшем изменить настройки под ОС И БРАУЗЕРЫ
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        String driver_path = PropertiesUtils.getEnv("driver_path");
        log.info("Operational System: " + os + "; Driver path: " + driver_path);
//        System.out.println("Operational System: " + os + "; Driver path: " + driver_path);
        System.setProperty("webdriver.chrome.driver", driver_path);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", ABSOLUTE_RESOURCE_PATH);
        options.setExperimentalOption("prefs", chromePrefs);

        return options;
    }
}