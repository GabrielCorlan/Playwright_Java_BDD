package pages;

import com.microsoft.playwright.Page;

public class RegisterPage extends BasePage{

    Page page;

    public RegisterPage(Page page) {
        this.page = page;
    }

    public void inputFirstName() {
        page.click("#firstname");
    }
}
