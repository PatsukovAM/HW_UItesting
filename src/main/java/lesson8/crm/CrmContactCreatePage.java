package lesson8.crm;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import static com.codeborne.selenide.Selenide.$;

public class CrmContactCreatePage  {


    private SelenideElement inputLastName= $(By.name("crm_contact[lastName]"));
    private SelenideElement inputFirstName=$(By.name("crm_contact[firstName]"));
    private SelenideElement spanChoiceOrganization=
            $(By.xpath("//span[@class='select2-chosen' and contains(.,'Укажите организацию')]"));
    private SelenideElement divChoseOrganization=
            $(By.xpath("//div[@class='select2-result-label' and text()='12323142342134']"));
    private SelenideElement inputJobTitle= $(By.name("crm_contact[jobTitle]"));
    private SelenideElement selectContactStatus=$(By.name("crm_contact[status]"));
    private SelenideElement buttonSuccessCreate=$(By.xpath("//button[@class='btn btn-success action-button']"));
    private SelenideElement divCheck=$(By.xpath("//div[@class='message']"));

    @Step("Заполнение поля \"фамилия\"")
    public CrmContactCreatePage typeLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }
    @Step("Заполнение поля \"имя\"")
    public CrmContactCreatePage typeFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }
    @Step("Выбор организации")
    public CrmContactCreatePage choseOrganization() {
        spanChoiceOrganization.click();
        divChoseOrganization.click();
        return this;
    }
    @Step("Заполнение поля \"должность\"")
    public CrmContactCreatePage typeJobTitle(String jobTitle) {
        inputJobTitle.sendKeys(jobTitle);
        return this;
    }
    @Step("Выбор статуса контакта")
    public CrmContactCreatePage selectContactStatus(String status) {
        selectContactStatus.selectOptionContainingText(status);
        return this;
    }
    @Step("Клик на \"Сохранить и закрыть\"")
    public CrmContactCreatePage successCreate() {
        buttonSuccessCreate.click();
        return this;
    }
    @Step("Проверка условия")
    public SelenideElement checkout() {
        return divCheck;
    }

}
