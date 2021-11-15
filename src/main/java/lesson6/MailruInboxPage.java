package lesson6;


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

    public MailruInboxPage(WebDriver driver) {
        super(driver);
    }

    public MailruInboxPage createNewMail() {
        aWriteNewMail.click();
        return this;
    }

    public MailruInboxPage typeAddress() {
        inputAddress.sendKeys("cafemi4940@koldpak.com");
        return this;
    }

    public MailruInboxPage sendMail() {
        spanSend.click();
        buttonConfirmSend.click();
        return this;
    }

    public String checkout() {
        return aCheck.getText();
    }


}
