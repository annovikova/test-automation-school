package atbildes.pageobjecttask.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final By SEARCH_RESULTS_ELEMENTS_LOCATOR = By.cssSelector("[id*='tr_']:not([id*='tr_bnr_'])");
    private static final By SEARCH_RESULTS_PAGE_LOCATOR = By.cssSelector("#page_main");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_RESULTS_PAGE_LOCATOR));
    }

    public int getSearchResultElementCount() {
        return driver.findElements(SEARCH_RESULTS_ELEMENTS_LOCATOR).size();
    }
}
