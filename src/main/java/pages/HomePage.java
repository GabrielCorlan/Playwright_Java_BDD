package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage extends BasePage {

    Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void clickLoginButton() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in"))
                .click();
    }
    public void clickRegisterButton() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create an Account"))
                .click();
    }
}
