package lesson6;

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

    public MailruDraftsPage openPage() {
        aToDrafts.click();
        return this;
    }

    public MailruDraftsPage selectAll() {
        spanSelectAll.click();
        return this;
    }

    public MailruDraftsPage moveToSend() {
        spanInDirectory.click();
        divToSend.click();
        return this;
    }

    public String checkout(){
        return spanCheck.getText();
    }
}
