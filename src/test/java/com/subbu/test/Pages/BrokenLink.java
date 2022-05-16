package com.subbu.test.Pages;

import com.subbu.framework.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BrokenLink extends BasePage {
    @FindBy(how= How.XPATH,using="//a[@href=\"https://automatenow.iot/\"]") public WebElement brokenlink;
    int respcode;
    public BrokenLink(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(DriverContext.Driver,this);
    }
    public boolean verifylinks(){
        //FluentWait wait = new FluentWait(brokenlink).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).until()
        //wait.until(a->!brokenlink.isDisplayed());
        HttpURLConnection http;
        try {
            http = (HttpURLConnection) (new URL(brokenlink.getAttribute("href")).openConnection());
            http.setRequestMethod("HEAD");
            respcode = http.getResponseCode();
        }
        catch (IOException e_io) {
            e_io.printStackTrace();
        }
        return (respcode >=400);
    }
}
