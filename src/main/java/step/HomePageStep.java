package step;

import io.cucumber.java8.En;
import lombok.Getter;
import pages.HotelListPage;

import java.time.LocalDate;

public class HomePageStep implements En {

    @Getter
    private HotelListPage hotelListPage; //ta globalna zmienna pozwala nam zapisywać zmienną cityName

    public HomePageStep(CommonStep commonStep) {

        Given("I accept consent button", () -> {
            commonStep.getHomePage().acceptCookies();
        });

        Given("I enter city name {string}", (String city) -> {

            commonStep.getHomePage().enterCity(city);
        });

        Given("I click on checkin button", () -> {
            commonStep.getHomePage().clickCheckInButton();
        });

        Given("I enter checkin date: {string}", (String string) -> {
            commonStep.getHomePage().clickCheckInButton();
            commonStep.getHomePage().selectCheckInDate(LocalDate.parse(string));
//             new RuntimeException ();
        });

        Given("I enter checkout date: {string}", (String string) -> {
            commonStep.getHomePage().clickCheckOutButton();
            commonStep.getHomePage().clickCheckOutButton();
            commonStep.getHomePage().selectCheckOutDate(LocalDate.parse(string));
        });

        Given("I click on search button for city {string}", (String cityName) -> {
            hotelListPage = commonStep.getHomePage().clickSearchButton(cityName);

        });
    }


}

