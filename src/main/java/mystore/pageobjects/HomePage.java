package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    private final String URL = "https://mystore-testlab.coderslab.pl/index.php";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openPage(){
        driver.get(URL);
        return this;
    }

    public void subscribeToNewsletter(String email){
        WebElement newsletterInput = driver.findElement(By.name("email"));
        newsletterInput.sendKeys(email);
        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));
        subscribeButton.click();
    }

    public String getSubscriberAlertText(){
        WebElement alertString = driver.findElement(By.className("alert"));
        return alertString.getText();
    }

    public LoginPage clickSignIn(){
        WebElement signInLink = driver.findElement(By.cssSelector("a[title='Log in to your customer account']"));
        signInLink.click();
        return new LoginPage(driver); // Zwracamy obiekt nowej strony
    }
}
