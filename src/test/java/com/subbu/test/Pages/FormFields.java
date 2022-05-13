package com.subbu.test.Pages;

import com.subbu.framework.Base.DriverContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormFields {
    @FindBy(how= How.XPATH,using = "//input[@name=\"g1103-inputfield\"]")
    public WebElement inputfield;
    @FindBy(how=How.XPATH,using ="//div[@class=\"grunion-field-wrap grunion-field-checkbox-multiple-wrap\"]//child::label//child::input")
    public List<WebElement> checkboxes;
    @FindBy(how=How.XPATH,using="//div[@class=\"grunion-field-wrap grunion-field-radio-wrap\"]//child::label//child::input")
    public List<WebElement> radiobuttons;
    @FindBy(how=How.XPATH,using="//select[@name=\"g1103-dropdownmenu\"]//child::option")
    public List<WebElement> dropdown;
    @FindBy(how=How.ID_OR_NAME,using ="email")
    public WebElement email;
    @FindBy(how=How.XPATH,using="//div/textarea[@name=\"message\"]")
    public WebElement message;
    @FindBy(how=How.CLASS_NAME,using="pushbutton-wide")
    public WebElement submit;
    @FindBy(how=How.XPATH,using="//div/div/blockquote//child::p")
    public List<WebElement> formfieldsresult;
    public FormFields()
    {
        //DriverContext.Driver = DriverContext.getDriver("chrome");
        PageFactory.initElements(DriverContext.Driver,this);
    }
    public boolean checkformfields() {
        if (inputfield.isDisplayed() && checkboxes.size() >0 && radiobuttons.size() >0 && dropdown.size() >0
        && email.isDisplayed() && submit.isDisplayed())
            return true;
        else
            return false;
    }
    public List<WebElement> submitform(String[] expectedvalues) {
        inputfield.sendKeys(expectedvalues[0]);
        for (WebElement checkbox : checkboxes) {
            //System.out.println(checkbox.getAttribute("value"));
            if (checkbox.getAttribute("value").equals(expectedvalues[1])) {
                JavascriptExecutor js = (JavascriptExecutor)DriverContext.Driver;
                js.executeScript("arguments[0].click()", checkbox);
                js.executeScript("window.scrollBy(0,100)");
            }
        }
        for (WebElement radiobutton : radiobuttons) {
            if (radiobutton.getAttribute("value").equals(expectedvalues[2])) {
                JavascriptExecutor js = (JavascriptExecutor)DriverContext.Driver;
                js.executeScript("arguments[0].click()", radiobutton);
                js.executeScript("window.scrollBy(0,350)");
            }
        }
        for(WebElement dropdownvalue : dropdown) {
            if (dropdownvalue.getAttribute("value").equals(expectedvalues[3]))
                dropdownvalue.click();
        }
        email.sendKeys(expectedvalues[4]);
        message.sendKeys(expectedvalues[5]);
        JavascriptExecutor js = (JavascriptExecutor)DriverContext.Driver;
        js.executeScript("arguments[0].click()", submit);
        return formfieldsresult;
    }
}
