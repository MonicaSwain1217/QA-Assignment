Feature: Landing page

  Scenario: Verify user can access homepage for Calendly QA Take Home Assignment
    Given I navigate to codepen link provided by HR

    When I land on the webpage
    Then I verify "QA Interview Assignment" is listed in the title
    And  I verify the owner is "Calendly"
