package SeleniumTest;

import com.subbu.test.Pages.BrokenLink;
import com.subbu.test.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenLinkText {

    @Test
    public void testBrokenLinks() {
        HomePage home = new HomePage();
        home.acceptcookie();
        home.GotoBrokenLinks();
        BrokenLink page = new BrokenLink();
        Assert.assertFalse(page.verifylinks(),"One of the Links is Broken");
    }

}
