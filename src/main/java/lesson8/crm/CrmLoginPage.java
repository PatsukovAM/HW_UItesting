package lesson8.crm;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class CrmLoginPage {


    private SelenideElement inputLogin = $(By.id("prependedInput"));

    private SelenideElement inputPassword = $(By.id("prependedInput2"));

    private SelenideElement buttonLogin = $(By.id("_submit"));

    @Step("Заполнение поля \"Логин\"")
    public CrmLoginPage typeLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Переход на страницу логирования")
    public CrmLoginPage openPage() {
        Configuration.headless=true;
        Selenide.open("https://crm.geekbrains.space/user/login");
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

}
