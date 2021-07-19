package step;

import io.cucumber.java8.En;

public class HotelPageStep  implements En {



    public HotelPageStep(HotelListPageStep hotelListPageStep) {
        Given("I select {string} room of {string} type for {string} guests", (String numberOfRooms, String roomType, String numberOfGuests) -> {
            hotelListPageStep.getHotelPage().clickReservationButton();
            hotelListPageStep.getHotelPage().selectRoomByTypeAndNumberOfGuests(roomType, numberOfGuests, numberOfRooms);
        });

        Given("I click on reservation button", () -> {
            hotelListPageStep.getHotelPage().bookSelectedRoomButton("The Royal Park Hotel Tokyo Haneda");
        });

    }
}
