package pages.main;

import org.openqa.selenium.By;
import pages.common.Component;
import pages.common.Page;

public class BookingIndexPage extends Component implements Page {

    private By acceptCookiesButton = new By.ById("onetrust-accept-btn-handler");

    public void acceptCookies() {

        click(acceptCookiesButton);
        waitInvisibility(acceptCookiesButton);
        defaultContent();
    }

    public SearchBar searchBar() {
        return new SearchBar();
    }

    @Override
    public String url() {
        return "https://www.booking.com/index.en-gb.html";
    }

    @Override
    public void open() {
        goTo(url());
    }
}
