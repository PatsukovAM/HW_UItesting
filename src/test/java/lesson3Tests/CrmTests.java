package lesson3Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;


public class CrmTests {

    //хотел по-нормальному, но не пошло...
/*   static WebDriver driver;
    @BeforeEach
    public static void setUp(){
       WebDriverManager.chromedriver().setup();
       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
       driver= new ChromeDriver();
       //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

       driver.get("https://crm.geekbrains.space/user/login");
       driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
       driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
       driver.findElement(By.id("_submit")).click();
    }*/


    @Order(1)
    @Test
    public void createNewProjectTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

        driver.get("https://crm.geekbrains.space/project/my");
        driver.findElement(By.xpath("//a[contains(@title,\"Создать проект\")]")).click();
        /*WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-ftid='crm_project_name']")));
                вылазило вот это:
                java: cannot access java.util.function.Function
  class file for java.util.function.Function not found
                внятного решения я не нашел
                */
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

        Thread.sleep(5000);
        driver.quit();

    }

    @Order(2)
    @Test
    public void createNewContactPersonTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

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

        Thread.sleep(5000);
        driver.quit();

    }
// еще одни остатки "нормльности")
/*    @AfterEach
    public static void tearDown(WebDriver driver) throws InterruptedException {
       Thread.sleep(5000);
       driver.quit();
    }*/
}
