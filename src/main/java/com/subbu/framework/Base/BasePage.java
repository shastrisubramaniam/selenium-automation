package com.subbu.framework.Base;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    public static BasePage CurrentPage;
    public static int waitTimeout;
    public static FluentWait wait;
    static String parentWindowHandle;
    static String localWindowHandle;
    public static <T extends BasePage> T getInstance (Class<T> pageInstance) {
        Object obj = PageFactory.initElements(DriverContext.Driver,pageInstance);
        return pageInstance.cast(obj);
        //wait = new FluentWait(DriverContext.Driver);
        //wait.until(page.ready());
        //return page;
    }
    public ExpectedCondition<?> ready(){
        // set parent and local Window Handles then switch to local handle
        parentWindowHandle = DriverContext.Driver.getWindowHandle();
        List<String> handlesList = new ArrayList<>(DriverContext.Driver.getWindowHandles());
        localWindowHandle = handlesList.get(handlesList.size() - 1);
        DriverContext.Driver.switchTo().window(localWindowHandle);

        // this is the default case with no wait so return null
        return null;
    }
    public <TPage extends BasePage> TPage As(Class<TPage> pageInstance)
    {
        try
        {
            return (TPage)this;
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }

        return null;
    }
}

