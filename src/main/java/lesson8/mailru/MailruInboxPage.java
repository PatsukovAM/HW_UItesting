package lesson8.mailru;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MailruInboxPage {


    private SelenideElement aWriteNewMail = $(By.xpath("//a[@data-title-shortcut='N']"));
    private SelenideElement inputAddress = $(By.xpath("//input[contains(@class,'container') and @tabindex=100 ]"));
    private SelenideElement spanSend = $(By.xpath("//span[@class='button2__txt' and contains(.,'Отправить')]"));
    private SelenideElement buttonConfirmSend = $(By.xpath("//button[@data-test-id='false'][1]"));
    private SelenideElement aCheck = $(By.xpath("//a[@class='layer__link']"));
    private SelenideElement divAccountMenu = $(By.xpath("//div[@data-testid='whiteline-account']"));
    private SelenideElement aLogOut = $(By.xpath("//a[@data-click-counter=\"75068944\"]"));

    @Step("Клик на \"Написать\"")
    public MailruInboxPage createNewMail() {
        aWriteNewMail.click();
        return this;
    }

    @Step("Заполнение поля \"Кому\"")
    public MailruInboxPage typeAddress(String recipient) {
        inputAddress.sendKeys(recipient);
        return this;
    }

    @Step("Клик на \"Отправить\" и Клик на \"Отправить\" (подтверждение отправки пустого письма)")
    public MailruInboxPage sendMail() {
        spanSend.click();
        buttonConfirmSend.click();
        return this;
    }

    @Step("Проверка условия")
    public SelenideElement checkout() {
        return aCheck;
    }

    @Step("Выход из аккаунта")
    public void logOut() {
        divAccountMenu.click();
        aLogOut.click();
    }
}
