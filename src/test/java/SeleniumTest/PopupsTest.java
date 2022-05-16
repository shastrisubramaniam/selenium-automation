package SeleniumTest;

import com.subbu.test.Pages.Popups;
import org.junit.Assert;
import org.testng.annotations.Test;

public class PopupsTest extends BaseTest {
    @Test
    public void verifyPopups() {
        //HomePage home = new HomePage(getDriver());
        //home.acceptcookie();
        //home.GotoPopups();
        Popups page = openhomepage().acceptcookie().GotoPopups();
        //Popups page = new Popups();
        Assert.assertTrue("One of the buttons is not diplayed",page.verifyPage());
        Assert.assertTrue("Alert functionality is not as expected",page.alertpopup());
        Assert.assertTrue("Confirm Popup is not as expected when clicked on OK",page.confirmpopup("OK"));
        Assert.assertTrue("Confirm Popup is not as expected when clicked on Cancel",page.confirmpopup("Cancel"));
        Assert.assertTrue("Prompt Popup is not as expected",page.promptpopup("Subbu"));
    }
}
