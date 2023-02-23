package pages.common;

import driver.DriverController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import static runner.RunSpecs.FIND_WAIT_TIME;

public class Component {

    private static final Logger logger = LoggerFactory.getLogger(Component.class);

    protected static void goTo(String url) {
        DriverController.current().get(url);
    }

    protected static WebElement findElement(By locator) {

        WebElement element = new WebDriverWait(DriverController.current(), FIND_WAIT_TIME).until(driver -> driver.findElement(locator));

        return element;
    }

    protected static void waitToBeClickable(By locator) {
        new WebDriverWait(DriverController.current(), FIND_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected static void waitToBeClickable(WebElement element) {
        new WebDriverWait(DriverController.current(), FIND_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected static void waitToBeVisible(By locator) {
        new WebDriverWait(DriverController.current(), FIND_WAIT_TIME).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected static List<WebElement> findElements(By locator) {

        List<WebElement> webElementList = new WebDriverWait(DriverController.current(), FIND_WAIT_TIME).until(driver -> driver.findElements(locator));

        return webElementList;
    }

    protected static void click(By locator) {
        findElement(locator).click();
    }

    protected static void defaultContent() {
        DriverController.current().switchTo().defaultContent();
    }

    protected static void inputText(By locator, String chars) {
        findElement(locator).sendKeys(chars);
    }

    protected static void typeInputText(By locator, String text) {

        WebElement element = findElement(locator);

        Random r = new Random();
        for(int i = 0; i < text.length(); i++) {
            try {
                Thread.sleep(70);
            } catch(InterruptedException e) {}
            String s = new StringBuilder().append(text.charAt(i)).toString();
            element.sendKeys(s);
        }
    }

    protected static void pickListOption(By locator, String value) {

        List<WebElement> options = findElements(locator);

        for( WebElement option : options) {
            if(value.contains(option.getText().trim())) {
                option.click();
                break;
            }
        }
    }

    protected static void pickDate(By locator, LocalDate date) {

        List<WebElement> dates = findElements(locator);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(dateTimeFormatter);

        for(WebElement day : dates) {

            String dateData = day.getAttribute("data-date") != null ? day.getAttribute("data-date") : "";

            if(dateData.equals(formattedDate)) {
                waitToBeClickable(day);
                day.click();
                break;
            }
        }
    }

    protected static void pressEscape() {
        Actions action = new Actions(DriverController.current());
        action.sendKeys(Keys.ESCAPE).build().perform();
    }

    protected static void waitInvisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverController.current(), FIND_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOf(DriverController.current().findElement(locator)));
    }
}
