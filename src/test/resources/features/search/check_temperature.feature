Feature: Check the temperature
  to check the temperature on the screen
  and then make decision to buy moisturizer
  or sunscreen according to it.

  Scenario: Checking the temperature
    Given Max is at Weather Shopper website
    When Max sees the temperature displayed
    Then Max decides what category to choose as he sees temperature


    Given Max is at Product Page and the title is "Moisturizers" or "Sunscreens"
    When adds the least expensive product to the cart
    And click on the cart button
    Then check if the items in the cart are right products

    Given at the Payment Page
    When enters the payment details into the form
    Then payment is successful