import config.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.By;
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
//        homePage.acceptCookies();
        homePage.enterCity("Warszawa");
        homePage.clickCheckInButton();
        homePage.selectCheckInDate(LocalDate.of(2021, 2, 27));
        homePage.clickCheckOutButton();
        homePage.clickCheckOutButton();
        homePage.selectCheckOutDate(LocalDate.of(2021, 2, 28));
        HotelListPage hotelListPage = homePage.clickSearchButton("Warsaw");
        HotelPage hotelPage = hotelListPage.clickAvailabilityByHotelName("Novotel");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        hotelPage.clickReservationButton();
        hotelPage.selectNumberOfBedsInChosenRoom("Superior", 50);




    }
}
