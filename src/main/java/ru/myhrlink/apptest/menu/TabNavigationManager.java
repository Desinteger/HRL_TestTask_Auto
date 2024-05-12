package ru.myhrlink.apptest.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class TabNavigationManager {

    private WebDriver webdriver;

    private static final By applicationRegistryTab = xpath(".//a[@data-qa='hr-app-nav-applications-registry-link']");
    private static final By employeeRegistryTab = xpath(".//a[@data-qa='hr-app-nav-employees-registry-link']");
    private static final By catalogsTab = xpath(".//a[@data-qa='hr-app-nav-catalogs-link']");


    public TabNavigationManager(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    //Методы навигации по вкладкам бокового меню
    public void goToApplicationsRegistry() {
        webdriver.findElement(applicationRegistryTab).click();
    }

    public void goToEmployeeRegistry()  {
        webdriver.findElement(employeeRegistryTab).click();
    }

    public void goToCatalogs()  {
        webdriver.findElement(catalogsTab).click();
    }

}
