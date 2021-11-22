package lesson7.crm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmLoginPage extends CrmBaseView {

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonLogin;

    @Step("Заполнение поля \"Логин\"")
    public CrmLoginPage typeLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }
    @Step("Переход на страницу логирования")
    public CrmLoginPage openPage() {
        driver.get("https://crm.geekbrains.space/user/login");
        return this;
    }
    @Step("Заполнение поля \"Пароль\"")
    public CrmLoginPage typePassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }
    @Step("Клик на \"Войти\"")
    public void submitLogin() {
        buttonLogin.click();
    }

    public CrmLoginPage(WebDriver driver) {
        super(driver);
    }
}
