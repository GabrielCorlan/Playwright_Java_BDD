package browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;

public interface BrowserContextDecorator {

    BrowserContext decorate(BrowserContext context, Browser browser);
}
