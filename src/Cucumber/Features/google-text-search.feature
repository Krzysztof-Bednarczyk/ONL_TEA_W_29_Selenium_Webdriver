Feature: Google Search
  Scenario: User can search any keyword
    Given an open browser with google.com
    When a keyword coders lab is entered in input field
    Then the first one should contain coders lab
    And close browser