package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class GoogleSearch {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.pl/");
        WebElement cookiesBtn = driver.findElement(By.id("L2AGLb"));
        cookiesBtn.click();
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Coderslab");
        element.submit();
        driver.quit();

    }
}
