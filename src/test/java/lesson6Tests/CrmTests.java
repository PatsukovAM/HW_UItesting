package lesson6Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CrmTests {

    static final String LOGIN = "Applanatest1";
    static final String PASSWORD = "Student2020!";
    static final String PROJECT_NAME = "HW_Project0311";

    static final String TEST_1_CHECK_MESSAGE = "Это значение уже используется.";
    static final String TEST_2_CHECK_MESSAGE = "Контактное лицо сохранено";
    static final String TEST_3_CHECK_MESSAGE = "ВЛАДЕЛЕЦ";

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        crmLogin(driver);
    }

    static void crmLogin(WebDriver driver) {

        new CrmLoginPage(driver)
                .openPage()
                .typeLogin(LOGIN)
                .typePassword(PASSWORD)
                .submitLogin();

    }

    @Test
    @Order(1)
    public void createNewProjectTest() {

        new CrmProjectPage(driver)
                .openPage()
                .createProjectClick();

        String checkMessage = new CrmProjectCreatePage(driver)
                .typeProjctName(PROJECT_NAME)
                .inputOrganization()
                .choiceProjectType()
                .selectPriority("Средний")
                .selectFinanceSource("Внутреннее")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Юзеров Юзер")
                .selectDirector("Applanatest Applanatest Applanatest")
                .selectAdministrator("Applanatest Applanatest Applanatest")
                .selectManager("Юзеров Юзер")
                .saveAndClose()
                .checkout();

        assertThat(checkMessage, equalTo(TEST_1_CHECK_MESSAGE));

    }

    @Test
    @Order(2)
    public void createNewContactPersonTest() {

        new CrmContactPage(driver)
                .openPage()
                .createNewContact();

        String checkMessage = new CrmContactCreatePage(driver)
                .typeLastName("Пустышкин")
                .typeFirstName("Василий")
                .choseOrganization()
                .typeJobTitle("Старший")
                .selectContactStatus("Активный")
                .successCreate()
                .checkout();

        assertThat(checkMessage, equalTo(TEST_2_CHECK_MESSAGE));


    }

    @Test
    @Order(3)
    public void changeColumnsTest() {

        String checkMessage = new CrmDashboardPage(driver, webDriverWait)
                .openPage()
                .setUpView()
                .changeColumns()
                .checkout();

        assertThat(checkMessage, equalTo(TEST_3_CHECK_MESSAGE));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
