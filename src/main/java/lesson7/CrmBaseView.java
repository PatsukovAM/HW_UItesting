package lesson7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CrmBaseView {

    WebDriver driver;

    public CrmBaseView(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
