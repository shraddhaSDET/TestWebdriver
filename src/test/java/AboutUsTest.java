import Pageobjects.AboutUsPage;
import Pageobjects.GooglePage;
import Utilities.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AboutUsTest {

    WebDriver driver;
    Utils utils = new Utils();


    @Before
    public void clearSession(){
        driver = utils.Initialize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testAboutUs(){
        System.out.print("getting google");
        driver.get(utils.getValue("config", "google"));
        AboutUsPage ap=new AboutUsPage(driver);
        GooglePage gp = new GooglePage(driver);
        gp.enterGoogleSearch("Kargo");
        gp.clickResult("http://www.kargo.com/");
        ap.aboutUs();
    }

    @After
    public void destruct(){
        driver.quit();
    }

}
