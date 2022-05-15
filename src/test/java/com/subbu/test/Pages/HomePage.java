package com.subbu.test.Pages;

import com.subbu.framework.Base.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    @FindBy(how=How.XPATH,using="//a[@href=\"https://automatenow.io/form-fields/\"]")
    public WebElement formfields;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/tables/\"]")
    public WebElement tables;
    @FindBy(how=How.XPATH,using = "//a[@href=\"https://automatenow.io/calendar/\"]")
    public WebElement calendar;
    @FindBy(how=How.XPATH,using= "//a[@href=\"https://automatenow.io/search-box/\"]")
    public WebElement searchbox;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/window-operations/\"]")
    public WebElement winoperations;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/gestures/\"]")
    public WebElement gestures;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/broken-images/\"]")
    public WebElement brokenimages;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/accordion/\"]")
    public WebElement accordion;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/ads/\"]")
    public WebElement ads;
    @FindBy(how=How.XPATH,using="//a[@href=\"https://automatenow.io/click-events/\"]")
    public WebElement clickevents;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/popups/\"]")
    public WebElement popups;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/modals/\"]")
    public WebElement modals;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/hover/\"]")
    public WebElement hover;
    @FindBy(how=How.XPATH,using="//a[@href=\"https://automatenow.io/file-download/\"]")
    public WebElement filedownload;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/file-upload/\"]")
    public WebElement fileupload;
    @FindBy(how=How.XPATH,using="//a[@href=\"https://automatenow.io/iframes/\"]")
    public WebElement iframes;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/carousel/\"]")
    public WebElement carousel;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/broken-links/\"]")
    public WebElement brokenlinks;
    @FindBy(how=How.XPATH,using ="//a[@href=\"https://automatenow.io/slider/\"]")
    public WebElement slider;
    @FindBy(how=How.XPATH,using="//a[@data-cli_action=\"accept\"]")
    public WebElement cookie;
    public HomePage(){
        DriverContext.Driver = DriverContext.getDriver("chrome");
        PageFactory.initElements(DriverContext.Driver,this);
    }
    public void GotoFormfields(){
        formfields.click();
    }
    public void Gototables() {
        tables.click();
    }
    public void Gotocalendar(){
        calendar.click();
    }
    public void GotoSearchBox() {
        searchbox.click();
    }
    public void GotoWindowOperations() {
        winoperations.click();
    }
    public void GotoGestures() {
        gestures.click();
    }
    public void GotoBrokenImages() {
        brokenimages.click();
    }
    public void GotoAccordion() {
        accordion.click();
    }
    public void GotoAds() {
        ads.click();
    }
    public void GotoClickEvents() {
        clickevents.click();
    }
    public void GotoPopups() {
        popups.click();
    }
    public void GotoModals() {
        modals.click();
    }
    public void GotoHover() {
        hover.click();
    }
    public void GotoFileDownload() {
        filedownload.click();
    }
    public void GotoFileUpload() {
        fileupload.click();
    }
    public void GotoIFrames() {
        iframes.click();
    }
    public void GotoCarousel() {
        carousel.click();
    }
    public void GotoBrokenLinks() {
        JavascriptExecutor js = (JavascriptExecutor)DriverContext.Driver;
        js.executeScript("window.scrollBy(0,350)");
        brokenlinks.click();
    }
    public void GotoSlider() {
        slider.click();
    }
    public void acceptcookie() {
        cookie.click();
    }
    public List<WebElement> getWebElementsOnPage() {
        return DriverContext.Driver.findElements(By.xpath("//a[contains(@class,\"wp-block-button__link\")]"));
    }
}
