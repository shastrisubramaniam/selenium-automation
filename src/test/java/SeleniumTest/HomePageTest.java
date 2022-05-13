package SeleniumTest;

import com.subbu.framework.Base.BasePage;
import com.subbu.framework.Base.DriverContext;
import com.subbu.test.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BasePage {
    @Test
    public void HomePage() {
        HomePage home = new HomePage();
        for (WebElement webElement :home.getWebElementsOnPage()) {
            Assert.assertTrue(webElement.isDisplayed(),"One of the Elements is not displayed correctly");
        }
        DriverContext.Driver.quit();
    }
    @Test
    public void formfields() {
        HomePage home = new HomePage();
        home.GotoFormfields();
        Assert.assertEquals("Form Fields",DriverContext.Driver.findElement(By.xpath("//h1")).getText());
    }
}
