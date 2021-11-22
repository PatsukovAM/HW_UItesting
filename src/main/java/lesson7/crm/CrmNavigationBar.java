package lesson7.crm;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CrmNavigationBar extends CrmBaseView {

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li/a")
    public List<WebElement> navBarItems;

        public CrmNavigationBar(WebDriver driver) {
        super(driver);
    }

    public void openNavBarItem(String itemName) {
        Actions actions= new Actions(driver);
        WebElement item= navBarItems.stream().filter(element -> element.getText().equals(itemName)).findFirst().get();
        actions.moveToElement(item).build().perform();
    }
}
