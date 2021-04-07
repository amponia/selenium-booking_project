package pages;

import config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ReservationDataPage extends PageObject {

    @FindBy(xpath = "//input[@name='bp_travel_purpose'][@value='business']")
    WebElement businessTripCheckBox;

//    @FindBy (id = "bp_travel_purpose_business")
//    WebElement businessTripRadio;

    @FindBy(xpath = "//input[@value='leisure']")
    WebElement leisureTripRadio;

    @FindBy(xpath = "//input[@value='business']")
    WebElement businessTripRadio;

    @FindBy(name = "firstname")
    WebElement firstNameInput;

    @FindBy(name = "lastname")
    WebElement lastNameInput;

    @FindBy(name = "email")
    WebElement emailAddressInput;

    @FindBy(name = "email_confirm")
    WebElement emailConfirmationInput;

    @FindBy(xpath = "//label[@for='notstayer_false']")
    WebElement reservationForMyselfRadio;

//    @FindBy (xpath = "//div[@class = 'bp_sidebar_content_block bp_sidebar_content_block--bookingdetails_summary']/div/h2")
//    WebElement yourReservationDetailsHeader;

    @FindBy(xpath = "//h1[@class='bui-f-font-display_two js-property-details__name']")
    WebElement hotelNameHeader;

    public ReservationDataPage(WebDriver driver, String hotelName) {
        super(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(hotelNameHeader, hotelName));
    }
//
//    public void selectBusinessOrLeisureTripRadio () {
//        businessTripCheckBox.click();
//    }
    public void enterGuestData() {

        firstNameInput.sendKeys("Kasia");
        lastNameInput.sendKeys("Ziel");
        emailAddressInput.sendKeys("mail@mail.pl");
        emailConfirmationInput.sendKeys("mail@mail.pl");
        businessTripCheckBox.click();
        reservationForMyselfRadio.click();
    }
//    public void bla () {
//        reservationForMyselfRadio.click();
//    }


}



