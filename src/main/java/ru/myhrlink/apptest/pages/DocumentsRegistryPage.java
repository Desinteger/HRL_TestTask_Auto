package ru.myhrlink.apptest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class DocumentsRegistryPage {

    private WebDriver webdriver;
    public DocumentsRegistryPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private static final By cancelTelegramNotificationButton = xpath(".//span[contains(text(),'Отмена')]");
    private static final By employeeName = xpath(".//span[contains(text(),'Орлов')]");
    private static final By legalEntityFilter = xpath(".//div[8]//input[@type='text']");
    private static final By legalEntity = xpath(".//span[@class='ng-star-inserted'][contains(text(),'ООО Кот')]");

    public void closeTelegramNotificationWindow(){
        webdriver.findElement(cancelTelegramNotificationButton).click();
    }

    //Метод проверяет, что документ, в котором в качестве сотрудника указан Орлов, не отображается в реестре документов
    public boolean isDocumentNotDisplayed(){
        return webdriver.findElements(employeeName).isEmpty();
    }

    //Метод открывает фильтр "Юрлицо" в реестре документов и проверяет, что в списке нет юрлица с названием "ООО Кот"
    public boolean isLegalEntityInListBoxNotDisplayed() {
        webdriver.findElement(legalEntityFilter).click();
        return webdriver.findElements(legalEntity).isEmpty();
    }

}
