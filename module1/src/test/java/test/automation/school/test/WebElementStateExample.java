package test.automation.school.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementStateExample {

    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.bin", "C:\\Users\\anastasia.kulakova\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
//        driver.get("http://google.com");
//        WebElement inptSearch = driver.findElement(By.cssSelector("[name='q']"));
//        System.out.println("Search input " + inptSearch.isDisplayed());

//       driver.get("http://the-internet.herokuapp.com/checkboxes");
//        WebElement chbxFirstInput = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
//        System.out.println("First checkbox:" + chbxFirstInput.isSelected());

//        System.out.println("First checkbox:" + chbxFirstInput.isSelected());
//        System.out.println("First checkbox" + chbxFirstInput.getAttribute("checked"));

//        WebElement headerElement = driver.findElement(By.cssSelector("h3"));
//        System.out.println("Header text" + headerElement.getText() );

//        WebElement divSection = driver.findElement(By.cssSelector("div.example"));
//        System.out.println("Header text" + divSection.getText() );

        driver.get("https://jedwatson.github.io/react-select/");
        WebElement drpdwnFirst = driver.findElement(By.cssSelector(".State-NSW"));
        System.out.println("Drpdwn first" +drpdwnFirst.isEnabled());

        WebElement disableStatesDropdownCheckbox = driver.findElement(By.xpath("//input[following-sibling::*[text()='Disabled']]"));
        System.out.println("not enabled" + disableStatesDropdownCheckbox.isEnabled());
        disableStatesDropdownCheckbox.click();

        drpdwnFirst = driver.findElement(By.cssSelector(".State-NSW"));
        System.out.println("Drpdwn not enabled" +drpdwnFirst.isEnabled());
    }
}
