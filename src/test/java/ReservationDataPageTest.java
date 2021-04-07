import config.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.HotelListPage;
import pages.HotelPage;
import pages.ReservationDataPage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDataPageTest {

    @Test
    public void confirmReservation() {
        WebDriver driver = WebDriverFactory.CHROME.create();
        driver.get("https://booking.com");
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.enterCity("Warszawa");
        homePage.clickCheckInButton();
        homePage.selectCheckInDate(LocalDate.of(2021, 4, 16));
        homePage.clickCheckOutButton();
        homePage.clickCheckOutButton();
        homePage.selectCheckOutDate(LocalDate.of(2021, 4, 17));
        HotelListPage hotelListPage = homePage.clickSearchButton("Warszawa");
        HotelPage hotelPage = hotelListPage.clickAvailabilityByHotelName("Radisson");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        hotelPage.clickReservationButton();
        hotelPage.selectRoomByTypeAndNumberOfGuests("Pokój Collection", "2", "1");
        ReservationDataPage reservationDataPage = hotelPage.bookSelectedRoomButton("Radisson Collection Hotel, Warsaw");
        reservationDataPage.enterGuestData();
//        reservationDataPage.selectBusinessOrLeisureTripRadio();
//        reservationDataPage.bla();


    }
}