Feature: checkout page application sauce demo
  Scenario: Success to checkout page
    Given user in cart page
    When click checkout button
    Then  user in on checkout page