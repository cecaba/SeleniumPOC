package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By homePageTitle = By.xpath("//h1[contains(@class, 'Primer_Brand')]");

    public String getHomePageTitle(){
        waitForElementPresence(homePageTitle);
        return getTitleText(homePageTitle);
    }
}
