package ru.myhrlink.apptest;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.myhrlink.apptest.pages.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static ru.myhrlink.apptest.TestData.*;


@DisplayName("Проверка недоступности юрлица, на которое у кадровика нет прав")
public class LegalEntityInaccessibilityTest extends BaseTest {

    @Test
    @DisplayName("Тест: недоступность юрлица для кадровика, на которое у него нет прав")
    public void testLegalEntityInaccessibilityForHrWithNoRightsForIt() {
        loginAsHr();
        assertAll(
                this::stepCheckDocumentIsNotDisplayed,
                this::stepCheckLegalEntityInFilterIsNotDisplayed,
                this::stepCheckApplicationIsNotDisplayed,
                this::stepCheckEmployeeIsNotDisplayed,
                this::stepCheckLegalEntityInCatalogIsNotDisplayed
        );
    }

    @Step("Шаг 1: В реестре документов не отображается документ, в котором в качестве сотрудника указан Орлов Д.")
    public void stepCheckDocumentIsNotDisplayed() {
        objDocumentRegistry.closeTelegramNotificationWindow();
        Assertions.assertTrue(objDocumentRegistry.isDocumentNotDisplayed(), "В реестре документов отображается документ сотрудника, на юрлицо которого у Кадровика нет прав");
    }

    @Step("Шаг 2: В фильтре \"Юрлицо\" в реестре документов не отображается юрлицо ООО \"Кот\"")
    public void stepCheckLegalEntityInFilterIsNotDisplayed() {
        Assertions.assertTrue(objDocumentRegistry.isLegalEntityInListBoxNotDisplayed(), "В фильтре Юрлицо в реестре сотрудников отображается юрлицо, на которое у Кадровика нет прав");
    }

    @Step("Шаг 3: В реестре заявлений не отображается заявление от Орлова Д.")
    public void stepCheckApplicationIsNotDisplayed(){
        tabNavigationManager.goToApplicationsRegistry();
        ApplicationsRegistryPage objApplicationRegistry = new ApplicationsRegistryPage(webdriver);
        Assertions.assertTrue(objApplicationRegistry.isApplicationNotDisplayed(), "В реестре заявлений отображается заявление от сотрудника, на юрлицо которого у Кадровика нет прав");
    }

    @Step("Шаг 4: В реестре сотрудников не отображается сотрудник Орлов Д")
    public void stepCheckEmployeeIsNotDisplayed() {
        tabNavigationManager.goToEmployeeRegistry();
        EmployeeRegistryPage objEmployeeRegistry = new EmployeeRegistryPage(webdriver);
        Assertions.assertTrue(objEmployeeRegistry.isEmployeeNotDisplayed(EMPLOYEE_NAME), "В реестре сотрудников отображается сотрудник, на юрлицо которого у Кадровика нет прав");
    }

    @Step("Шаг 5: В справочнике юрлиц нет ООО \"Кот\"")
    public void stepCheckLegalEntityInCatalogIsNotDisplayed(){
        tabNavigationManager.goToCatalogs();
        CatalogsPage objCatalog = new CatalogsPage(webdriver);
        Assertions.assertTrue(objCatalog.isLegalEntityNotDisplayed(), "В справочнике юрлиц отображается юрлицо, на которое у Кадровика нет прав");
    }
}
