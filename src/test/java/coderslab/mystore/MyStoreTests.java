package coderslab.mystore;

import mystore.pageobjects.AccountPage;
import mystore.pageobjects.HomePage;
import mystore.pageobjects.LoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static utils.DataFaker.createRandomEmail;

class MyStoreTests {

    private WebDriver driver;
    private final String EMAIL = "michal.dobrzycki@coderslab.pl";
    private final String PASSWORD = "CodersLab";

    @BeforeEach
    void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void subscriberToNewsletterTest(){
        HomePage homePage = new HomePage(driver); // teworzenie PageObject'u
        homePage.openPage(); // otwieranie strony
        homePage.subscribeToNewsletter(createRandomEmail()); // subskrybcja do newsletter
        String actualAlertText = homePage.getSubscriberAlertText(); // wyciąganie tekstu z powiadomienia
        String expectedText = "You have successfully subscribed";
        Assertions.assertThat(actualAlertText).as("Alert Text").contains(expectedText); // veryfikacja tekstu
    }

    @Test
    void loginUserWithValidCredentials(){
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        LoginPage loginPage = homePage.clickSignIn(); // new LoginPage(driver); - Zwracamy obiekt nowej strony
        AccountPage accountPage = loginPage.loginUser(EMAIL, PASSWORD); // new AccountPage(driver); - Zwracamy obiekt nowej strony
        String expectedText = "INFORMATION";
        String actualText = accountPage.getIdentityLinkText();
        Assertions.assertThat(actualText).contains(expectedText); // veryfikacja tekstu
        String expectedAccountName = "Automated Tester";
        String actualAccountName = accountPage.getAccountNameText();
        Assertions.assertThat(actualAccountName).as("Account name").isEqualTo(expectedAccountName);
    }

    @Test
    void loginUserPAgeFactoryTest(){
        mystore.pagefactory.HomePage homePage = new mystore.pagefactory.HomePage(driver);
        homePage.openPage();
        mystore.pagefactory.LoginPage loginPage = homePage.clickSingIn();
        mystore.pagefactory.AccountPage accountPage = loginPage.loginUser(EMAIL, PASSWORD);
        String expectedText = "INFORMATION";
        String actualText = accountPage.getIdentityLinkText();
        Assertions.assertThat(actualText).contains(expectedText); // veryfikacja tekstu
        String expectedAccountName = "Automated Tester";
        String actualAccountName = accountPage.getAccountNameText();
        Assertions.assertThat(actualAccountName).as("Account name").isEqualTo(expectedAccountName);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
