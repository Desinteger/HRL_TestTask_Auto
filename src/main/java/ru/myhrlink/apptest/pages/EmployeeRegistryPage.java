package ru.myhrlink.apptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class EmployeeRegistryPage {

    private WebDriver webdriver;
    public EmployeeRegistryPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
    private static final By employeeNameFilter = xpath(".//input[@data-qa='registry-header-name-input']");
    private static final By employee = xpath(".//a[@data-qa='registry-row-employee-link'][contains(text(),'Орлов Дмитрий Александрович')]");
    public boolean isEmployeeNotDisplayed(String employeeName){
        webdriver.findElement(employeeNameFilter).sendKeys(employeeName);
        return webdriver.findElements(employee).isEmpty();
    }

}
