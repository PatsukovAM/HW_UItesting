package lesson6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CrmContactCreatePage extends CrmBaseView {

    @FindBy(name = "crm_contact[lastName]")
    public WebElement inputLastName;

    @FindBy(name = "crm_contact[firstName]")
    public WebElement inputFirstName;

    @FindBy(xpath = "//span[@class='select2-chosen' and contains(.,'Укажите организацию')]")
    public WebElement spanChoiceOrganization;

    @FindBy(xpath = "//div[@class='select2-result-label' and text()='12323142342134']")
    public WebElement divChoseOrganization;

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement inputJobTitle;

    @FindBy(name = "crm_contact[status]")
    public WebElement selectContactStatus;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement buttonSuccessCreate;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement divCheck;


    public CrmContactCreatePage(WebDriver driver) {
        super(driver);
    }

    public CrmContactCreatePage typeLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    public CrmContactCreatePage typeFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }

    public CrmContactCreatePage choseOrganization() {
        spanChoiceOrganization.click();
        divChoseOrganization.click();
        return this;
    }

    public CrmContactCreatePage typeJobTitle(String jobTitle) {
        inputJobTitle.sendKeys(jobTitle);
        return this;
    }

    public CrmContactCreatePage selectContactStatus(String status) {
        new Select(selectContactStatus).selectByVisibleText(status);
        return this;
    }

    public CrmContactCreatePage successCreate() {
        buttonSuccessCreate.click();
        return this;
    }

    public String checkout() {
        return divCheck.getText();
    }

}
