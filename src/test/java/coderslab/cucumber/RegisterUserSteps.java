package coderslab.cucumber;

import hotelspage.pageobjects.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;

import static utils.DataFaker.*;

public class RegisterUserSteps {

    private WebDriver driver;
    private final String EMAIL = "johnybravo223@test.com";
    private final String PASSWORD = "abcd1234";
    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private RegisterPage registerPage;
    private AccountPage accountPage;

    private SearchResultsPage searchResultsPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Given("an open browser with homePage")
    public void openBrowserOnHomePage(){
        homePage = new HomePage(driver);
        homePage.openPage();
    }

    @And("click signIn button")
    public void clickSignIn(){
        authenticationPage = homePage.clickSingIn();
    }

    @When("^create account with (.*)")
    public void createAccount(String email){
        registerPage = authenticationPage.createAccount(email);
    }

    @And("fill out registration form with (.*) and (.*) and (.*)$")
    public void fillForm(String firstName, String lastName, String password){
        accountPage = registerPage.registerUser(firstName, lastName, password);
    }

    @Then("user is successfully created")
    public void createUser(){
        String expectedMessage = "Your account has been created.";
        String alertText = accountPage.getAlertText();
        Assertions.assertThat(alertText).isEqualTo(expectedMessage);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @And("user signin")
    public void userSignIn(){
        authenticationPage = homePage.clickSingIn();
        accountPage = authenticationPage.signInUser(EMAIL, PASSWORD);
    }

    @And("go back to homePge")
    public void goBackToHomePage(){
        homePage = accountPage.clickHomeLogo();
    }

    @When("search for hotel")
    public void searchForHotel(){
        searchResultsPage = homePage.searchHotel("Warszawa", LocalDate.now().toString(), LocalDate.now().plusDays(5).toString());
    }

    @Then("search page is displayed")
    public void displaySearchPage(){
        boolean isExpectedElementDisplayed = searchResultsPage.isSearchRoomsDisplayed();
        Assertions.assertThat(isExpectedElementDisplayed).as("Serarch Rooms").isTrue();
    }
}
