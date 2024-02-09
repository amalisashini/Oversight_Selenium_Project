package com.oversight.actiondriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {

    //Added all user actions abstract methods to achieve Abstraction
    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
    public void click(WebDriver ldriver, WebElement ele);
    public boolean isDisplayed(WebDriver ldriver, WebElement ele);
    public boolean type(WebElement ele, String text);
    public void selectDrop(WebDriver ldriver, WebElement ele);
    public void selectTimeSlot(WebDriver ldriver, WebElement ele);
    public boolean findElement(WebDriver ldriver, WebElement ele);
    public boolean JSClick(WebDriver driver, WebElement ele);
    public void implicitWait(WebDriver driver, int timeOut);
    public void pageLoadTimeOut(WebDriver driver, int timeOut);


}


