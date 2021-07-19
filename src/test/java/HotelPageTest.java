import config.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.HotelListPage;
import pages.HotelPage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelPageTest {

    @Test
//    @Description ("Selecting a room in the chosen hotel")
    public void goToReservationPage() {
        WebDriver driver = WebDriverFactory.CHROME.create();
        driver.get("https://booking.com");
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.enterCity("Tokio");
        homePage.clickCheckInButton();
        homePage.selectCheckInDate(LocalDate.of(2021, 5, 1));
        homePage.clickCheckOutButton();
        homePage.clickCheckOutButton();
        homePage.selectCheckOutDate(LocalDate.of(2021, 5, 2));
        HotelListPage hotelListPage = homePage.clickSearchButton("Tokio");
        HotelPage hotelPage = hotelListPage.clickAvailabilityByHotelName("The Royal Park Hotel Tokyo Haneda");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        hotelPage.clickReservationButton();
        hotelPage.selectRoomByTypeAndNumberOfGuests("Oferta specjalna - Pokój dwuosobowy",
              "2", "1"  );
        hotelPage.bookSelectedRoomButton("The Royal Park Hotel Tokyo Haneda");
    }
}
