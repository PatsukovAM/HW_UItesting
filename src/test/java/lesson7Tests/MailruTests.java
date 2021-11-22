package lesson7Tests;


import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson7.mailru.MailruDraftsPage;
import lesson7.mailru.MailruInboxPage;
import lesson7.mailru.MailruMainPage;
import lesson7.mailru.MailruSendPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@Story("Mail.ru tests")

public class MailruTests {

    static final String LOGIN = "pustyshkin97";
    static final String PASSWORD = "zxc56nm&";
    static final String WRONG_PASSWORD = "mistake";

    static final String TEST_1_CHECK_MESSAGE = "Письмо отправлено";
    static final String TEST_2_CHECK_MESSAGE = "В папке нет писем.";
    static final String TEST_3_CHECK_MESSAGE = "У вас нет незаконченных\nили неотправленных писем";

    //EventFiringWebDriver driver;
    WebDriver driver;
    WebDriverWait webDriverWait;


    @BeforeAll
    static void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeEach
    void initBrowser() {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        //driver = new EventFiringWebDriver( new ChromeDriver(options));
        //driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mailruLogin(driver, webDriverWait);
    }

    static void mailruLogin(WebDriver driver, WebDriverWait webDriverWait) {

        new MailruMainPage(driver, webDriverWait)
                .openPage()
                .typeLogin(LOGIN)
                .typePassword(PASSWORD)
                .login();

    }

    @Test
    @Feature("Тестирование основного функционала")
    @DisplayName("Создние и отправка нового пустого письма")
    @Order(1)
    public void endToEndSendEmptyMailTest() {

        String checkMessage = new MailruInboxPage(driver)
                .createNewMail()
                .typeAddress()
                .sendMail()
                .checkout();

        assertThat(checkMessage, equalTo(TEST_1_CHECK_MESSAGE));

    }

    @Test
    @Feature("Тестирование вспомогатаельного функционала")
    @DisplayName("Перемещение всех писем из раздела \"Отправленные\" в раздел \"Черновики\"")
    @Order(2)
    public void endToEndMoveAllMailFromSendsToDraftsTest() {

        String checkMessage = new MailruSendPage(driver)
                .openPage()
                .selectAll()
                .moveToDrafts()
                .checkout();

        assertThat(checkMessage, equalTo(TEST_2_CHECK_MESSAGE));

    }

    @Test
    @Feature("Тестирование вспомогатаельного функционала")
    @DisplayName("Перемещение всех писем из раздела \"Черновики\" в раздел \"Отправленные\"")
    @Order(3)
    public void endToEndMoveAllMailFromDraftsToSendsTest() {

        String checkMessage = new MailruDraftsPage(driver)
                .openPage()
                .selectAll()
                .moveToSend()
                .checkout();

        assertThat(checkMessage, equalTo(TEST_3_CHECK_MESSAGE));

    }
//тут было попытка сделать исключение для скриншота
/*    @Test
    @Feature("Тестировние обработки исключения")
    @DisplayName("Тестирование скриншота исключения")
    @Order(4)
    public void wrongAuthenticationTest () {

        new MailruInboxPage(driver)
                .logOut();

        new MailruMainPage(driver, webDriverWait)
                .openPage()
                .typeLogin(LOGIN)
                .typePassword(WRONG_PASSWORD)
                .login();
    }*/

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
