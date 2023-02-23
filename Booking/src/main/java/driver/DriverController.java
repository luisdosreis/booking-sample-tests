package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static browser.BrowserOptions.WINDOW_SIZE_H;
import static browser.BrowserOptions.WINDOW_SIZE_W;

public class DriverController {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverController() {}

    public static WebDriver current() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(WINDOW_SIZE_W, WINDOW_SIZE_H));
        DriverController.driver.set(driver);
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
