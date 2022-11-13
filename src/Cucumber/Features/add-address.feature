Feature: Adding address
  Scenario: Add address to user
    Given user is logged in
    When user add address
    Then address appears in address list