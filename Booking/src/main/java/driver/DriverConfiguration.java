package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static browser.BrowserOptions.*;

public class DriverConfiguration {

    public static WebDriver setupChrome() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        if(RUN_MAXIMIZED) chromeOptions.addArguments(START_MAXIMIZED);
        chromeOptions.addArguments(DISABLE_INFOBARS);
        chromeOptions.addArguments(DISABLE_NOTIFICATIONS);
        if(RUN_HEADLESS) chromeOptions.addArguments(HEADLESS_NEW);

        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver setupFirefox() {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if(RUN_MAXIMIZED) firefoxOptions.addArguments(START_MAXIMIZED);
        firefoxOptions.addArguments(HEADLESS);

        return new FirefoxDriver(firefoxOptions);
    }
}
