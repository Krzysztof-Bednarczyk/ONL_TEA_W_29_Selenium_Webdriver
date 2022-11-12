package mystore.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "identity-link")
    WebElement informationLink;

    @FindBy(css = "#_desktop_user_info span")
    WebElement accountName;

    public String getIdentityLinkText(){
        return informationLink.getText();
    }

    public String getAccountNameText(){
        return accountName.getText();
    }
}
