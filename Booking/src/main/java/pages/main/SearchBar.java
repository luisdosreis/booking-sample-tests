package pages.main;

import pages.common.Component;
import pages.common.Locations;
import org.openqa.selenium.By;

import java.time.LocalDate;

public class SearchBar extends Component {

    private static By whereAreYouGoing = new By.ByCssSelector("div[data-component='search/destination/input'] input, div[data-testid='destination-container'] input");

    private static By getWhereAreYouGoingPopUp = new By.ByCssSelector("div[data-testid='destination-container'], div[data-component='search/destination/input']");

    private static By getWhereAreYouGoingPopUpOptions = new By.ByCssSelector("div[data-testid='destination-container'] [data-testid='autocomplete-results'] [data-testid='autocomplete-result'] div div:nth-child(1)" +
            ", div[data-component='search/destination/input'] ul[role='listbox'] span[class='search_hl_name']");

    private static By searchBarDatePicker = new By.ByCssSelector("div[data-component='search/dates/single-calendar'] td[data-bui-ref='calendar-date'], div[data-testid='searchbox-datepicker'] span[role='checkbox']");

    private static By searchButton = new By.ByCssSelector("div[data-component='arp-searchbox-horizontal-index'] button[type='submit'], form[data-component='search/searchbox/searchbox-xp'] button[type='submit']");

    public void pickLocation(Locations location) {

        typeInputText(whereAreYouGoing, location.value);
        waitToBeVisible(getWhereAreYouGoingPopUp);
        waitToBeClickable(getWhereAreYouGoingPopUpOptions);
        pickListOption(getWhereAreYouGoingPopUpOptions, location.value);
    }

    public void pickDates(LocalDate inDate, LocalDate outDate) {

        defaultContent();
        pickDate(searchBarDatePicker, inDate);
        pickDate(searchBarDatePicker, outDate);
        pressEscape();
    }

    public void search() {

        defaultContent();
        click(searchButton);
    }
}
