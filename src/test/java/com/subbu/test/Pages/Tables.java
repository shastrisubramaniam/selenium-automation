package com.subbu.test.Pages;

import com.subbu.framework.Base.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tables {
    @FindBy(how= How.XPATH,using="//figure/table/tbody/tr/td")
    public List<WebElement> itemprices;
    @FindBy(how=How.XPATH,using="//table[@id=\"tablepress-1\"]/tbody/tr/td")
    public List<WebElement> countriesbypopulation;
    Map<String,String> items = new HashMap<>();
    Map<String,String> countries = new HashMap<>();
    public Tables() {
        PageFactory.initElements(DriverContext.Driver,this);
    }
    public Map<String,String> getItems() {
        for (int i=2;i < itemprices.size()-1;i+=2)
            items.put(itemprices.get(i).getText(),itemprices.get(i+1).getText());
        return items;
    }
    public Map<String,String> getCountriesByPopulation() {
        for (int i=1;i < countriesbypopulation.size()-1;i+=3)
            countries.put(countriesbypopulation.get(i).getText(),countriesbypopulation.get(i+1).getText());
        return countries;
    }
}
