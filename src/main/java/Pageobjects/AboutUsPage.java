package Pageobjects;

import Utilities.Utils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Amol on 3/29/17.
 */
public class AboutUsPage {

    WebDriver driver;
    Utils utils = new Utils();

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void aboutUs() {
        getMenu().click();
        getMenuItem(4).click();
        String t = driver.findElement(By.xpath(".//*[@id='page']/section[2]/div/h2")).getText();
        Assert.assertTrue(t.toLowerCase().
                equals(utils.getValue("Elements", "Text").toLowerCase()));
    }

    private WebElement getMenu() {
        return driver.findElement(By.xpath(".//*[@id='wrapper']/header/div/div/a[2]"));
    }

    private WebElement getMenuItem(Integer itemNumber) {
        return driver.findElement(By.xpath(".//ul[@id='menu-main-menu']/li[" + itemNumber + "]"));
    }
}
