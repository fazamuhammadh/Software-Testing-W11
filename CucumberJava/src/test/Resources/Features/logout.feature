#Author
#Date
#Description
@SmokeScenario
Feature: feature to test logout funcionality

  @SmokeTest
  Scenario: logout is successful with valid credentials
    Given user is login on page
    When user click profile
    And click on logout icon
    Then user is navigated to login page