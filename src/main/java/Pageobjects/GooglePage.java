package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage {

    WebDriver driver;

    public GooglePage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickResult(String href) {
        String xpath = ".//a[@href='" + href + "']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void enterGoogleSearch(String text) {
        driver.findElement(By.xpath(".//input[@name='q']")).click();
        driver.findElement(By.xpath(".//input[@name='q']")).sendKeys(text);
        driver.findElement(By.xpath(".//input[@name='q']")).sendKeys(Keys.ENTER);
    }
}
