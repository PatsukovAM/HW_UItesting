package lesson7.crm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmContactPage extends CrmBaseView {

    @FindBy(xpath = "//a[@class='btn back icons-holder-text ']")
    public WebElement aCreateNewContact;

    public CrmContactPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на страницу \"Контактные лица\"")
    public CrmContactPage openPage() {
        driver.get("https://crm.geekbrains.space/contact/");
        return this;
    }

    @Step("Клик на \"Создать контактное лицо\"")
    public void createNewContact() {
        aCreateNewContact.click();
    }
}
