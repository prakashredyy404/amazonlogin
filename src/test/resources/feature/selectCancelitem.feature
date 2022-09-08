Feature: add items in cart

  @test

  Scenario:cancel items in cart
    Given user opens url
    When user searches for item
    And user add item into cart
    Then remove added item from cart

    Scenario: store data a in Excel sheet
      Given user opens url
        When user searches for "I phone 13"
        Then add items detail into excel

