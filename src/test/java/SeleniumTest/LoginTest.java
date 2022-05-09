package SeleniumTest;
import com.subbu.framework.Base.BasePage;
import com.subbu.test.Pages.LoginPage;
import com.subbu.framework.Base.DriverContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class LoginTest extends BasePage {
private final String chromedriverpath = "C:\\Users\\Subramaniam\\Downloads\\chromedriver_win32\\chromedriver.exe";
private final String url = "http://gmail.com";
private final String expectedtitle = "Gmail";
private final String titleresultdesc = "Title verification step was successful";
static final String inputFile = "C:\\Users\\Subramaniam\\IdeaProjects\\Automation\\Automation_TestData.xlsx";
static String emailaddress;
static final Logger logger = LogManager.getLogger("pages.SeleniumTest.LoginTest.class");
    @Before
    public void Initialize()
    {
       //System.setProperty("webdriver.chrome.driver",chromedriverpath);
       //DriverContext.Driver = new ChromeDriver();
       //DriverContext.Driver.navigate().to(url);
       //String connectstring = "jdbc:mariadb://localhost:3306/mysql?user=root&password=kali";
       //Connection conn = DatabaseUtil.Open(connectstring);
       //DatabaseUtil.ExecuteQuery("select * from user",conn);
    }
    @Test
    public void Login() {
       logger.info("Log is starting");
       LoginPage page = new LoginPage();
       //LoginPage page = getInstance(LoginPage.class);
       page.Login("bharati.shastri@gmail.com");
       Assert.assertEquals(titleresultdesc, expectedtitle, DriverContext.Driver.getTitle());
        page.closeapp();
       }
    @After
    public void TearDown()
    {
        DriverContext.Driver.quit();
    }
}
