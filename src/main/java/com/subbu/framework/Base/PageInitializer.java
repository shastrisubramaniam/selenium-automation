package com.subbu.framework.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;

public interface PageInitializer {

    default <T extends BasePage> T newInstance (Class<T> pageClass) {
        try {
            T page = pageClass.getConstructor(WebDriver.class).newInstance(getDriver());
            PageFactory.initElements(getDriver(),page);
            return page;
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error while creating new page instance",e);
        }

    }
    WebDriver getDriver();
}

