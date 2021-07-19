package pages;

import config.PageObject;
import model.RoomObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class HotelPage extends PageObject {

    private Map<String, List<RoomObject>> roomGroupElements = new LinkedHashMap<>();

    @FindBy(tagName = "h2")
    private WebElement hotelNameHeader;

    @FindBy(className = "hprt-reservation-cta")
    private WebElement reservationButton;

    @FindBy(id = "hprt-table")
    private WebElement roomTable;

    @FindBy(xpath = "//table[@id='hprt-table']/tbody/tr/td")
    private List<WebElement> tableCells;

    @FindBy(className = "hprt-roomtype-icon-link")
    private List<WebElement> accomodationType;

    @FindBy(xpath = "//div[contains(@class, 'reservation')]/button")
    private WebElement bookSelectedRoomButton;

    @FindBy(xpath = "//td/div/select")
    private List<WebElement> selectNumberOfBedsDropdownList;

    public HotelPage(WebDriver driver, String hotelName) {
        super(driver);

    }

    public void clickReservationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(reservationButton));
        reservationButton.click();
        String roomType = null;

        for (int i = 0; i < tableCells.size(); i++) {

            if (tableCells.get(i).getAttribute("rowspan") != null) {
                System.out.println(tableCells.get(i).getText());
                roomType = tableCells.get(i).getText().split("\n")[0];
                roomGroupElements.put(roomType, new ArrayList<>());


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
                    } else if (classAttribute.contains("hprt-table-cell-price")) {
                        System.out.println(tableCells.get(i).getText());
                        roomObjects.get(roomObjects.size() - 1).setRoomPrice(tableCells.get(i).getText().split(" zł\n")[0]);
                    }
                }
            }
        }
        //
        int i = 0;
        for (Map.Entry<String, List<RoomObject>> entry : roomGroupElements.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            for (RoomObject roomObject : entry.getValue()) {
                roomObject.setSelectNumberOfRoomsDropdownList(selectNumberOfBedsDropdownList.get(i));
                i++;
            }
        }

        System.out.println(roomGroupElements);
    }


    public void selectRoomByTypeAndNumberOfGuests(String accomodationType, String numberOfGuests, String numberOfRooms) {
        List<RoomObject> roomObjects = roomGroupElements.get(accomodationType);
        for (RoomObject roomObject : roomObjects) {
            if (numberOfGuests.equals(roomObject.getNumberOfGuests())) {
                Select numberOfRoomsSelect = new Select(roomObject.getSelectNumberOfRoomsDropdownList());
                numberOfRoomsSelect.selectByValue(numberOfRooms);
                return;
            }

        }
    }

//    public void bookSelectedRoomButton () {
//        bookSelectedRoomButton.click();
//    }

    public ReservationDataPage bookSelectedRoomButton(String hotelName) {
        bookSelectedRoomButton.click();
        return new ReservationDataPage(driver, hotelName);
    }
}




