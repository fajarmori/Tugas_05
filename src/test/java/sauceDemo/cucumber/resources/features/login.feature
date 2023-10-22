Feature: login page application sauce demo
  Scenario: Success login
    Given login page sauce demo
    When input valid username
    And input valid password
    And click login button
    Then  user in on home page

  Scenario: Failed login
    Given login page sauce demo
    When input valid username
    And input invalid password
    And click login button
    Then user get error message