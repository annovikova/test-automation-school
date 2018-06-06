package test.automation.school.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWork2 {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.firefox.bin", "C:\\Users\\anastasia.kulakova\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "..\\drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("http://juliemr.github.io/protractor-demo/");
        WebElement inptSearch1 = driver.findElement(By.cssSelector("input[ng-model='first']"));
    }

//    @AfterMethod
//    public void tearDown() throws Exception {
//        driver.quit();
//    }

    @Test
    public void checkSum() throws Exception {
        WebElement inptFirstNumber = driver.findElement(By.cssSelector("input[ng-model='first']"));
        inptFirstNumber.sendKeys("1");
        WebElement inptSecondNumber = driver.findElement(By.cssSelector("input[ng-model='second']"));
        inptSecondNumber.sendKeys("2");
        WebElement goButton = driver.findElement(By.cssSelector("#gobutton"));
        goButton.click();
        Thread.sleep(5000);
        String result = driver.findElement(By.cssSelector("h2.ng-binding")).getText();
        Assert.assertEquals(result, "3");
    }

    @Test
    public void checkSubtraction() throws Exception {
        WebElement inptFirstNumber = driver.findElement(By.cssSelector("input[ng-model='first']"));
        inptFirstNumber.sendKeys("1");
        WebElement dropdown = driver.findElement(By.cssSelector("select.span1"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByVisibleText("-");
        WebElement inptSecondNumber = driver.findElement(By.cssSelector("input[ng-model='second']"));
        inptSecondNumber.sendKeys("2");
        WebElement goButton = driver.findElement(By.cssSelector("#gobutton"));
        goButton.click();
        Thread.sleep(5000);
        String result = driver.findElement(By.cssSelector("h2.ng-binding")).getText();
        Assert.assertEquals(result, "-1");
    }

    @Test
    public void locateElementByIdTest4() throws Exception {
        WebElement inptFirstNumber = driver.findElement(By.cssSelector("input[ng-model='first']"));
        inptFirstNumber.sendKeys("1");
        WebElement dropdown = driver.findElement(By.cssSelector("select.span1"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByVisibleText("/");
        WebElement inptSecondNumber = driver.findElement(By.cssSelector("input[ng-model='second']"));
        inptSecondNumber.sendKeys("2");
        WebElement goButton = driver.findElement(By.cssSelector("#gobutton"));
        goButton.click();
        Thread.sleep(5000);
        String result = driver.findElement(By.cssSelector("h2.ng-binding")).getText();
        Assert.assertEquals(result, "0.5");
    }
}
