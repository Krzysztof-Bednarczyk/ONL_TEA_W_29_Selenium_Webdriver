Feature: Registration
  Scenario: Register user
    Given an open browser with homePage
    And click signIn button
    When create account
    And fill out registration form
    Then user is successfully created
    And browser is closed