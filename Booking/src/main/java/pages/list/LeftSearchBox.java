package pages.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.common.Component;
import pages.common.Locations;

import java.time.LocalDate;

public class LeftSearchBox extends Component {
    private static By checkInDateText = new By.ByCssSelector("div[data-testid='searchbox-layout-vertical'] button[data-testid='date-display-field-start']");
    private static By checkOutDateText = new By.ByCssSelector("div[data-testid='searchbox-layout-vertical'] button[data-testid='date-display-field-end']");

    public static String getCheckInDateText() {

        WebElement element = findElement(checkInDateText);

        String text = element.getText();

        return text;
    }

    public static String getCheckOutDateText() {

        WebElement element = findElement(checkOutDateText);

        String text = element.getText();

        return text;
    }
}
