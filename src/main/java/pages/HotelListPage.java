package pages;

import config.PageObject;
import exception.ElementNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HotelListPage extends PageObject {

    @FindBy(className = "sr-cta-button-row")
    private List<WebElement> availabilityButtons;

    @FindBy (className = "sr-hotel__name")
    private List <WebElement> hotelNames;

    @FindBy (tagName = "h2")
    private WebElement cityName;

    public HotelListPage(WebDriver driver, String city) {
        super(driver);
        wait.until(ExpectedConditions.textToBePresentInElement(cityName, city));
    }

    public HotelPage clickAvailabilityButtonByHotelName (String hotelName) {
        for (int i = 0; i < hotelNames.size(); i++) {
            if (hotelName.equals(hotelNames.get(i).getText()) ) {
                availabilityButtons.get(i).click();
                return new HotelPage(driver, hotelName);
            }

        }
        throw new ElementNotFoundException(hotelName);
    }

    public HotelPage clickAvailabilityByHotelName(String hotelName) {
        for (int i = 0; i < hotelNames.size(); i++) {
            if (hotelNames.get(i).getText().contains(hotelName)) {
                availabilityButtons.get(i).click();
                return new HotelPage(driver, hotelName);
            }
        }
        throw new ElementNotFoundException(hotelName);
    }
}
