@Common
Feature: test feature (opis testu)

  @test1
  Scenario Outline: test case description
    Given I navigate to "https://booking.com" using "<browser>"
    And I accept consent button
    And I enter city name "Warszawa"
    And I enter checkin date: "2021-05-19"
    And I enter checkout date: "2021-04-17"
    And I click on search button for city "Warszawa"
    And I click on hotel name "Radisson Collection Hotel, Warsaw"
    And I select "1" room of "Pokój Collection" type for "2" guests

    Examples:
      | browser |
      | CHROME  |

  @test2
  Scenario Outline: test case description
    Given I navigate to "https://booking.com" using "<browser>"
    And I accept consent button
    And I enter city name "Tokio"
    And I enter checkin date: "2021-05-01"
    And I enter checkout date: "2021-05-02"
    And I click on search button for city "Tokio"
    And I click on hotel name "The Royal Park Hotel Tokyo Haneda"
    And I select "1" room of "Oferta specjalna - Pokój dwuosobowy" type for "2" guests
    And I click on reservation button

    Examples:
      | browser |
      | CHROME  |
#    | FIREFOX |


