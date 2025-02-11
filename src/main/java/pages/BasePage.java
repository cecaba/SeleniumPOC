package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected String getTitleText(By locator){
        return find(locator).getDomProperty("text");
    }

    protected void waitForElementPresence(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
