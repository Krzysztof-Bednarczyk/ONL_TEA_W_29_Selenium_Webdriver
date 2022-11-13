package coderslab.hotelspage;

import hotelspage.pageobjects.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDate;

import static utils.DataFaker.*;

class HotelTests {

    private WebDriver driver;
    private final String EMAIL = "johnybravo223@test.com";
    private final String PASSWORD = "abcd1234";

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void registerUser(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        AuthenticationPage authenticationPage = homePage.clickSingIn(); // return new AuthenticationPage(driver);
        RegisterPage registerPage = authenticationPage.createAccount(createRandomEmail()); // return new RegisterPage(driver);
        AccountPage accountPage =  registerPage.registerUser(createRandomFirstName(), createRandomLastName(), createRandomPassword()); // return new AccountPage(driver);
        String alertText = accountPage.getAlertText();
        String expectedAlertText = "Your account has been created.";
        Assertions.assertThat(alertText).as("alert text").isEqualTo(expectedAlertText);
    }

    @Test
    void searchHotel(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        AuthenticationPage authenticationPage = homePage.clickSingIn();
        AccountPage accountPage = authenticationPage.signInUser(EMAIL, PASSWORD);
        homePage = accountPage.clickHomeLogo();
        SearchResultsPage searchResultsPage = homePage.searchHotel("Warszawa", LocalDate.now().toString(), LocalDate.now().plusDays(5).toString());
        boolean isExpectedElementDisplayed = searchResultsPage.isSearchRoomsDisplayed();
        Assertions.assertThat(isExpectedElementDisplayed).as("Serarch Rooms").isTrue();
    }

    @Test
    void bookHotel(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        AuthenticationPage authenticationPage = homePage.clickSingIn();
        AccountPage accountPage = authenticationPage.signInUser(EMAIL, PASSWORD);
        homePage = accountPage.clickHomeLogo();
        SearchResultsPage searchResultsPage = homePage.searchHotel("Warszawa", LocalDate.now().toString(), LocalDate.now().plusDays(5).toString());
        searchResultsPage.bookHotel(0);
        String bookingMessage = searchResultsPage.getBookingMessage();
        String expectedMessage = "Room successfully added to your cart";
        Assertions.assertThat(bookingMessage).as("Successful booking message").isEqualTo(expectedMessage);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
