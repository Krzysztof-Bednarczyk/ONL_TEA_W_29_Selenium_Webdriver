package findingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ByName {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.name("hotel_location"));
        WebElement searchNowButton = driver.findElement(By.name("search_room_submit")); // not used
        WebElement enterEmailInput = driver.findElement(By.name("email"));
        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));

        hotelLocationInput.sendKeys("Warsaw");
        enterEmailInput.sendKeys("test@test.com");
        subscribeButton.submit();

        driver.quit();
    }
}
