Feature: Check the temperature
  to check the temperature on the screen
  and then make decision to buy moisturizer
  or sunscreen according to it.

  Scenario: Checking the temperature
    Given Max is at Weather Shopper website
    When Max sees the temperature displayed
    Then Max decides what category to choose