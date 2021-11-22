package lesson8.crm;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class CrmContactPage  {


    private SelenideElement aCreateNewContact =$(By.xpath("//a[@class='btn back icons-holder-text ']"));

    @Step("Переход на страницу \"Контактные лица\"")
    public CrmContactPage openPage() {
        Selenide.open("https://crm.geekbrains.space/contact/");
        return this;
    }

    @Step("Клик на \"Создать контактное лицо\"")
    public void createNewContact() {
        aCreateNewContact.click();
    }
}
