package test.automation.school;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {
    WebDriver driver;

    @BeforeMethod
    public void testName() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.39-win32/chromedriver.exe");
        driver = new ChromeDriver(); // new ChromeDriver() -> ctrl+atl+v // shift+f6-> change in all places
        driver.get("https://www.google.com");
    }

    @AfterMethod //alt+Insert -> AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void googleSearch() throws InterruptedException {

        // driver.findElement(By.name("q"));
        WebElement element = driver.findElement(By.cssSelector("[name='q']"));
        //  driver.findElement(By.cssSelector("//*[@name='q']"));
        element.sendKeys("cheese!");
        element.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        List<WebElement> searchResultElements = driver.findElements(By.className("ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line"));
        assertTrue(searchResultElements.size() > 0);
    }
}
