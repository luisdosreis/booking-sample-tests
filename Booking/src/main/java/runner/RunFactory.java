package runner;

import browser.Browsers;
import driver.DriverConfiguration;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static java.lang.String.format;

public class RunFactory {

    public WebDriver init(RunTarget environment, Browsers browser) {

        switch (environment) {
            case LOCAL: return createLocalInstance(browser);
            case SELENIUM_GRID: return createRemoteInstance(browser);
        };
        return null;
    }

    private WebDriver createLocalInstance(Browsers browser) {

        switch (browser) {
            case CHROME: return DriverConfiguration.setupChrome();
            case FIREFOX: return DriverConfiguration.setupFirefox();
        };

        return null;
    }

    private RemoteWebDriver createRemoteInstance(Browsers browser) {
        throw new NotImplementedException();
    }
}
