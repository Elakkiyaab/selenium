

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by MANOR on 4/18/2016.
 */
public class HelloWorld {

    public static void main(String args[]) {


        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.ns.nl/en");



        driver.quit();
    }
}