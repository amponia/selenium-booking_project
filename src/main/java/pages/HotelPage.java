package pages;

import config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelPage extends PageObject {

    @FindBy (tagName = "h2")
    private WebElement hotelNameHeader;

    @FindBy (id = "b_tt_holder_1")   //previous: bui-button__text
    private WebElement reservationButton;

    public HotelPage(WebDriver driver, String hotelName) {
        super(driver);
//        wait.until(ExpectedConditions.textToBePresentInElement(hotelNameHeader, hotelName));
    }

    public ReservationDataPage clickReservationButton () {
        wait.until(ExpectedConditions.elementToBeClickable(reservationButton));
        reservationButton.click();

        return new ReservationConfirmationPage(driver);
    }


}
