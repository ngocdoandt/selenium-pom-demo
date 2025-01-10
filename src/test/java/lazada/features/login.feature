Feature: Login
  @abc1
  Scenario: User login success with valid email and password
    Given userA directs to login screen
    When userA enters a valid email
    And userA enters a valid password
    And userA clicks Submit button
    Then userA should be on My Account page

# WITH HOOKS

  Scenario: Login with Invalid account
     Given user directs to login screen
     When user enters a invalid email
     And user enters a valid password
     And user clicks Submit button
     Then user gets error

  @ngoc
  Scenario Outline: Login with Invalid account
    Given user directs to login screen
    When user enters an email "<email>" and password "<password>"
    And user clicks Submit button
    Then user gets the error message "<error>"
    Examples:
      | email          | password | error                                       |  |
      | abc1@gmail.com |          | This field is required                      |  |
      |                | 1233444  | This field is required                      |  |
      | abc1@gmail.com | 12323232 | Unable to log in with provided credentials. |  |
