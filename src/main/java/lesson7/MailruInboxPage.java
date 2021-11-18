package lesson7;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailruInboxPage extends MailruBaseView {

    @FindBy(xpath = "//a[@data-title-shortcut='N']" )
    public WebElement aWriteNewMail;

    @FindBy(xpath = "//input[contains(@class,'container') and @tabindex=100 ]")
    public WebElement inputAddress;

    @FindBy(xpath ="//span[@class='button2__txt' and contains(.,'Отправить')]" )
    public WebElement spanSend;

    @FindBy(xpath = "//button[@data-test-id='false'][1]")
    public WebElement buttonConfirmSend;

    @FindBy(xpath = "//a[@class='layer__link']")
    public WebElement aCheck;

    @FindBy(xpath = "//div[@data-testid='whiteline-account']")
    public WebElement divAccountMenu;

    @FindBy(xpath = "//a[@data-click-counter=\"75068944\"]")
    public WebElement aLogOut;

    public MailruInboxPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик на \"Написать\"")
    public MailruInboxPage createNewMail() {
        aWriteNewMail.click();
        return this;
    }
    @Step("Заполнение поля \"Кому\"")
    public MailruInboxPage typeAddress() {
        inputAddress.sendKeys("cafemi4940@koldpak.com");
        return this;
    }

    @Step("Клик на \"Отправить\" и Клик на \"Отправить\" (подтверждение отправки пустого письма)")
    public MailruInboxPage sendMail() {
        spanSend.click();
        buttonConfirmSend.click();
        return this;
    }
    @Step("Проверка условия")
    public String checkout() {
        return aCheck.getText();
    }

    @Step("Выход из аккаунта")
    public void logOut() {
        divAccountMenu.click();
        aLogOut.click();
    }
}
