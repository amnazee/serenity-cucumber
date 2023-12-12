Feature: Check the temperature

  Scenario: Checking the temperature on the screen
    Given Sergey is researching things on the internet
    When he looks up "green"
    Then he should see information about "green"