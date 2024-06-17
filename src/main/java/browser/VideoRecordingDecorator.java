package browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;

import java.nio.file.Path;
import java.nio.file.Paths;

public class VideoRecordingDecorator implements BrowserContextDecorator {

    private Browser browser;

    @Override
    public BrowserContext decorate(BrowserContext context, Browser browser) {
        this.browser = browser;
        String workingDirectory = System.getProperty("user.dir");
        Path executionVideosFolder = Paths.get(workingDirectory, "videos");
        String path = executionVideosFolder.toString();

        return browser.newContext(
                new Browser.NewContextOptions()
                        .setRecordVideoDir(Paths.get(path))
                        .setRecordVideoSize(1280, 720)
        );
    }
}
