package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CrmDashboardPage extends CrmBaseView {

    static final String TEST_3_CHECK_XPATH =
            "//thead[@class='grid-header']//tr[@class='grid-header-row']/th[contains(@class, 'sort')]";

        WebDriverWait webDriverWait;

    @FindBy(xpath = "//div[@class='column-manager dropdown']")
    public WebElement divSetUpView;

    @FindBy(xpath = "//label[.='Владелец']/ancestor::tr//span")
    public WebElement labelFirstChangeColumn;

    @FindBy(xpath = "//label[.='Владелец']/ancestor::tr")
    public WebElement labelDragColumn;

    @FindBy(xpath = "//label[.='Наименование']/ancestor::tr")
    public WebElement labelSecondChangeColumn;


    public CrmDashboardPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver);
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(driver,this);
    }

    public CrmDashboardPage openPage() {
        driver.get("https://crm.geekbrains.space/dashboard");
        return this;
    }

    public CrmDashboardPage setUpView() {
        divSetUpView.click();
        return this;
    }

    public CrmDashboardPage changeColumns() {
        new Actions(driver).clickAndHold(labelFirstChangeColumn)
                .dragAndDrop(labelDragColumn, labelSecondChangeColumn).build().perform();
        return this;
    }

    public String checkout() {
        webDriverWait.until(d -> d.findElements(
                        By.xpath(TEST_3_CHECK_XPATH))
                .get(0).getText().equals("ВЛАДЕЛЕЦ"));
        List<WebElement> header = driver.findElements(
                By.xpath(TEST_3_CHECK_XPATH));

        return header.get(0).getText();

    }

}
