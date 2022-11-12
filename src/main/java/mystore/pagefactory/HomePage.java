package mystore.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    private final String URL = "https://mystore-testlab.coderslab.pl/index.php";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement newsletterInput;

    @FindBy(name = "submitNewsletter")
    WebElement subscribeButton;

    @FindBy(className = "alert")
    WebElement alertString;

    @FindBy(css = "a[title='Log in to your customer account']")
    WebElement signInLink;

    public HomePage openPage(){
        driver.get(URL);
        return this;
    }

    public void subscribeToNewsletter(String email){
        newsletterInput.sendKeys(email);
        subscribeButton.click();
    }

    public String getSubscriberAlertText(){
        return alertString.getText();
    }

    public LoginPage clickSingIn(){
        signInLink.click();
        return new LoginPage(driver);
    }
}
