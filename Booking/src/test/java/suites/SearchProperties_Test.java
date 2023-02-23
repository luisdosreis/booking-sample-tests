package suites;

import common.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.Locations;
import pages.list.BookingListPage;
import pages.main.BookingIndexPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Locale;

public class SearchProperties_Test extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(SearchProperties_Test.class);
    private LocalDate firstDayOfNextMonth;
    private LocalDate seventhDayOfNextMonth;

    @Test(description = "Search Porto Properties Next Month", groups = { "main-search" })
    public void mainSearchPropertiesPortoNextMonth() {

        firstDayOfNextMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        seventhDayOfNextMonth = firstDayOfNextMonth.plusDays(6);

        BookingIndexPage indexPage = new BookingIndexPage();
        indexPage.open();
        indexPage.acceptCookies();
        indexPage.searchBar().pickLocation(Locations.PORTO);
        indexPage.searchBar().pickDates(firstDayOfNextMonth, seventhDayOfNextMonth);
        indexPage.searchBar().search();
    }

    @Test(description = "Count Porto Properties Next Month", dependsOnGroups = { "main-search" })
    public void listPropertiesPortoNextMonth_NumberProperties() {

        BookingListPage listPage = new BookingListPage();
        int numberOfProperties = listPage.propertiesList().getNumberOfProperties();

        logger.info("Number of Properties: " + numberOfProperties);

        Assert.assertTrue(numberOfProperties > 0, "Could not find the number of Properties.");
    }

    @Test(description = "Print Porto Properties Next Month", dependsOnGroups = { "main-search" })
    public void listPropertiesPortoNextMonth_PrintProperties() {

        BookingListPage listPage = new BookingListPage();
        List<String> listOfProperties = listPage.propertiesList().getNamesOfProperties();

        logger.info("List of Properties: ");
        for(String name : listOfProperties) logger.info(name);

        Assert.assertTrue(listOfProperties.size() > 0, "Could not find the Properties names.");
    }

    @Test(description = "Check In Search Date Corresponds", dependsOnGroups = { "main-search" })
    public void leftCheckInDate_CorrespondsToSearch() {

        BookingListPage listPage = new BookingListPage();
        String date = listPage.leftSearchBox().getCheckInDateText();

        Assert.assertEquals(cleanDate(date, firstDayOfNextMonth),getFormattedDate(date, firstDayOfNextMonth), "CheckIn Dates do not match.");
    }

    @Test(description = "Check Out Search Date Corresponds", dependsOnGroups = { "main-search" })
    public void leftCheckOutDate_CorrespondsToSearch() {

        BookingListPage listPage = new BookingListPage();
        String date = listPage.leftSearchBox().getCheckOutDateText();

        Assert.assertEquals(cleanDate(date, seventhDayOfNextMonth),getFormattedDate(date, seventhDayOfNextMonth), "CheckOut Dates do not match.");
    }

    private String getFormattedDate(String actual, LocalDate expected) {

        String year = "" + expected.getYear();

        DateTimeFormatter dateTimeFormatter;

        if(actual.contains(year)) {
            // Wednesday 1 March 2023
            dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.ENGLISH);
        } else {
            // Wed 1 Mar
            dateTimeFormatter = DateTimeFormatter.ofPattern("EEE d MMM", Locale.ENGLISH);
        }

        return expected.format(dateTimeFormatter);
    }

    private String cleanDate(String actual, LocalDate expected) {

        String dayWeek = expected.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

        return actual.substring(actual.indexOf(dayWeek));
    }
}
