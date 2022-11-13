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

    public SearchResultsPage searchHotel(String location, String checkInDate, String checkOutDate){
        if (!isUserLogged()){
            throw new IllegalStateException("User is not logged in");
        }
        WebElement locationInput = driver.findElement(By.id("hotel_location"));
        WebElement hotelDropdown = driver.findElement(By.cssSelector("button.header-rmsearch-input"));
        WebElement hotelPrime = driver.findElement(By.cssSelector("[data-id-hotel=\"1\"]"));
        WebElement checkInInput = driver.findElement(By.id("check_in_time"));
        WebElement checkOutInput = driver.findElement(By.id("check_out_time"));
        WebElement searchButton = driver.findElement(By.id("search_room_submit"));
        locationInput.sendKeys(location);
        hotelDropdown.click();
        hotelPrime.click();
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        searchButton.click();
        return new SearchResultsPage(driver);
    }

    private boolean isUserLogged(){
        WebElement userName = driver.findElement(By.id("user_info_acc"));
        return userName.isDisplayed();
    }
}
