package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getIdentityLinkText(){
        WebElement informationLink = driver.findElement(By.id("identity-link"));
        return informationLink.getText();
    }

    public String getAccountNameText(){
        WebElement accountName = driver.findElement(By.cssSelector("#_desktop_user_info span"));
        return accountName.getText();
    }

}
