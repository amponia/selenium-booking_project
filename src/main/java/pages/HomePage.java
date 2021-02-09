package pages;

import config.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.util.List;

public class HomePage extends PageObject {

    @FindBy(id = "ss")
    private WebElement cityInput;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement consentButton;

    @FindBy(className = "xp__dates__checkin")
    private WebElement checkInButton;

    @FindBy(className = "xp__dates__checkout")
    private WebElement checkOutButton;

    @FindBy(className = "bui-calendar__date")
    private List<WebElement> dates;

    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    private WebElement nextMonthButton;

    @FindBy(className = "sb-searchbox__button")
    private WebElement searchButton;

    @FindBy(className = "xp__travel-purpose")
    private WebElement businessTripCheckbox;

    @FindBy(className = "sb-searchbox__error")
    private WebElement errorCityMsg;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(consentButton));
        consentButton.click();
    }

    public void enterCity(String text) {
        cityInput.clear();
        cityInput.sendKeys(text);

    }

    public void clickCheckInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkInButton));
        checkInButton.click();
    }

    //selectCheckInDate do Cucumbera (String date)
    public void selectCheckInDate(String date) {
        wait.until(ExpectedConditions.elementToBeClickable(nextMonthButton));
        for (WebElement element : dates) {
            if (date.equals(element.getAttribute("data-date"))) {
                element.click();
            }
        }
    }

    //    selectCheckInDate bez Cucumbera (LocalDate date)
    public void selectCheckInDate(LocalDate date) {
        wait.until(ExpectedConditions.elementToBeClickable(nextMonthButton));
        for (WebElement element : dates) {
            if (date.toString().equals(element.getAttribute("data-date"))) {
                element.click();
            }
        }
    }


    public void clickCheckOutButton() {
        checkOutButton.click();
    }


    public void selectCheckOutDate(LocalDate date) {
        for (WebElement element : dates) {
            if (date.toString().equals(element.getAttribute("data-date"))) {
                element.click();
            }
        }
    }

    public void clickSearchButtonWithoutRedirect() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

    }

    public String getCityErrorMessage() {

        return errorCityMsg.getText();
    }

    public void selectBusinessTripCheckbox() {
        businessTripCheckbox.click();
    }

    public HotelListPage clickSearchButton(String cityName) {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new HotelListPage(driver, cityName);
    }


}

