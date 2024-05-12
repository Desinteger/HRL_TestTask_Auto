package ru.myhrlink.apptest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.myhrlink.apptest.menu.TabNavigationManager;
import ru.myhrlink.apptest.pages.DocumentsRegistryPage;
import ru.myhrlink.apptest.pages.LoginPage;

import java.time.Duration;

import static ru.myhrlink.apptest.TestData.*;
import static ru.myhrlink.apptest.config.AppConfig.APP_URL;

public class BaseTest {

    WebDriver webdriver;
    DocumentsRegistryPage objDocumentRegistry;
    TabNavigationManager tabNavigationManager;

    public void loginAsHr() {
        LoginPage objLoginPage = new LoginPage(webdriver);
        objLoginPage.loginUser(HR_EMAIL, HR_PASSWORD);
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webdriver.manage().window().setSize(new Dimension(1920,1080));
        webdriver.get(APP_URL);
        objDocumentRegistry = new DocumentsRegistryPage(webdriver);
        tabNavigationManager = new TabNavigationManager(webdriver);
    }

    @After
    public void teardown() { webdriver.quit(); }

}
