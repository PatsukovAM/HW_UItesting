package lesson7.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrmExpensesSubMenu extends CrmBaseView {

    @FindBy(xpath = "//span[.='Заявки на расходы']")
    public WebElement expensesSubmenuItem;

    public CrmExpensesSubMenu (WebDriver driver) {
        super(driver);
    }

    public void expensesSubmenuItemClick() {
        expensesSubmenuItem.click();
    }



}
