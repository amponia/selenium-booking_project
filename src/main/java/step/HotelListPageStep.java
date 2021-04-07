package step;

import io.cucumber.java8.En;
import lombok.Getter;
import pages.HotelPage;

public class HotelListPageStep implements En {

    @Getter
    private HotelPage hotelPage;

    public HotelListPageStep(HomePageStep homePageStep) {

        Given("I click on hotel name {string}", (String hotelName) -> {
            homePageStep.getHotelListPage().clickAvailabilityByHotelName(hotelName);
        });
    }
}
