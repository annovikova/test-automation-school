package test.automation.school;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",  "drivers/chromedriver-v2.39-win32/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver(); // new ChromeDriver() -> ctrl+atl+v

        chromeDriver.get("https://www.google.com");
     // chromeDriver.findElement(By.name("q"));
        WebElement element = chromeDriver.findElement(By.cssSelector("[name='q']"));
        //  chromeDriver.findElement(By.cssSelector("//*[@name='q']"));

        element.sendKeys("cheese!");
        element.sendKeys(Keys.ENTER); 
    }

}
