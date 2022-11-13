Feature: Registration and Hotel Search

  Scenario Outline: Register user
    Given an open browser with homePage
    And click signIn button
    When create account with <email>
    And fill out registration form with <firstName> and <lastName> and <password>
    Then user is successfully created
    And browser is closed
    Examples:
      | email             | firstName | lastName | password      |
      | tates3atst@wp.pl    | Tommmyyy  | Gunnn    | dkoskdsok4344 |
      | ggeg3g@com.pl       | Greggg    | Tinnnu   | adsdasda3443  |
      | gje3ggjgg@gmail.com | Romano    | Sergio   | dsadda$$$4    |
      | ggeg3g@wp.com       | Floriano  | Rominn   | dsaaddasd%%%  |

  Scenario: Search for hotel
    Given an open browser with homePage
    And user signin
    And go back to homePge
    When search for hotel
    Then search page is displayed
    And browser is closed