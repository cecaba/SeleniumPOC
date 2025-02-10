package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Sets;
import pages.BasePage;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    private final String SITE_URL = "https://github.com/";
    private final String someVariable = "text";
    public final String HOME_PAGE_TITLE = "Build and ship software on a single, collaborative platform";
    @BeforeTest
    public void startSeleniumSession(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void takeScreenshotOfFailedTest(ITestResult testResult){
        if(ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/"
                    + testResult.getName() + System.currentTimeMillis() + ".png");
            try{
                FileHandler.copy(source, destination);
            } catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
        driver.quit();
    }

    public void openHomePage(){
        driver.get(SITE_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();
    }

    public void verifyHomePageTitle(){
        assertEquals(homePage.getHomePageTitle(), HOME_PAGE_TITLE, "Title is not correct");
    }
}
