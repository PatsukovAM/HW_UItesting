package lesson5Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CrmTests {

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        crmLogin(driver);
    }

    static void crmLogin(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

    @Test
    @Order(1)
    public void createNewProjectTest() {

        driver.get("https://crm.geekbrains.space/project/my");
        driver.findElement(By.xpath("//a[contains(@title,\"Создать проект\")]")).click();
        driver.findElement(By.xpath("//input[@data-ftid='crm_project_name']")).sendKeys("HW_Project0311");
        driver.findElement(By.xpath("//span[@class='select2-chosen' and contains(.,'Укажите организацию')]")).click();
        driver.findElement(By.xpath("//div[@class='select2-result-label' and text()='12323142342134']")).click();
        driver.findElement(By.xpath("//input[@data-name='field__1']")).click();
        Select selectPriority = new Select(driver.findElement(By.name("crm_project[priority]")));
        selectPriority.selectByVisibleText("Средний");
        Select selectFinanceSource = new Select(driver.findElement(By.name("crm_project[financeSource]")));
        selectFinanceSource.selectByVisibleText("Внутреннее");
        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");
        Select selectProjectCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectProjectCurator.selectByVisibleText("Юзеров Юзер");
        Select selectProjectRp = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectProjectRp.selectByVisibleText("Applanatest Applanatest Applanatest");
        Select selectProjectAdministrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        selectProjectAdministrator.selectByVisibleText("Applanatest Applanatest Applanatest");
        Select selectProjectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectProjectManager.selectByVisibleText("Юзеров Юзер");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();

        WebElement checkMessage = driver.findElement(By.xpath("//span[@class='validation-failed']"));
        assertThat(checkMessage.getText(), equalTo("Это значение уже используется."));

    }

    @Test
    @Order(2)
    public void createNewContactPersonTest() {

        driver.get("https://crm.geekbrains.space/contact/");
        driver.findElement(By.xpath("//a[@class='btn back icons-holder-text ']")).click();
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Пустышкин");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Василий");
        driver.findElement(By.xpath("//span[@class='select2-chosen' and contains(.,'Укажите организацию')]")).click();
        driver.findElement(By.xpath("//div[@class='select2-result-label' and text()='12323142342134']")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Старший");
        Select selectContactStatus = new Select(driver.findElement(By.name("crm_contact[status]")));
        selectContactStatus.selectByVisibleText("Активный");
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();

        WebElement checkMessage = driver.findElement(By.xpath("//div[@class='message']"));
        assertThat(checkMessage.getText(), equalTo("Контактное лицо сохранено"));
    }

    @Test
    @Order(3)
    public void shiftRowsTest() {

        driver.get("https://crm.geekbrains.space/dashboard");
        driver.findElement(By.xpath("//div[@class='column-manager dropdown']")).click();

        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//label[.='Владелец']/ancestor::tr//span")))
                .dragAndDrop(driver.findElement(By.xpath("//label[.='Владелец']/ancestor::tr")),
                        driver.findElement(By.xpath("//label[.='Наименование']/ancestor::tr")))
                .build()
                .perform();

        webDriverWait.until(d -> d.findElements(
                        By.xpath("//thead[@class='grid-header']//tr[@class='grid-header-row']/th[contains(@class, 'sort')]"))
                .get(0).getText().equals("ВЛАДЕЛЕЦ"));

        List<WebElement> header = driver.findElements(
                By.xpath("//thead[@class='grid-header']//tr[@class='grid-header-row']/th[contains(@class, 'sort')]"));

        assertThat(header.get(0).getText(), equalTo("ВЛАДЕЛЕЦ"));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
