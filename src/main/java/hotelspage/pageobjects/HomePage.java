package hotelspage.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    private final String URL = "https://hotel-testlab.coderslab.pl/en/";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openPage(){
        driver.get(URL);
        return this;
    }

    public AuthenticationPage clickSingIn(){
        WebElement signInButton = driver.findElement(By.className("user_login"));
        signInButton.click();
        return new AuthenticationPage(driver);
    }
}
