package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static utils.DataFaker.createRandomEmail;

public class ByClassname {

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

        driver.quit();

    }
}
