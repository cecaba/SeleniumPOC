package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By homePageTitle = By.xpath("//head/title");

    public String getHomePageTitle(){
        waitForElementPresence(homePageTitle);
        return getTitleText(homePageTitle);
    }
}
