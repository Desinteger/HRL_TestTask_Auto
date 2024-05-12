package ru.myhrlink.apptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class CatalogsPage {
    private WebDriver webdriver;
    public CatalogsPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private static final By legalEntityNameInTable = xpath(".//a[contains(text(),'ООО Кот')]");

    //Метод проверяет, что в справочнике юрлиц не отображается ЮЛ с названием "ООО Кот"
    public boolean isLegalEntityNotDisplayed(){
        return webdriver.findElements(legalEntityNameInTable).isEmpty();
    }

}
