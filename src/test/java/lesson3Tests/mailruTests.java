package lesson3Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
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

public class mailruTests {

    @Order(1)
    @Test
    public void endToEndSendEmptyMailTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://mail.ru/");
        driver.findElement(By.name("login")).sendKeys("pustyshkin97");
        driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        driver.findElement(By.xpath("//input[@data-testid='password-input']")).sendKeys("zxc56nm&");
        driver.findElement(By.xpath("//button[@data-testid='login-to-mail']")).click();
        Thread.sleep(7000);

        driver.findElement(By.xpath("//a[@data-title-shortcut='N']")).click();
        driver.findElement(By.xpath("//input[contains(@class,'container') and @tabindex=100 ]"))
                .sendKeys("cafemi4940@koldpak.com");
        driver.findElement(By.xpath("//span[@class='button2__txt' and contains(.,'Отправить')]")).click();
        driver.findElement(By.xpath("//button[@data-test-id='false'][1]")).click();


        WebElement checkMessage = driver.findElement(By.xpath("//a[@class='layer__link']"));
        assertThat(checkMessage.getText(),equalTo("Письмо отправлено"));

        Thread.sleep(5000);
        driver.quit();

    }

    @Order(2)
    @Test
    public void endToEndMoveAllMailFromSendsToSketchesTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://mail.ru/");
        driver.findElement(By.name("login")).sendKeys("pustyshkin97");
        driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        driver.findElement(By.xpath("//input[@data-testid='password-input']")).sendKeys("zxc56nm&");
        driver.findElement(By.xpath("//button[@data-testid='login-to-mail']")).click();
        Thread.sleep(7000);

        driver.findElement(By.xpath("//a[@Title='Отправленные']")).click();
        driver.findElement(By.xpath("//span[@class='button2__ico'][1]")).click(); //не смог найти ничего изящнее :(
        driver.findElement(By.xpath("//span[@class='button2__wrapper button2__wrapper_centered' and " +
                "parent::span[@class='button2 button2_has-ico button2_has-ico-s button2_folder-move button2_pure " +
                "button2_compact button2_ico-text-top button2_hover-support js-shortcut']]")).click();
        driver.findElement(By.xpath("//div[contains(.,'Черновики') and parent::div[@class='list-item__text']]"))
                .click();

        WebElement checkMessage = driver.findElement(By.xpath("//span[@class='octopus__title']"));
        assertThat(checkMessage.getText(),equalTo("В папке нет писем."));

        Thread.sleep(5000);
        driver.quit();
    }

    @Order(3)
    @Test
    public void endToEndMoveAllMailFromSketchesToSendsTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://mail.ru/");
        driver.findElement(By.name("login")).sendKeys("pustyshkin97");
        driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        driver.findElement(By.xpath("//input[@data-testid='password-input']")).sendKeys("zxc56nm&");
        driver.findElement(By.xpath("//button[@data-testid='login-to-mail']")).click();
        Thread.sleep(7000);

        driver.findElement(By.xpath("//a[@Title='Черновики']")).click();
        driver.findElement(By.xpath("//span[@class='button2__ico'][1]")).click();//очередное топорное решение
        driver.findElement(By.xpath("//span[contains(.,'В папку') and " +
                "parent::span[@class='button2__wrapper button2__wrapper_centered']]")).click();
        driver.findElement(By.xpath("//div[contains(.,'Отправленные') and parent::div[@class='list-item__text']]"))
                .click();

        WebElement checkMessage = driver.findElement(By.xpath("//span[@class='octopus__title']"));
        //вот тут я вообще не понял разницы в ассерте
        assertThat(checkMessage.getText(),equalTo("У вас нет незаконченных\\nили неотправленных писем"));

        Thread.sleep(5000);
        driver.quit();

    }

}