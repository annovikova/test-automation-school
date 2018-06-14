package atbildes.pageobjecttask.test.test;

import atbildes.pageobjecttask.test.enums.Language;
import atbildes.pageobjecttask.test.pageobject.SearchPage;
import atbildes.pageobjecttask.test.pageobject.SearchResultPage;
import atbildes.pageobjecttask.test.pageobject.TopMenuBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SsTest {
    private WebDriver driver;
    private TopMenuBar topMenuBar;

    @BeforeMethod
    public void setUp() throws Exception {
//        System.setProperty("webdriver.chrome.bin", "C:\\Users\\s1eamk\\AppData\\Local\\Microsoft\\AppV\\Client\\Integration\\590455D7-2D2E-48A6-9412-DD2A08B56F24\\Root\\VFS\\ProgramFilesX86\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver-v2.39-win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
//        System.setProperty("webdriver.gecko.driver", "../drivers/geckodriver-v0.17.0-win32/geckodriver.exe");
//          todo 1. Открыть браузер и развернуть на весь экран.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        todo 2. Зайти на ss.com
        driver.get("http://ss.com");
    }

//    @AfterMethod
//    public void tearDown() throws Exception {
//
//        driver.quit();
//    }

    @Test
    public void testChangeLanguage() throws Exception {
        topMenuBar = new TopMenuBar(driver);
        topMenuBar.changeLanguage(Language.LV);
        assertEquals(topMenuBar.getCurrentLanguage(), Language.LV);
    }

    @Test
    public void testSearch() throws Exception {
        topMenuBar = new TopMenuBar(driver);
        topMenuBar.changeLanguage(Language.LV);
        topMenuBar.navigateToSearchPage();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchForPhrase("test");
        searchPage.performSearch();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        assertTrue(searchResultPage.getSearchResultElementCount() >0);
    }
}
