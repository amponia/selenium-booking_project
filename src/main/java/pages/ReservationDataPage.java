package pages;

import config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ReservationDataPage extends PageObject {

    @FindBy (name = "firstname")
    WebElement firstNameInput;

    @FindBy (name = "lastname")
    WebElement lastNameInput;

    @FindBy (name = "email")
    WebElement emailAddressInput;

    @FindBy (name = "email_confirm")
    WebElement emailConfirmationInput;

    @FindBy (xpath = "//div[@class = 'bp_sidebar_content_block bp_sidebar_content_block--bookingdetails_summary']/div/h2")
    WebElement yourReservationDetailsHeader;

    public ReservationDataPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(yourReservationDetailsHeader, "Dane Twojej rezerwacji"));
    }


}
