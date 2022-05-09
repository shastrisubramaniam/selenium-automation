package com.subbu.test.Pages;

import com.subbu.framework.Base.BasePage;
import com.subbu.framework.Base.DriverContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage
{
    @FindBy(how= How.XPATH,using = "//div/input[@type=\"email\"]")
    public WebElement emailid;
    @FindBy(how = How.XPATH,using = "//*[@id=\"identifierNext\"]/div/button/span")
    public WebElement nextbtn;
    private final String expectedtitle = "Gmail";
    private final String titleresultdesc = "Title verification step was successful";
    static final String inputFile = "C:\\Users\\Subramaniam\\IdeaProjects\\Automation\\Automation_TestData.xlsx";
    static String emailaddress;
    static final Logger logger = LogManager.getLogger("pages.SeleniumTest.LoginTest.class");

    public LoginPage()
    {
        DriverContext.Driver = DriverContext.getDriver("chrome");
        PageFactory.initElements(DriverContext.Driver,this);
    }
    public void Login(String data)
        {
        //ExcelUtil data = new ExcelUtil();
        emailid.sendKeys(data);
        nextbtn.click();
        }

    public boolean isLogin()
    {
        WebDriverWait wait = new WebDriverWait(DriverContext.Driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(emailid));
        return emailid.isDisplayed();
    }
    public void closeapp()
    {
        DriverContext.Driver.close();
        DriverContext.Driver.quit();
    }
}
