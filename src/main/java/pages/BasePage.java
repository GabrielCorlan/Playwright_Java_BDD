package pages;

import browser.BrowserManager;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class BasePage {

    public static Browser browser;
    public static Page page;



    public void setupPage() {
        browser = BrowserManager.createPlaywrightBrowserInstance("Chromium");
        page = browser.newPage();
        page.navigate("https://magento.softwaretestingboard.com/");
    }
}
