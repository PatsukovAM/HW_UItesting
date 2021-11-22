package lesson7.crm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmProjectPage extends CrmBaseView {

    @FindBy(xpath = "//a[contains(@title,\"Создать проект\")]")
    public WebElement aProjectCreate;

    @Step("Переход на страницу \"Мои проекты\"")
    public CrmProjectPage openPage() {
        driver.get("https://crm.geekbrains.space/project/my");
        return this;
    }

    @Step("Клик на \"Создать проект\"")
    public void createProjectClick() {
        aProjectCreate.click();
    }


    public CrmProjectPage(WebDriver driver) {
        super(driver);
    }

}
