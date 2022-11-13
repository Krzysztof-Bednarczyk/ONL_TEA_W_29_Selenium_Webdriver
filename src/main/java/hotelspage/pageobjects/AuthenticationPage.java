package hotelspage.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {

    private final WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage createAccount(String email){
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys(email);
        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
        return new RegisterPage(driver);
    }

    public AccountPage signInUser(String email, String password){
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement submitButton = driver.findElement(By.id("SubmitLogin"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new AccountPage(driver);
    }
}
