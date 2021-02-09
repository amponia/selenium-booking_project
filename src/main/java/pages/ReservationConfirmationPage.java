package pages;

import config.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ReservationConfirmationPage extends PageObject {

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement consentButton;

    @FindBy(name = "nr_rooms_8982126_255463199_2_2_0")
    WebElement selectNumberOfBedsButton;

    @FindBy (className = "hprt-reservation-cta")
    WebElement reservationButton;

    public ReservationConfirmationPage(WebDriver driver) {

        super(driver);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        consentButton.click();
    }

    public void selectBedsInAHotel() {
        selectNumberOfBedsButton.click();
        Select numberOfBeds = new Select(driver.findElement(By.name("nr_rooms_8982126_255463199_2_2_0")));
        numberOfBeds.selectByIndex(4);
    }

    public ReservationDataPage bookSelectedRoom () {
        reservationButton.click();
        return new ReservationDataPage(driver);
    }
}
