package pages.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.common.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesList extends Component {
    private static By numberOfProperties = new By.ByCssSelector("div[id='searchresultsTmpl'] div[id='right'] h1");
    private static By namesOfProperties = new By.ByCssSelector("div[data-testid='property-card'] div[data-testid='title']");

    public static int getNumberOfProperties() {

        WebElement element = findElement(numberOfProperties);

        String text = element.getText();
        String strPattern = "\\d+";
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(text);

        String numberText = "";
        while( matcher.find() ) {
            numberText += matcher.group();
        }

        int count = Integer.parseInt(numberText);

        return count;
    }

    public List<String> getNamesOfProperties() {

        List<WebElement> properties = findElements(namesOfProperties);

        List<String> propertiesNames = new ArrayList<>();

        int i = 1;
        for(WebElement property : properties) {
            String name = property.getText();
            propertiesNames.add(name);
        }

        return propertiesNames;
    }
}
