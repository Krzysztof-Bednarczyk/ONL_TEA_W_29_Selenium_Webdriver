package coderslab.cucumber;

import hotelspage.pageobjects.*;
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

    @Given("an open browser with homePage")
    public void openBrowserOnHomePage(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.openPage();
    }

    @And("click signIn button")
    public void clickSignIn(){
        authenticationPage = homePage.clickSingIn();
    }

    @When("create account")
    public void createAccount(){
        registerPage = authenticationPage.createAccount(createRandomEmail());
    }

    @And("fill out registration form")
    public void fillForm(){
        accountPage = registerPage.registerUser(createRandomFirstName(), createRandomLastName(), createRandomPassword());
    }

    @Then("user is successfully created")
    public void createUser(){
        String expectedMessage = "Your account has been created.";
        String alertText = accountPage.getAlertText();
        Assertions.assertThat(alertText).isEqualTo(expectedMessage);
    }

    @And("browser is closed")
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
