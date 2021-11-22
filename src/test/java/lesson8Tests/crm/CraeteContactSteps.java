package lesson8Tests.crm;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.crm.CrmContactCreatePage;
import lesson8.crm.CrmContactPage;
import lesson8.crm.CrmLoginPage;


public class CraeteContactSteps {

    static final String LOGIN = "Applanatest1";
    static final String PASSWORD = "Student2020!";
    static final String TEST_2_CHECK_MESSAGE = "Контактное лицо сохранено";

    @Given("^I am autorized$")
    public void iAmAutorized() {
        new CrmLoginPage()
                .openPage()
                .typeLogin(LOGIN)
                .typePassword(PASSWORD)
                .submitLogin();

    }

    @Given("^I am going to contact creation page$")
    public void iAmGoingToContactCreationPage() {
        new CrmContactPage()
                .openPage()
                .createNewContact();
    }

    @When("fill lastname {string}")
    public void fillLastname(String lastName) {
        new CrmContactCreatePage().typeLastName(lastName);
    }

    @And("fill name {string}")
    public void fillName(String name) {
        new CrmContactCreatePage().typeFirstName(name);
    }

    @And("^chose organization$")
    public void choseOrganization() {
        new CrmContactCreatePage().choseOrganization();
    }

    @And("fill jobtitle {string}")
    public void fillJobtitle(String jobTitile) {
        new CrmContactCreatePage().typeJobTitle(jobTitile);
    }

    @And("^select contact status$")
    public void selectContactStatus() {
        new CrmContactCreatePage().selectContactStatus("Активный");
    }

    @And("^click success create$")
    public void clickSuccessCreate() {
        new CrmContactCreatePage().successCreate();
    }

    @Then("^I see check message$")
    public void iSeeCheckMessage() {
       new CrmContactCreatePage().checkout().shouldHave(Condition.text(TEST_2_CHECK_MESSAGE));
    }

}
