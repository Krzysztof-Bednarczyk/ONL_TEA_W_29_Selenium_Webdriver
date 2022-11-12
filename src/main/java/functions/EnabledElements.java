package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static utils.DataFaker.*;

public class EnabledElements {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement signInButton = driver.findElement(By.className("user_login"));
        signInButton.click();
        WebElement emailInput = driver.findElement(By.className("account_input"));
        emailInput.sendKeys(createRandomEmail());
        WebElement createAccountButton = driver.findElement(By.name("SubmitCreate"));
        createAccountButton.submit();


        // Adding Xpath code

        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        WebElement emailFormInput = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));

        firstNameInput.isDisplayed();
        firstNameInput.sendKeys(createRandomFirstName());
        lastNameInput.isDisplayed();
        lastNameInput.sendKeys(createRandomLastName());
        emailFormInput.isDisplayed();
        emailFormInput.clear();
        emailFormInput.sendKeys(createRandomEmail());
        password.isDisplayed();
        password.sendKeys(createRandomPassword());

        WebElement registerButton = driver.findElement(By.xpath("//button[@id='submitAccount']"));
        registerButton.isEnabled();
        registerButton.click();
        driver.quit();
    }
}
