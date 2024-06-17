package steps;

import pages.BasePage;
import pages.HomePage;
import pages.RegisterPage;

public class BaseSteps {

    HomePage homePage;
    RegisterPage registerPage;

    public void setup() {
        BasePage basePage = new BasePage();
        basePage.setupPage();
        homePage = new HomePage(BasePage.page);
        registerPage = new RegisterPage(BasePage.page);
    }
}
