import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by MANOR on 4/18/2016.
 */
public class SearchTrain {

    public static void main(String args[]) throws IOException, InterruptedException {

        String expectedValue = "The email and password you enteed don't match.";
        String actualValue = "";
        String strAlertText;


        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.gmail.com");

        Thread.sleep(2000);




        driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("elakkiyabalurajesh");
        driver.findElement(By.xpath(".//*[@id='next']")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("Passwd")).sendKeys("9965318987");
        driver.findElement(By.xpath(".//*[@id='PersistentCookie']")).click();
        driver.findElement(By.xpath(".//*[@id='signIn']")).click();
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            // now copy the  screenshot to desired location using copyFile //method
        FileUtils.copyFile(src, new File("D:/error.png"),true);
        //driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
        actualValue=driver.findElement(By.xpath(".//*[@id='errormsg_0_Passwd']")).getText();
        if (actualValue.contentEquals(expectedValue)) {
            System.out.println("content matches");

        } else
            System.out.print("content doesnt match");
        driver.quit();






        // if (actualValue.contentEquals(expectedValue)) {
         //   System.out.println("content matches");

       // } else
        //    System.out.print("content doesnt match");
        driver.quit();


    }
}
