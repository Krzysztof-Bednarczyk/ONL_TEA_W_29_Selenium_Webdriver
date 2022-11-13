Feature: Registration and Hotel Search

  Scenario Outline: Register user
    Given an open browser with homePage
    And click signIn button
    When create account with <email>
    And fill out registration form with <firstName> and <lastName> and <password>
    Then user is successfully created
    Examples:
      | email             | firstName | lastName | password      |
      | ta3twes3atst@wp.pl    | Tommmyyy  | Gunnn    | dkoskdsok4344 |
      | gg2s3eg3g@com.pl       | Greggg    | Tinnnu   | adsdasda3443  |
      | gje3s243ggjgg@gmail.com | Romano    | Sergio   | dsadda$$$4    |
      | gges324g3g@wp.com       | Floriano  | Rominn   | dsaaddasd%%%  |

  Scenario: Search for hotel
    Given an open browser with homePage
    And user signin
    And go back to homePge
    When search for hotel
    Then search page is displayed