import Pages.LoginPage;
import SeleniumTest.LoginTest;
import com.subbu.framework.Base.Base;
import com.subbu.framework.Base.DriverContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages;
import org.junit.Assert;

import java.util.List;

public class LoginSteps extends Base {
    private final String expectedtitle = "Gmail";
    private final String titleresultdesc = "Title verification step was successful";
    @io.cucumber.java.en.Given("^I have navigated to the application$")
        public void iHaveNavigatedToTheApplication() {
        CurrentPage = GetInstance(LoginPage.class);
        Assert.assertTrue("Login Page is loaded", CurrentPage.As(LoginPage.class).isLogin());

    }
    @io.cucumber.java.en.When("^I enter emailaddress and click on Next button$")
    public void iEnterEmailaddressAndClickOnNextButton(DataTable data) {
        List<List<String>> table = data.asLists();
        CurrentPage.As(LoginPage.class).Login(table.get(1).get(0).toString());
    }

    @io.cucumber.java.en.Then("^Check that the Page Title is what you expect$")
        @Then("Check that the Page Title is what you expect and close the App")
    public void checkThatThePageTitleIsWhatYouExpectAndCloseTheApp() {
        LoginPage page = new LoginPage();
        Assert.assertEquals(titleresultdesc, expectedtitle, DriverContext.Driver.getTitle().toString());
    }

    @When("I enter emailid and click on Next button")
    public void iEnterEmailidAndClickOnNextButton() {
    }
}
