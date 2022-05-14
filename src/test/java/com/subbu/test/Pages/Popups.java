package com.subbu.test.Pages;

import com.subbu.framework.Base.DriverContext;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Popups {
    @FindBy(how= How.CSS,using="#alert")
    public WebElement alertbutton;
    @FindBy(how=How.CSS,using="#confirm")
    public WebElement confirmbutton;
    @FindBy(how=How.CSS,using="#prompt")
    public WebElement promptbutton;
    @FindBy(how=How.CSS,using="#confirmResult")
    public WebElement confirmresult;
    @FindBy(how=How.CSS,using="#promptResult")
    public WebElement promptresult;
    public Popups() {
        PageFactory.initElements(DriverContext.Driver,this);
    }
    public boolean alertpopup() {
        alertbutton.click();
        Alert alertwindow = DriverContext.Driver.switchTo().alert();
        alertwindow.accept();
        return true;
    }
    public boolean confirmpopup(String input) {
        confirmbutton.click();
        Alert confirmwindow = DriverContext.Driver.switchTo().alert();
        if (input.equals("OK")) confirmwindow.accept();
        else confirmwindow.dismiss();
        return confirmresult.getText().contains(input);
    }
    public boolean promptpopup(String input) {
        promptbutton.click();
        Alert promptwindow = DriverContext.Driver.switchTo().alert();
        promptwindow.sendKeys(input);
        promptwindow.accept();
        System.out.println(promptresult.getText());
        return promptresult.getText().contains(input);
    }
    public boolean verifyPage() {
        return alertbutton.isDisplayed() && confirmbutton.isDisplayed() && promptbutton.isDisplayed();
    }
}
