Feature: checkout page application sauce demo
  Scenario: Success to checkout page
    Given user after login
    When click icon hamburger
    And click menu logout
    Then  user in on login page