package SeleniumTest;

import com.subbu.framework.Base.DriverContext;
import com.subbu.test.Pages.HomePage;
import com.subbu.test.Pages.Tables;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TablesTest {
    @Test
    public void verifyTables() {
        HomePage home = new HomePage();
        home.acceptcookie();
        home.Gototables();
        Tables page = new Tables();
        System.out.println(page.getItems().entrySet());
        JavascriptExecutor js = (JavascriptExecutor)(DriverContext.Driver);
        js.executeScript("window.scrollBy(0,700)");
        System.out.println(page.getCountriesByPopulation().entrySet());
    }
}
