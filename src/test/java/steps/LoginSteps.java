package steps;

import com.subbu.framework.Base.DriverContext;
import com.subbu.test.Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class LoginSteps {
    private final String expectedtitle = "Gmail";
    private final String titleresultdesc = "Title verification step was successful";
    private LoginPage loginPage;
    AutomationApi api;
    public LoginSteps() {}
    public LoginSteps(AutomationApi api,LoginPage loginPage) {
        this.api = api;
        this.loginPage = loginPage;
    }
    @io.cucumber.java.en.Given("^I have navigated to the application$")
        public void iHaveNavigatedToTheApplication() {
        loginPage = new LoginPage();
        Assert.assertTrue("Login Page is loaded", loginPage.isLogin());
    }
    @io.cucumber.java.en.When("^I enter emailid and click on Next button$")
    public void iEnterEmailaddressAndClickOnNextButton(DataTable data) {
        List<List<String>> table = data.asLists();
        loginPage.Login(table.get(1).get(0));
    }

    @io.cucumber.java.en.Then("^Check that the Page Title is what you expect$")
        @Then("Check that the Page Title is what you expect and close the App")
    public void checkThatThePageTitleIsWhatYouExpectAndCloseTheApp() {
        //LoginPage page = new LoginPage();
        Assert.assertEquals(titleresultdesc, expectedtitle, DriverContext.Driver.getTitle());
        loginPage.closeapp();
    }

}
