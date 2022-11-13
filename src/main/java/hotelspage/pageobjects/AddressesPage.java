package hotelspage.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressesPage {

    private final WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewAdressPage addNewAdress(){
        WebElement addNewAdressButton = driver.findElement(By.cssSelector("a[title$='Add an address']"));
        addNewAdressButton.click();
        return new NewAdressPage(driver);
    }

    public boolean isAddressListEmpty(){
        List<WebElement> addressList = driver.findElements(By.cssSelector(".address"));
        return addressList.isEmpty();
    }
}
