package lesson7.crm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CrmProjectCreatePage extends CrmBaseView {

    @FindBy(xpath = "//input[@data-ftid='crm_project_name']")
    public WebElement inputProjectName;

    @FindBy(xpath = "//span[@class='select2-chosen' and contains(.,'Укажите организацию')]")
    public WebElement spanOrganizationName;

    @FindBy(xpath = "//div[@class='select2-result-label' and text()='12323142342134']")
    public WebElement selectOrganizationName;

    @FindBy(xpath = "//input[@data-name='field__1']")
    public WebElement inputProjectType;

    @FindBy(name = "crm_project[priority]")
    public WebElement selectProjectPriority;

    @FindBy(name = "crm_project[financeSource]")
    public WebElement selectProjectFinanceSource;

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement selectProjectBusinessUnit;

    @FindBy(name = "crm_project[curator]")
    public WebElement selectProjectCurator;

    @FindBy(name = "crm_project[rp]")
    public WebElement selectProjectDirector;

    @FindBy(name = "crm_project[administrator]")
    public WebElement selectProjectAdministrator;

    @FindBy(name = "crm_project[manager]")
    public WebElement selectProjectManager;

    @FindBy(xpath = "//button[contains(.,'Сохранить и закрыть')]")
    public WebElement buttonSaveAndClose;

    @FindBy(xpath = "//span[@class='validation-failed']")
    public WebElement spanCheck;

    public CrmProjectCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение поля \"Наименование\"")
    public CrmProjectCreatePage typeProjectName(String projectName) {
        inputProjectName.sendKeys(projectName);
        return this;
    }

    @Step("Выбор организации")
    public CrmProjectCreatePage inputOrganization() {
        spanOrganizationName.click();
        selectOrganizationName.click();
        return this;
    }

    @Step("Выбор типа проекта")
    public CrmProjectCreatePage choiceProjectType() {
        inputProjectType.click();
        return this;
    }

    @Step("Выбор приоритете проекта")
    public CrmProjectCreatePage selectPriority(String priority) {
        new Select(selectProjectPriority).selectByVisibleText(priority);
        return this;
    }

    @Step("Выбор источника финансирования")
    public CrmProjectCreatePage selectFinanceSource(String finance) {
        new Select(selectProjectFinanceSource).selectByVisibleText(finance);
        return this;
    }

    @Step("Выбор подразделения")
    public CrmProjectCreatePage selectBusinessUnit(String unit) {
        new Select(selectProjectBusinessUnit).selectByVisibleText(unit);
        return this;
    }

    @Step("Выбор куратора проекта")
    public CrmProjectCreatePage selectCurator(String curator) {
        new Select(selectProjectCurator).selectByVisibleText(curator);
        return this;
    }

    @Step("Выбор руководителя проекта")
    public CrmProjectCreatePage selectDirector(String director) {
        new Select(selectProjectDirector).selectByVisibleText(director);
        return this;
    }

    @Step("Выбор куратора проекта")
    public CrmProjectCreatePage selectAdministrator(String administrator) {
        new Select(selectProjectAdministrator).selectByVisibleText(administrator);
        return this;
    }

    @Step("Выбор менеджера проекта")
    public CrmProjectCreatePage selectManager(String manager) {
        new Select(selectProjectManager).selectByVisibleText(manager);
        return this;
    }

    @Step("Клик на  \"Сохранить и закрыть\"")
    public CrmProjectCreatePage saveAndClose() {
        buttonSaveAndClose.click();
        return this;
    }

    @Step("Проверка условия")
    public String checkout() {
        return spanCheck.getText();
    }

}
