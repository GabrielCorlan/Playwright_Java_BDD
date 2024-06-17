package browser;

import com.microsoft.playwright.*;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserManager {

    private static Browser browser;

    public static final Map<String, Supplier<BrowserContextDecorator>> decorators =
            Map.of(
                    "mobileView", MobileViewDecorator::new,
                    "videoRecording", VideoRecordingDecorator::new
            );

    public static Browser createPlaywrightBrowserInstance(String browserTypeAsString) {
        BrowserType browserType =
                switch (browserTypeAsString) {
                    case "Firefox" -> Playwright.create().firefox();
                    case "Chromium" -> Playwright.create().chromium();
                    case "Webkit" -> Playwright.create().webkit();
                    default -> null;
                };
        if (browserType == null) {
            throw new IllegalArgumentException("Could not launch a browser");
        }

        return browserType.launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(List.of("--start-fullscreen"))
        );
    }

    public static BrowserContext createBrowserContext() {
        String browserType = System.getProperty("browserType");
        Browser browser = createPlaywrightBrowserInstance(browserType);
        BrowserContext browserContext = browser.newContext();

        for (String property : decorators.keySet()) {
            String propertyValue = System.getProperty(property);
            if (propertyValue != null && propertyValue.equalsIgnoreCase("true")) {
                decorators.get(property).get().decorate(browserContext, browser);
            }
        }

        return browserContext;
    }

    public static BrowserContext accumulateDecorators(BrowserContext context, Browser browser, List<BrowserContextDecorator> decorators) {
        for (BrowserContextDecorator decorator : decorators) {
            decorator.decorate(context, browser);
        }
        return context;
    }
}
