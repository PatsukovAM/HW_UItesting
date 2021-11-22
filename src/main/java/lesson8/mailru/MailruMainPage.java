package lesson8.mailru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lesson7.mailru.MailruBaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;


public class MailruMainPage {


    private SelenideElement inputLogin=$(By.name("login"));
    private SelenideElement buttonSwitchToTypePassword=$(By.xpath("//button[@data-testid='enter-password']"));
    private SelenideElement inputPassword=$(By.xpath("//input[@data-testid='password-input']"));
    private SelenideElement buttonLogin=$(By.xpath("//button[@data-testid='login-to-mail']"));
    private SelenideElement aWait=$(By.xpath("//a[@data-title-shortcut='N']"));


    @Step("Переход на стартовую страницу \"Mail.ru\"")
    public MailruMainPage openPage() {
        Configuration.headless=true;
        Selenide.open("https://mail.ru/");
        return this;
    }

    @Step("Заполнение поля \"имя ящика\"")
    public MailruMainPage typeLogin (String login) {
        inputLogin.sendKeys(login);
        buttonSwitchToTypePassword.click();
        return this;
    }

    @Step("Заполнение поля \"Пароль\"")
    public MailruMainPage typePassword (String password) {
        inputPassword.sendKeys(password);
        return this;
    }
    @Step("Клик на \"Войти\"")
    public void login() {
        buttonLogin.click();
        $(aWait).shouldBe(Condition.visible, Duration.ofSeconds(5));

    }
}

