package SeleniumTest;

import com.subbu.framework.Base.DriverContext;
import com.subbu.framework.Base.PageInitializer;
import com.subbu.test.Pages.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest implements PageInitializer {
    private final WebDriver driver;
    public BaseTest() {
        this.driver = DriverContext.getDriver("chrome");
    }
    public WebDriver getDriver() {
        return driver;
    }
    protected HomePage openhomepage(){
        return newInstance(HomePage.class);
    }
}
