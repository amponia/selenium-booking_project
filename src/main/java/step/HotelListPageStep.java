package step;

import io.cucumber.java8.En;
import lombok.Getter;
import pages.HotelPage;

import java.util.ArrayList;
import java.util.List;

public class HotelListPageStep implements En {

    @Getter
    private HotelPage hotelPage;

    public HotelListPageStep(HomePageStep homePageStep, CommonStep commonStep) {

        Given("I click on hotel name {string}", (String hotelName) -> {
            hotelPage = homePageStep.getHotelListPage().clickAvailabilityButtonByHotelName(hotelName);
            List<String> tabs = new ArrayList<>(commonStep.getDriver().getWindowHandles());
            commonStep.getDriver().switchTo().window(tabs.get(1));
        });
    }
}
