package test.automation.school.waits;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PageLoadTimeoutExample {

    public static void main(String[] args) {
     //   System.setProperty("webdriver.firefox.bin", "C:\\Users\\anastasia.kulakova\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
//
    //    WebDriver driver = new FirefoxDriver();


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver-v2.30-win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
// set page load timeout

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

        // ~8.5 seconds load
        // Will terminate with thrown TimoutException
        driver.get("https://www.macys.com/");

        // this code will not be executed, since TimeOut exception will be thrown on previous command
        WebElement closeButton = driver.findElement(By.id("closeButton"));
        closeButton.click();

    }


}
