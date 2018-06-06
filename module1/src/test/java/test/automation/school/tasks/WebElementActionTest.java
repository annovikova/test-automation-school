package test.automation.school.tasks;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementActionTest {

    //TODO - tests should use new browser instance for each test method
    //TODO 1 - inside of test fixture (test setup) - initialize WebDriver instance and navigate to http://automationpractice.com/
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.firefox.bin", "C:\\Users\\anastasia.kulakova\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "..\\drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/");
    }
    //TODO 1

    //TODO 2 - Destroy WebDriver instance in a test fixture (test test teardown)
    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
    //TODO 2


    //TODO 3 - Create TestNg Test method which navigates to Contact info page (click()) and verify that user is navigated to other page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
    @Test
    public void locateElementByIdTest() throws Exception {
        WebElement elementById = driver.findElement(By.id("contact-link"));
        elementById.click();
    }
    //TODO 3


    //TODO 4 -Create TestNg Test method which inputs some value into search input field and then clear the inputted text. Try do it in 2 possible ways.
    //TODO 4 - Also verify inputted text after each input action.
    @Test
    public void locateElementByIdTest2() throws Exception {
        WebElement inptSearch = driver.findElement(By.id("search_query_top"));
        inptSearch.sendKeys("test");
        inptSearch.clear();
    }
    //TODO 4


    //TODO 5 - Create TestNg Test method - input some value into search input field and submit the result. Verify that user is navigated to new page
    // NOTE - in order to verify that user has been navigated to new page, you can use 'driver.getTitle()', however this will work only for non Single Page Applications
    @Test
    public void locateElementByIdTest3() throws Exception {
        WebElement inptSearch = driver.findElement(By.id("search_query_top"));
        inptSearch.sendKeys("test",  Keys.ENTER);
        String getTitle = driver.getTitle();
        System.out.println("Page title Is : "+getTitle);
        Assert.assertEquals("My Store",getTitle);
    }
    //TODO 5

}
