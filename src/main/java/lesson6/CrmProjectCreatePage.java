package lesson6;

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

    public CrmProjectCreatePage typeProjctName(String projectName) {
        inputProjectName.sendKeys(projectName);
        return this;
    }

    public CrmProjectCreatePage inputOrganization() {
        spanOrganizationName.click();
        selectOrganizationName.click();
        return this;
    }

    public CrmProjectCreatePage choiceProjectType() {
        inputProjectType.click();
        return this;
    }

    public CrmProjectCreatePage selectPriority(String priority) {
        new Select(selectProjectPriority).selectByVisibleText(priority);
        return this;
    }

    public CrmProjectCreatePage selectFinanceSource(String finance) {
        new Select(selectProjectFinanceSource).selectByVisibleText(finance);
        return this;
    }

    public CrmProjectCreatePage selectBusinessUnit(String unit) {
        new Select(selectProjectBusinessUnit).selectByVisibleText(unit);
        return this;
    }

    public CrmProjectCreatePage selectCurator(String curator) {
        new Select(selectProjectCurator).selectByVisibleText(curator);
        return this;
    }

    public CrmProjectCreatePage selectDirector(String director) {
        new Select(selectProjectDirector).selectByVisibleText(director);
        return this;
    }

    public CrmProjectCreatePage selectAdministrator(String administrator) {
        new Select(selectProjectAdministrator).selectByVisibleText(administrator);
        return this;
    }

    public CrmProjectCreatePage selectManager(String manager) {
        new Select(selectProjectManager).selectByVisibleText(manager);
        return this;
    }

    public CrmProjectCreatePage saveAndClose() {
        buttonSaveAndClose.click();
        return this;
    }

    public String checkout() {
        return spanCheck.getText();
    }

}
