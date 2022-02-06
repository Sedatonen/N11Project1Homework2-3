Feature: N11 Test Automation

  @case2
  Scenario: Go to website select products and wrong payment
    Given user go to n11 home page and search "ayphone"
    When user add products to basket
    Then user pays with wrong card number

  @case3
  Scenario: Go to website search product and set filter
    Given user go to n11 home page and search "telefon"
    Then user select filter