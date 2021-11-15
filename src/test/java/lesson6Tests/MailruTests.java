package lesson6Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.MailruDraftsPage;
import lesson6.MailruInboxPage;
import lesson6.MailruMainPage;
import lesson6.MailruSendPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class MailruTests {

    static final String LOGIN = "pustyshkin97";
    static final String PASSWORD = "zxc56nm&";

    static final String TEST_1_CHECK_MESSAGE = "Письмо отправлено";
    static final String TEST_2_CHECK_MESSAGE = "В папке нет писем.";
    static final String TEST_3_CHECK_MESSAGE = "У вас нет незаконченных\nили неотправленных писем";

    WebDriver driver;
    WebDriverWait webDriverWait;


    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
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
    @Order(3)
    public void endToEndMoveAllMailFromDraftsToSendsTest() {

        String checkMessage = new MailruDraftsPage(driver)
                .openPage()
                .selectAll()
                .moveToSend()
                .checkout();

        assertThat(checkMessage, equalTo(TEST_3_CHECK_MESSAGE));

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
