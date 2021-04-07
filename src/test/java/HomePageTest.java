import config.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.time.LocalDate;


public class HomePageTest {

    @Test
    public void szukajHotelu() throws InterruptedException, IOException {
        WebDriver driver = WebDriverFactory.FIREFOX.create();
        driver.get("https://booking.com/");
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.enterCity("Tokyo");
        homePage.clickCheckInButton();
        homePage.selectCheckInDate(LocalDate.of(2021, 02, 15));
        homePage.clickCheckOutButton();
        homePage.clickCheckOutButton();
        homePage.selectCheckOutDate(LocalDate.of(2021, 02, 17));
        homePage.clickSearchButton("Tokyo");
    }
}