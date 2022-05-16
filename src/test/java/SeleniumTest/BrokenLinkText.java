package SeleniumTest;

import com.subbu.test.Pages.BrokenLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenLinkText extends BaseTest {

    @Test(priority=1)
    public void testBrokenLinks() {
        //HomePage home = new HomePage(getDriver());
        //home.acceptcookie();
        //home.GotoBrokenLinks();
        openhomepage().acceptcookie().GotoBrokenLinks();
        BrokenLink page = new BrokenLink(getDriver());
        Assert.assertFalse(page.verifylinks(),"One of the Links is Broken");
    }

}
