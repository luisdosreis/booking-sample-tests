package common;

import browser.Browsers;
import config.ConfigurationManager;
import driver.DriverController;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import runner.RunFactory;
import runner.RunTarget;

public class BaseTest {
    @BeforeClass
    public void setup() {

        ConfigurationManager.init();

        WebDriver driver = new RunFactory().init(RunTarget.LOCAL, Browsers.CHROME);
        DriverController.setDriver(driver);
    }

    @AfterClass
    public void afterSuite() {
        DriverController.quitDriver();
    }
}
