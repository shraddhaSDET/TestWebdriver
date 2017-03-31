import Pageobjects.GooglePage;
import Utilities.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Amol on 3/31/17.
 */
public class KeywordSearchTest {


    WebDriver driver;
    Utils utils = new Utils();
    private static final String fileName = System.getProperty("user.dir") + File.separator + "Resources" + File.separator
            + "Keyword.txt";
    private FileReader fr = null;
    private BufferedReader br = null;

    @Before
    public void clearSession(){
        driver = utils.Initialize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testAboutUs(){
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                driver.get(utils.getValue("config", "google"));
                GooglePage gp = new GooglePage(driver);
                gp.enterGoogleSearch(currentLine);
                Assert.assertTrue(gp.googleUrlValidator(currentLine));
            }
        }
        catch (FileNotFoundException e) {
            System.out.print("Issue retrieving the file" + e.getMessage());
        }
        catch (IOException e) {
            System.out.print("Issue reading the file" + e.getMessage());
        }
    }

    @After
    public void destruct(){
        driver.quit();
    }

}
