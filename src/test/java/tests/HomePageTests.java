package tests;

import org.testng.annotations.Test;

public class HomePageTests extends BaseTest{
    @Test
    public void verifyTitle(){
        openHomePage();
        verifyHomePageTitle();
    }
}
