package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmContactPage extends CrmBaseView {

    @FindBy(xpath = "//a[@class='btn back icons-holder-text ']")
    public WebElement aCreateNewContact;

    public CrmContactPage(WebDriver driver) {
        super(driver);
    }

    public CrmContactPage openPage() {
        driver.get("https://crm.geekbrains.space/contact/");
        return this;
    }

    public void createNewContact() {
        aCreateNewContact.click();
    }
}
