package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class WaitTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeClass
    public void setUp1() throws Exception {

        //TODO - tests should use new browser instance for each test method
        //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
        System.setProperty("webdriver.firefox.bin", "C:\\Users\\anastasia.kulakova\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "..\\drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
    }

    @BeforeMethod
    public void setUp() throws Exception {
//
        driver = new FirefoxDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        wait = new WebDriverWait(driver, 5);
    }

    //TODO 1

    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
//    @AfterMethod
//    public void tearDown() throws Exception {
//        driver.quit();
//    }
    //TODO 2

    //TODO 3 - Create TestNg Test method which
    //TODO 3 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 3 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 3 - Use Explicit Wait without Implicit Wait
    @Test
    public void checkboxDisplayCheck() throws Exception {
        assertTrue(driver.findElement(By.id("checkbox")).isDisplayed());
        WebElement actionButton = driver.findElement(By.id("btn"));
        actionButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
        assertTrue(driver.findElements(By.id("checkbox")).size() == 0);
        actionButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
        assertTrue(driver.findElements(By.id("checkbox")).size() != 0);

    }
    //TODO 3


    //TODO 4 - Create TestNg Test method which
    //TODO 4 - 1. verifies that checkbox element dissapears after hitting "Remove" button
    //TODO 4 - 2. verifies that checkbox element appears after hitting "Add" button
    //TODO 4 - Use Implicit Wait without Explicit Wait
    @Test
    public void checkboxDisplayCheckWithImplWait() throws Exception {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        assertTrue(driver.findElement(By.id("checkbox")).isDisplayed());
        WebElement actionButton = driver.findElement(By.id("btn"));
        actionButton.click();

        assertTrue(driver.findElement(By.id("message")).isDisplayed());
        assertTrue(driver.findElements(By.id("checkbox")).size() == 0);
        actionButton.click();

        assertTrue(driver.findElement(By.id("message")).isDisplayed());
        assertTrue(driver.findElements(By.id("checkbox")).size() != 0);

    }
    //TODO 4


    //TODO 5 - examine both approaches! which one is better?
}


