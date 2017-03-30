package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Amol on 3/29/17.
 */
public class Utils {

    /**
     * Get values from prop files
     * @param filename
     * @param key
     * @return
     */
    public String getValue(String filename, String key) {
        Properties config = new Properties();
        String value = " ";
        String path = System.getProperty("user.dir") + File.separator + "Resources" + File.separator
                + filename + ".properties";
        try {
            FileInputStream fi = new FileInputStream(new File(path));
            config.load(fi);
            value = config.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    // WebDriver Initialization
    public WebDriver Initialize() {
        WebDriver driver = null;
        if (getValue("config", "Browser").equals("Firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return driver;
    }

}
