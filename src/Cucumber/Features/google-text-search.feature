Feature: Google Search

  Scenario Outline: User can search any keyword
    Given an open browser with google.com
    When a keyword <keyword> is entered in input field
    Then the first one should contain <expectedWord>
    And close browser
    Examples:
      | keyword    | expectedWord |
      | selenium   | selenium     |
      | coders lab | coders lab   |
      | karol      | karol        |
      | jacek      | jacek        |