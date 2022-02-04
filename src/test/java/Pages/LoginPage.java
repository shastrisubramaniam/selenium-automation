package Pages;
import com.subbu.framework.Base.BasePage;
import com.subbu.framework.Base.DriverContext;
import com.subbu.framework.utilities.DatabaseUtil;
import com.subbu.framework.utilities.ExcelUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Connection;

public class LoginPage extends BasePage
{
    private final String chromedriverpath = "C:\\Users\\Subramaniam\\Downloads\\chromedriver_win32\\chromedriver.exe";
    private final String url = "http://gmail.com";
    private final String expectedtitle = "Gmail";
    private final String titleresultdesc = "Title verification step was successful";
    static final String inputFile = "C:\\Users\\Subramaniam\\IdeaProjects\\Automation\\Automation_TestData.xlsx";
    static String emailaddress;
    static final Logger logger = LogManager.getLogger("pages.SeleniumTest.LoginTest.class");
 public LoginPage()
 {
     super();
     System.setProperty("webdriver.chrome.driver",chromedriverpath);
     DriverContext.Driver = new ChromeDriver();
     DriverContext.Driver.navigate().to(url);
     emailid = DriverContext.Driver.findElement(By.id("identifierId"));
     nextbtn = DriverContext.Driver.findElement(By.cssSelector("#identifierNext > span > span"));
 }

 public void Login(String data)
    {
        //ExcelUtil data = new ExcelUtil();
            emailid.sendKeys(data);
            nextbtn.click();
           }
    public boolean isLogin()
    {
        WebDriverWait wait = new WebDriverWait(DriverContext.Driver, 120);
        wait.until(ExpectedConditions.visibilityOf(emailid));
        return emailid.isDisplayed();
    }
    public void closeapp()
    {
        DriverContext.Driver.close();
        DriverContext.Driver.quit();
    }

    @FindBy(how= How.ID,using = "emailid")
    public WebElement emailid;

    @FindBy(how = How.CSS,using = "#identifierNext > span > span")
    public WebElement nextbtn;
}
