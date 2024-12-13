Feature: Login
 @abc1
 Scenario: User login success with valid email and password
    Given user directs to login screen
    When user enters a valid email
    And user enters a valid password
    And user clicks Submit button
    Then user should be on My Account page

