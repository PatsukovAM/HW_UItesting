package lesson7.mailru;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MailruMainPage extends MailruBaseView {

    WebDriverWait webDriverWait;


    @FindBy(name = "login")
    public WebElement inputLogin;

    @FindBy(xpath ="//button[@data-testid='enter-password']" )
    public WebElement buttonSwitchToTypePassword;

    @FindBy(xpath = "//input[@data-testid='password-input']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@data-testid='login-to-mail']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//a[@data-title-shortcut='N']")
    public WebElement aWait;

    public MailruMainPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver);
        this.webDriverWait=webDriverWait;
    }

    @Step("Переход на стартовую страницу \"Mail.ru\"")
    public MailruMainPage openPage() {
        driver.get("https://mail.ru/");
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
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-title-shortcut='N']")));
    }
}

