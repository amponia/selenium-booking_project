import config.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ReservationPageTest{

    @Test
    public void bookARoomInSelectedHotel () {
    WebDriver driver = WebDriverFactory.CHROME.create();
    driver.get ("https://www.booking.com/hotel/pl/radissonsascentrumwarszawa.pl.html?label=gen173nr-1FCAEoggI46AdIM1gEaLYBiAEBmAEeuAEXyAEM2AEB6AEB-AELiAIBqAIDuALsqYyABsACAdICJGNhZTU4NGVjLTkxMWEtNGYyMy04ZGM0LTExMmMxZWVmMTYwN9gCBuACAQ;sid=93aa6b1c852b12247051f7351b7f3d4e;all_sr_blocks=8982126_255463199_2_2_0;checkin=2021-02-15;checkout=2021-02-17;dest_id=-534433;dest_type=city;dist=0;group_adults=2;group_children=0;hapos=4;highlighted_blocks=8982126_255463199_2_2_0;hpos=4;no_rooms=1;room1=A%2CA;sb_price_type=total;sr_order=popularity;sr_pri_blocks=8982126_255463199_2_2_0__90396;srepoch=1610814716;srpvid=ea82743d3c13013a;type=total;ucfs=1&#tab-main");
    /*HomePage homePage = new HomePage(driver);
    homePage.acceptCookies();
    homePage.enterCity("Warszawa");
    homePage.clickCheckInButton();
    homePage.selectCheckInDate(LocalDate.of(2021,2,15));
    homePage.clickCheckOutButton();
    homePage.clickCheckOutButton();
    homePage.selectCheckOutDate(LocalDate.of(2021, 2,17));
    HotelListPage hotelListPage = homePage.clickSearchButton("Warszawa");
    HotelPage hotelPage = hotelListPage.clickAvailabilityByHotelName("Radisson");
    List <String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));*/
    ReservationConfirmationPage reservationPage = new ReservationConfirmationPage(driver);
    reservationPage.acceptCookies();
    reservationPage.selectBedsInAHotel();
    ReservationDataPage reservationData = reservationPage.bookSelectedRoom();
}
}