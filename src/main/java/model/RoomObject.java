package model;

import lombok.Data;
import org.openqa.selenium.WebElement;

@Data
public class RoomObject {

    private String numberOfGuests;
    private String roomPrice;
    private WebElement selectNumberOfRoomsDropdownList;

}

