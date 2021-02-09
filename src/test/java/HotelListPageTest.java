import config.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.HotelListPage;

import java.time.LocalDate;

public class HotelListPageTest {

    @Test
    public void enterDate () {
        WebDriver driver = WebDriverFactory.FIREFOX.create();
        driver.get("https://booking.com/");
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.enterCity("Warszawa");
        homePage.clickCheckInButton();
        homePage.selectCheckInDate(LocalDate.of(2021, 02, 27));
        homePage.clickCheckOutButton();
        homePage.clickCheckOutButton();
        homePage.selectCheckOutDate(LocalDate.of(2021, 02, 28));
        HotelListPage hotelListPage = homePage.clickSearchButton("Warszawa");
        hotelListPage.clickAvailabilityByHotelName("GO");


    }

    @Test
    public void findHotelByHotelName (){
        WebDriver driver = WebDriverFactory.FIREFOX.create();
        driver.get("https://www.booking.com");
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.enterCity("Warszawa");
        homePage.clickCheckInButton();
        homePage.selectCheckInDate(LocalDate.of(2021, 02, 27));
        homePage.clickCheckOutButton();
        homePage.clickCheckOutButton();
        homePage.selectCheckOutDate(LocalDate.of(2021, 02, 28));
        HotelListPage hotelListPage = homePage.clickSearchButton("Warsaw");
        hotelListPage.clickAvailabilityButtonByHotelName("GO Apartments");

    }
}
