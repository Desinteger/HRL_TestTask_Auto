package ru.myhrlink.apptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class ApplicationsRegistryPage {

    private WebDriver webdriver;
    public ApplicationsRegistryPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private static final By employeeFullName = xpath(".//span[contains(text(),'Орлов')]");

    //Метод проверяет, что в реестре заявлений нет заявления, в котором в качестве сотрудника указан Орлов
    public boolean isApplicationNotDisplayed(){
        return webdriver.findElements(employeeFullName).isEmpty();
    }

}
