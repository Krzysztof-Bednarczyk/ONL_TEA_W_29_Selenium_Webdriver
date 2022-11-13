package coderslab.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GoogleSearchSteps {

    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openGoogleSearch(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.pl/");
    }

    @When("^a keyword (.*) is entered in input field")
    public void enterKeyword(String keyword){
        WebElement cookiesBtn = driver.findElement(By.id("L2AGLb"));
        cookiesBtn.click();
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys(keyword);
        element.submit();
    }

    @Then("^the first one should contain (.*)")
    public void theFirstOneShouldContainKeyword(String mojazmienna){
        List<WebElement> searchResults = driver.findElements(By.cssSelector("a>h3"));
        String linkText = searchResults.get(0).getText();
        Assertions.assertThat(linkText).as("Selenium link text").containsIgnoringCase(mojazmienna);
    }

    @And("close browser")
    public void closeBrowser(){
        driver.quit();
    }


}
