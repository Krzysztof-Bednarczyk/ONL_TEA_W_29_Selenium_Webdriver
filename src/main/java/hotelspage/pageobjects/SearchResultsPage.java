package hotelspage.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSearchRoomsDisplayed(){
        WebElement searchRoomsBar = driver.findElement(By.id("filter_search_block"));
        return searchRoomsBar.isDisplayed();
    }

    public SearchResultsPage bookHotel(int index){
        List<WebElement> bookButtons = driver.findElements(By.cssSelector("a.ajax_add_to_cart_button"));
        bookButtons.get(index).click();
        return this;
    }

    public String getBookingMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#layer_cart[style*='display: block']")));
        WebElement bookingMessage = driver.findElement(By.cssSelector(".layer_cart_product  h2"));
        return bookingMessage.getText();
    }
}
