package lesson7.mailru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MailruBaseView {
    WebDriver driver;

    public MailruBaseView (WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
