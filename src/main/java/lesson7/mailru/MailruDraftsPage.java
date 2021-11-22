package lesson7.mailru;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailruDraftsPage extends  MailruBaseView {

    @FindBy(xpath = "//a[@Title='Черновики']")
    public WebElement aToDrafts;

    @FindBy(xpath = "//span[@class='button2__ico'][1]")
    public WebElement spanSelectAll;

    @FindBy(xpath ="//span[contains(.,'В папку') and " +
            "parent::span[@class='button2__wrapper button2__wrapper_centered']]")
    public WebElement spanInDirectory;

    @FindBy(xpath = "//div[contains(.,'Отправленные') and parent::div[@class='list-item__text']]")
    public WebElement divToSend;

    @FindBy(xpath = "//span[@class='octopus__title']")
    public WebElement spanCheck;

    public MailruDraftsPage (WebDriver driver) {
        super(driver);
    }

    @Step("Переход на страницу \"Черновики\"")
    public MailruDraftsPage openPage() {
        aToDrafts.click();
        return this;
    }

    @Step("Клик на \"Выделить все\"")
    public MailruDraftsPage selectAll() {
        spanSelectAll.click();
        return this;
    }

    @Step("Перемещение в раздел \"Отправленные\"")
    public MailruDraftsPage moveToSend() {
        spanInDirectory.click();
        divToSend.click();
        return this;
    }
    @Step("Проверка условия")
    public String checkout(){
        return spanCheck.getText();
    }
}
