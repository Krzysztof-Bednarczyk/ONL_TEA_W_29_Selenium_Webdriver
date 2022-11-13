Feature: Registration and Hotel Search
  Scenario: Register user
    Given an open browser with homePage
    And click signIn button
    When create account
    And fill out registration form
    Then user is successfully created
    And browser is closed

  Scenario: Search for hotel
    Given an open browser with homePage
    And user signin
    And go back to homePge
    When search for hotel
    Then search page is displayed
    And browser is closed