package lesson7;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MailruSendPage extends MailruBaseView {

    @FindBy(xpath = "//a[@Title='Отправленные']")
    public WebElement aToSend;

    @FindBy(xpath ="//span[@title='Выделить все']//span[@Class='button2__ico']" )
    public WebElement spanSelectAll;

    @FindBy(xpath = "//span[@class='button2__wrapper button2__wrapper_centered' and " +
            "parent::span[@class='button2 button2_has-ico button2_has-ico-s button2_folder-move button2_pure " +
            "button2_compact button2_ico-text-top button2_hover-support js-shortcut']]")
    public WebElement spanInDirectory;

    @FindBy(xpath = "//div[contains(.,'Черновики') and parent::div[@class='list-item__text']]")
    public WebElement divToDrafts;

    @FindBy(xpath ="//span[@class='octopus__title']" )
    public WebElement spanCheck;

    public MailruSendPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на страницу \"Отправленные\"")
    public MailruSendPage openPage(){
        aToSend.click();
        return this;
    }

    @Step("Клик на  \"Выделить все\"")
    public MailruSendPage selectAll() {
        spanSelectAll.click();
        return this;
    }

    @Step("Перемещение в раздел \"Черновики\"")
    public MailruSendPage moveToDrafts(){
        spanInDirectory.click();
        divToDrafts.click();
        return this;
    }

    @Step("проверка условия")
    public String checkout(){
        return spanCheck.getText();
    }
}
