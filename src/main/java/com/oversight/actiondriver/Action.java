package com.oversight.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import com.oversight.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


public class Action extends BaseClass implements ActionInterface {

    @Override
    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }
    @Override
    public void selectDrop(WebDriver driver, WebElement ele){

        Actions a = new Actions(driver);

        if (ele.isDisplayed() && ele.isEnabled()) {
            ele.click();
        }

        a.sendKeys(Keys.DOWN).perform();
        a.sendKeys(Keys.ENTER).perform();

    }

    @Override
    public void selectTimeSlot(WebDriver driver, WebElement ele){

        Actions a = new Actions(driver);

        if (ele.isDisplayed() && ele.isEnabled()) {
            ele.click();
        }

    }

    @Override
    public void click(WebDriver driver, WebElement ele) {

        Actions act = new Actions(driver);
        act.moveToElement(ele).click().build().perform();

    }

    @Override
    public boolean findElement(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();
            flag = true;
        } catch (Exception e) {
            // System.out.println("Location not found: "+locatorName);
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully Found element");

            } else {
                System.out.println("Unable to locate element");
            }
        }
        return flag;
    }

    @Override
    public boolean isDisplayed(WebDriver driver, WebElement ele) {
        boolean flag = false;
        flag = findElement(driver, ele);
        if (flag) {
            flag = ele.isDisplayed();
            if (flag) {
                System.out.println("The element is Displayed");
            } else {
                System.out.println("The element is not Displayed");
            }
        } else {
            System.out.println("Not displayed ");
        }
        return flag;
    }



    /**
     * Type text at location
     *
     * @param
     * @param text
     * @return - true/false
     */
    @Override
    public boolean type(WebElement ele, String text) {
        boolean flag = false;
        try {
            flag = ele.isDisplayed();
            ele.clear();
            ele.sendKeys(text);
            // logger.info("Entered text :"+text);
            flag = true;
        } catch (Exception e) {
            System.out.println("Location Not found");
            flag = false;
        } finally {
            if (flag) {
                System.out.println("Successfully entered value");
            } else {
                System.out.println("Unable to enter value");
            }

        }
        return flag;
    }



    @Override
    public boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            // WebElement element = driver.findElement(locator);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            // driver.executeAsyncScript("arguments[0].click();", element);

            flag = true;

        }

        catch (Exception e) {
            throw e;

        } finally {
            if (flag) {
                System.out.println("Click Action is performed");
            } else if (!flag) {
                System.out.println("Click Action is not performed");
            }
        }
        return flag;
    }

    @Override
    public void implicitWait(WebDriver driver, int timeOut) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Override
    public void pageLoadTimeOut(WebDriver driver, int timeOut) {
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
    }


}

