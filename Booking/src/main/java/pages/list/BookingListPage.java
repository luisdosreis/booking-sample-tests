package pages.list;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.common.Component;
import pages.common.Page;
import pages.main.SearchBar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingListPage extends Component implements Page {



    @Override
    public String url() {
        return "https://www.booking.com";
    }

    @Override
    public void open() {
        goTo(url());
    }

    public LeftSearchBox leftSearchBox() {
        return new LeftSearchBox();
    }

    public PropertiesList propertiesList()  {
        return new PropertiesList();
    }
}
