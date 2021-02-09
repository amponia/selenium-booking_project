import config.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelPageTest {

    @Test
    public void goToReservationPage() {
        WebDriver driver = WebDriverFactory.CHROME.create();
        driver.get("https://booking.com");
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.enterCity("Warszawa");
        homePage.clickCheckInButton();
//        select CheckInDate do Cucumbera
        homePage.selectCheckInDate(LocalDate.of(2021, 2, 27));
//        select CheckInDate bez Cucumbera
//        homePage.selectCheckInDate(LocalDate.of(2021, 2, 5));
        homePage.clickCheckOutButton();
        homePage.clickCheckOutButton();
        homePage.selectCheckOutDate(LocalDate.of(2021, 2, 28));
        HotelListPage hotelListPage = homePage.clickSearchButton("Warszawa");
        HotelPage hotelPage = hotelListPage.clickAvailabilityByHotelName("GO");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        ReservationDataPage reservationDataPage = hotelPage.clickReservationButton();


    }
}
