@Common
Feature: test feature (opis testu)

  Scenario Outline: test case description
    Given I navigate to "https://booking.com" using "<browser>"
    And I accept consent button
    And I enter city name "Warszawa"
    And I enter checkin date: "2021-02-27"
    And I enter checkout date: "2021-02-28"
    And I click on search button for city "Warszawa"
    And I click on hotel name "GO Apartments"

    Examples:
      | browser |
      | CHROME  |
#    | FIREFOX |


