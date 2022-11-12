package coderslab.hotelspage;

import hotelspage.pageobjects.AccountPage;
import hotelspage.pageobjects.AuthenticationPage;
import hotelspage.pageobjects.HomePage;
import hotelspage.pageobjects.RegisterPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static utils.DataFaker.*;

class RegisterUserTest {

    private WebDriver driver;

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

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
