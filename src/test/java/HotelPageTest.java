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
        homePage.enterCity("Warszawa");
        homePage.clickCheckInButton();
        homePage.selectCheckInDate(LocalDate.of(2021, 4, 16));
        homePage.clickCheckOutButton();
        homePage.clickCheckOutButton();
        homePage.selectCheckOutDate(LocalDate.of(2021, 4, 17));
        HotelListPage hotelListPage = homePage.clickSearchButton("Warszawa");
        HotelPage hotelPage = hotelListPage.clickAvailabilityByHotelName("Novotel");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        hotelPage.clickReservationButton();
        hotelPage.selectRoomByTypeAndNumberOfGuests("Pokój typu Superior z łóżkiem typu queen-size",
              "2", "3"  );
        hotelPage.bookSelectedRoomButton("Novotel Warszawa Centrum");
    }
}
