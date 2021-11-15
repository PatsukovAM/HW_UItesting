package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmProjectPage extends CrmBaseView {

    @FindBy(xpath = "//a[contains(@title,\"Создать проект\")]")
    public WebElement aProjectCreate;

    public CrmProjectPage openPage() {
        driver.get("https://crm.geekbrains.space/project/my");
        return this;
    }

    public void createProjectClick() {
        aProjectCreate.click();
    }


    public CrmProjectPage(WebDriver driver) {
        super(driver);
    }

}
