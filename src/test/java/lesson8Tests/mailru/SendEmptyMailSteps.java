package lesson8Tests.mailru;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.mailru.MailruInboxPage;
import lesson8.mailru.MailruMainPage;

public class SendEmptyMailSteps {

    static final String LOGIN = "pustyshkin97";
    static final String PASSWORD = "zxc56nm&";
    static final String TEST_1_CHECK_MESSAGE = "Письмо отправлено";

    @Given("I am autorized in mail")
    public void iAmAutorizedInMail() {
        new MailruMainPage()
                .openPage()
                .typeLogin(LOGIN)
                .typePassword(PASSWORD)
                .login();
    }


    @Given("I am click write new mail")
    public void iAmClickWriteNewMail() {
        new MailruInboxPage().createNewMail();
    }

    @When("fill {string}")
    public void fillRecipient(String recipient) {
        new MailruInboxPage().typeAddress(recipient);
    }

    @And("click send")
    public void clickSend() {
        new MailruInboxPage().sendMail();
    }

    @Then("I see check report")
    public void iSeeCheckReport() {
        new MailruInboxPage().checkout().shouldHave(Condition.text(TEST_1_CHECK_MESSAGE));
    }

}
