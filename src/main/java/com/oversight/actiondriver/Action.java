package com.oversight.actiondriver;

import java.util.concurrent.TimeUnit;


import com.oversight.base.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


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

    public void clearTextField(WebDriver driver, By locator) {
        WebElement textField = driver.findElement(locator);
        textField.clear();
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

        int attempts = 0;
        int maxRetries = 5;

        while (attempts < maxRetries) {
            try {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", ele);

                break;

            } catch (StaleElementReferenceException e) {
                attempts++;

            }
        }
        return false;
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

