package pages;

import config.PageObject;
import model.RoomObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelPage extends PageObject {

    private Map<String, List<RoomObject>> roomGroupElements = new HashMap<>(); //inicjalizacja zmiennej przez konstruktor

    @FindBy(tagName = "h2")
    private WebElement hotelNameHeader;

    @FindBy(className = "hprt-reservation-cta")
    private WebElement reservationButton;

    @FindBy(id = "hprt-table")
    private WebElement roomTable;

    @FindBy(xpath = "//table[@id='hprt-table']/tbody/tr/td") //xpath, który szuka wszystkich tr, które są w td
    private List<WebElement> tableCells;

    @FindBy(className = "hprt-roomtype-icon-link")
    private List<WebElement> accomodationType;

    @FindBy(xpath = "//*[@id = \"hp_book_now_button\"]")
    private WebElement bookSelectedRoomButton;

    public HotelPage(WebDriver driver, String hotelName) {
        super(driver);

    }


    public void clickReservationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(reservationButton));
        reservationButton.click();
        String roomType = null;
        for (int i = 0; i < tableCells.size(); i++) {
//        sprawdzamy, czy WebElement o podanym indeksie posiada atrybut o nazwie rowspan
            if (tableCells.get(i).getAttribute("rowspan") != null) {
                System.out.println(tableCells.get(i).getText());
                roomType = tableCells.get(i).getText().split("\n")[0];
                roomGroupElements.put(roomType, new ArrayList<>());
//1. obiekt
//2. tworzymy listę - bo może być wiele pokoi tego samego typu (~ten sam obiekt)
            } else {
                String classAttribute = tableCells.get(i).getAttribute("class");
                if (classAttribute != null) {
                    List<RoomObject> roomObjects = roomGroupElements.get(roomType);
                    if (classAttribute.contains("occupancy")) {
                        System.out.println(tableCells.get(i).getText());
                        String numberOfGuests = tableCells.get(i).getText().split(":")[1].trim();
                        RoomObject roomObject = new RoomObject();
                        roomObject.setNumberOfGuests(numberOfGuests);
                        roomObjects.add(roomObject);
                    }

                }
            }

//            List <WebElement> RoomObject;
        }
    }
}


//            wait.until(ExpectedConditions.visibilityOfAllElements(accomodationType));
//            for (WebElement element : accomodationType) {
////           // (accomodationType.get(3).getText().equals(element.getAttribute(roomName))) {
//            if (accomodationType.toString().equals(element.getAttribute(roomName))) {
//            System.out.println("wybieram " + accomodationType);
//                if (roomPrice.equals("200")) {
//                    Select selectNumberOfRooms = new Select(selectNumberOfBedsButton);
//                    selectNumberOfRooms.selectByIndex(3);
//                    bookSelectedRoomButton.click();
//                }

