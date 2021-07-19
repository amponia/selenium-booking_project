package model;

import lombok.Data;
import org.openqa.selenium.WebElement;

@Data
public class RoomObject {

    private String numberOfGuests;
    private String roomPrice;
    private WebElement selectNumberOfRoomsDropdownList;

    public void setNumberOfGuests(String numberOfGuests) {
    }

    public String getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setSelectNumberOfRoomsDropdownList(WebElement selectNumberOfRoomsDropdownList) {
        this.selectNumberOfRoomsDropdownList = selectNumberOfRoomsDropdownList;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public WebElement getSelectNumberOfRoomsDropdownList() {
        return selectNumberOfRoomsDropdownList;
    }

    public void setRoomPrice(String s) {
    }
}

