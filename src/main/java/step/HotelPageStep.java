package step;

import io.cucumber.java8.En;

public class HotelPageStep  implements En {



    public HotelPageStep(HotelListPageStep hotelListPageStep) {
        Given("I select {string} room of {string} type for {string} guests", (String numberOfRooms, String roomType, String numberOfGuests) -> {
            hotelListPageStep.getHotelPage().selectRoomByTypeAndNumberOfGuests(roomType, numberOfGuests, numberOfRooms);
        });

    }
}
