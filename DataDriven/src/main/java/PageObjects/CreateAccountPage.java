package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CreateAccountPage {
    final WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSignInElement() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Sign in")).click();
    }

    //Set SignIn Button

    public void setEmailid(String strUserName) {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath(".//*[@id='email_create']")).sendKeys(strUserName);

    }
    public void clickCreateAccount() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.id("SubmitCreate")).click();

    }

    public void setGenderFemale() {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.id("id_gender2")).click();
    }

    public void setFirstName(String strFirstName) {
        driver.findElement(By.id("customer_firstname")).clear();

        driver.findElement(By.id("customer_firstname")).sendKeys(strFirstName);
    }

    public void setLastName(String strLastName) {
        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys(strLastName);
    }

    public void setPwd(String strPwd) {
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(strPwd);
    }

    public void setDOB() {

        new Select(driver.findElement(By.id("days"))).selectByVisibleText("regexp:2\\s+");
        driver.findElement(By.xpath("//option[@value='2']")).click();
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("regexp:January\\s");
        driver.findElement(By.xpath("(//option[@value='1'])[2]")).click();
        new Select(driver.findElement(By.id("years"))).selectByVisibleText("regexp:2016\\s+");
        driver.findElement(By.xpath("//option[@value='2016']")).click();
    }

    public void clicknewsletter() {
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
    }

    public void setCompany(String strCompany) {
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys(strCompany);
    }

    public void setAddress(String strAddress) {
        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys(strAddress);
    }

    public void setAdres(String strAdres) {
        driver.findElement(By.id("address2")).clear();
        driver.findElement(By.id("address2")).sendKeys(strAdres);
    }

    public void setCity(String strCity) {
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(strCity);
    }

    public void setState() {
        new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("strState");
        driver.findElement(By.xpath("(//option[@value='5'])[3]")).click();
    }

    public void setPostCode(String strPostCode) {

        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys(strPostCode);
    }

    public void setAddInfo(String strAddInfo) {
        driver.findElement(By.id("other")).clear();
        driver.findElement(By.id("other")).sendKeys(strAddInfo);
    }

    public void setHomeNumber(String strHomeNumber) {
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys(strHomeNumber);
    }

    public void setPhoneNumber(String strPhoneNumber) {
        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys(strPhoneNumber);

    }

    public void clickSubmit() {
        driver.findElement(By.id("submitAccount")).click();
    }


}