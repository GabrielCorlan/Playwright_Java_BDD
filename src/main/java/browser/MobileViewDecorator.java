package browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;

import java.util.List;

public class MobileViewDecorator implements BrowserContextDecorator {

    private Browser browser;

    @Override
    public BrowserContext decorate(BrowserContext context, Browser browser) {
        this.browser = browser;
        return browser.newContext(
                new Browser.NewContextOptions()
                        .setUserAgent("Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3765.0 Mobile Safari/537.36")
                        .setViewportSize(411, 731)
                        .setDeviceScaleFactor(2.625)
                        .setIsMobile(true)
                        .setHasTouch(true)
                        .setLocale("en-US")
                        .setGeolocation(41.889938, 12.492507)
                        .setPermissions(List.of("geolocation"))
        );
    }
}
