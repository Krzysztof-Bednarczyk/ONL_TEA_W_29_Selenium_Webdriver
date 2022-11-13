package coderslab.cucumber;

import hotelspage.pageobjects.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static utils.DataFaker.*;

public class AddAddressSteps {

    private final String EMAIL = "johnybravo223@test.com";
    private final String PASSWORD = "abcd1234";
    private WebDriver driver;
    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private AccountPage accountPage;
    private AddressesPage addressesPage;
    private NewAdressPage newAdressPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("user is logged in")
    public void loginUser() {
        homePage = new HomePage(driver);
        homePage.openPage();
        authenticationPage = homePage.clickSingIn();
        accountPage = authenticationPage.signInUser(EMAIL, PASSWORD);
    }

    @When("user add address")
    public void addAddress() {
        addressesPage = accountPage.goToMyAddresses();
        newAdressPage = addressesPage.addNewAdress();
        addressesPage = newAdressPage.addNewAddress(createRandomAddress(), createRandomZip(), createRandomCity(), createRandomPhoneNumnber());
    }

    @Then("address appears in address list")
    public void verifyAdressList(){
        boolean isAddressPresent  = !addressesPage.isAddressListEmpty();
        Assertions.assertThat(isAddressPresent).isTrue();
    }

}


