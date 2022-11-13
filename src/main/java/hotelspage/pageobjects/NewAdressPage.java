package hotelspage.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAdressPage {

    private final WebDriver driver;

    public NewAdressPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddressesPage addNewAddress(String address, String zip, String city, String phoneNumber){
        WebElement addressInput = driver.findElement(By.id("address1"));
        WebElement zipInput = driver.findElement(By.id("postcode"));
        WebElement cityInput = driver.findElement(By.id("city"));
        WebElement phoneInput = driver.findElement(By.id("phone"));
        WebElement saveAddressButton = driver.findElement(By.id("submitAddress"));
        addressInput.sendKeys(address);
        zipInput.sendKeys(zip);
        cityInput.sendKeys(city);
        phoneInput.sendKeys(phoneNumber);
        saveAddressButton.click();
        return new AddressesPage(driver);
    }
}
