package coderslab.mystore;

import mystore.pageobjects.HomePage;
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

    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
