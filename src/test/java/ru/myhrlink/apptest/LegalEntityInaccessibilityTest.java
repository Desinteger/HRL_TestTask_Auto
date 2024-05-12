package ru.myhrlink.apptest;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.myhrlink.apptest.pages.*;

import static ru.myhrlink.apptest.TestData.*;
import static org.junit.Assert.assertTrue;


@DisplayName("Проверка недоступности юрлица, на которое у кадровика нет прав")
public class LegalEntityInaccessibilityTest extends BaseTest {

    @Test
    @DisplayName("Тест: недоступность юрлица для кадровика, на которое у него нет прав")
    public void testLegalEntityInaccessibilityForHrWithNoRightsForIt() {
        loginAsHr();
        stepCheckDocumentIsNotDisplayed();
        stepCheckLegalEntityNotDisplayed();
        stepCheckApplicationNotDisplayed();
        stepCheckEmployeeNotDisplayed();
        stepCheckLegalEntityInCatalogIsNotDisplayed();
    }

    @Step("Шаг 1: В реестре документов не отображается документ, в котором в качестве сотрудника указан Орлов Д.")
    public void stepCheckDocumentIsNotDisplayed() {
        objDocumentRegistry.closeTelegramNotificationWindow();
        assertTrue(objDocumentRegistry.isDocumentNotDisplayed());
    }

    @Step("Шаг 2: В фильтре \"Юрлицо\" в реестре документов не отображается юрлицо ООО \"Кот\"")
    public void stepCheckLegalEntityNotDisplayed() {
        assertTrue(objDocumentRegistry.isLegalEntityInListBoxNotDisplayed());
    }

    @Step("Шаг 3: В реестре заявлений не отображается заявление от Орлова Д.")
    public void stepCheckApplicationNotDisplayed(){
        tabNavigationManager.goToApplicationsRegistry();
        ApplicationsRegistryPage objApplicationRegistry = new ApplicationsRegistryPage(webdriver);
        assertTrue(objApplicationRegistry.isApplicationNotDisplayed());
    }

    @Step("Шаг 4: В реестре сотрудников не отображается сотрудник Орлов Д")
    public void stepCheckEmployeeNotDisplayed() {
        tabNavigationManager.goToEmployeeRegistry();
        EmployeeRegistryPage objEmployeeRegistry = new EmployeeRegistryPage(webdriver);
        assertTrue(objEmployeeRegistry.isEmployeeNotDisplayed(EMPLOYEE_NAME));
    }

    @Step("Шаг 5: В справочнике юрлиц нет ООО \"Кот\"")
    public void stepCheckLegalEntityInCatalogIsNotDisplayed(){
        tabNavigationManager.goToCatalogs();
        CatalogsPage objCatalog = new CatalogsPage(webdriver);
        assertTrue(objCatalog.isLegalEntityNotDisplayed());
    }
}
