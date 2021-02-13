package pages;

import config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HotelPage extends PageObject {

    @FindBy(tagName = "h2")
    private WebElement hotelNameHeader;

    @FindBy(xpath = "//*[@id = \"hp_book_now_button\"]")
    private WebElement goToReservationButton;

    @FindBy(className = "hprt-roomtype-link")
    private List<WebElement> accomodationType;

    @FindBy(xpath = "//class[@contains = \"hprt-roomtype-icon-link\" ]")
    WebElement selectNumberOfBedsButton;

    @FindBy(className = "bui-price-display__value")
    WebElement roomPrice;

    @FindBy(className = "hprt-reservation-cta")
    WebElement reservationButton;

    public HotelPage(WebDriver driver, String hotelName) {
        super(driver);
//        wait.until(ExpectedConditions.textToBePresentInElement(hotelNameHeader, hotelName));
    }

    public void clickReservationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(reservationButton));
        goToReservationButton.click();

    }

    public void selectNumberOfBedsInChosenRoom(String roomName, int availableBudget) {
        for (WebElement element : accomodationType) {
            if ((element.toString()).contains(roomName)) {
                if ((Integer.parseInt(String.valueOf(roomPrice))) > availableBudget) {
                    Select numberOfBeds = new Select(selectNumberOfBedsButton);
                    numberOfBeds.selectByIndex(2);
                }
            }
        }
    }
}