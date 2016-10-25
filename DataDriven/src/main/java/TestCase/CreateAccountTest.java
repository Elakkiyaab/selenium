package TestCase;


import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.base.Splitter;

import PageObjects.CreateAccountPage;
import TestData.ExcelUtils;
import data.User;
//http://www.techbeamers.com/websites-to-practice-selenium-webdriver-online/

public class CreateAccountTest {
    public static final String FILE_PATH = "D:\\Project\\selenium\\DataDriven\\src\\main\\resources\\DataProvider.xls";
    public static final String DATA_PROVIDER_USER = "user";
    WebDriver driver;
    CreateAccountPage createAccountPage;
    private String sTestCaseName = "test1";


    @BeforeTest
    public void siteNavigation() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");
        createAccountPage = new CreateAccountPage(driver);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


    @Test(dataProvider = DATA_PROVIDER_USER)
    public void clickSignIn(final User user) throws Exception {
        createAccountPage.clickSignInElement();
        createAccountPage.setEmailid(user.getEmail());
        System.out.println(sTestCaseName +"executed successfully");
    }


    @DataProvider(name = DATA_PROVIDER_USER)
    public Object[][] Authentication() throws Exception {
        try {
            List<String> testData =  ExcelUtils.getTestData(FILE_PATH, DATA_PROVIDER_USER, sTestCaseName);
            return ExcelUtils.getTestDataArray(testData);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }





}



