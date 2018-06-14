package atbildes.pageobjecttask.test2.test.pageobject;

import atbildes.pageobjecttask.test2.test.enums.Language;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static atbildes.pageobjecttask.test2.test.enums.Language.LV;
import static atbildes.pageobjecttask.test2.test.enums.Language.RU;


public class TopMenuBar {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final By TOP_MENU_SECTION_LOCACTOR = By.cssSelector("#main_table");
    private static final By CHANGE_LANGUAGE_LOCATOR = By.cssSelector(".menu_lang .a_menu");
    private static final By CHANGE_LANGUAGE_LOCATOR_LV = By.cssSelector("[href='/lv/'");
    private static final By CHANGE_LANGUAGE_LOCATOR_RU = By.cssSelector("[href='/ru/'");
    private static final By  SEARCH_LINK_LOCATOR = By.cssSelector("#main_table [href*='search']");


    public TopMenuBar(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TOP_MENU_SECTION_LOCACTOR));
    }

    public TopMenuBar changeLanguage(Language language) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHANGE_LANGUAGE_LOCATOR));
        switch (language) {
            case RU:
                if (driver.findElements(CHANGE_LANGUAGE_LOCATOR_RU).size()>0) {
                    driver.findElement(CHANGE_LANGUAGE_LOCATOR_RU).click();
                }
                break;
            case LV:
                if (driver.findElements(CHANGE_LANGUAGE_LOCATOR_LV).size()>0) {
                    driver.findElement(CHANGE_LANGUAGE_LOCATOR_LV).click();
                }
                break;
        }
        return this;
    }

    public Language getCurrentLanguage() {
        if (driver.findElement(CHANGE_LANGUAGE_LOCATOR_RU).isDisplayed()) {
            return LV;
        } else {
            return RU;
        }
    }

    public void navigateToSearchPage (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_LINK_LOCATOR));
        driver.findElement(SEARCH_LINK_LOCATOR).click();

    }
}
