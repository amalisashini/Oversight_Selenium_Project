package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseClass {

    Action action = new Action();
    public DashboardPage() {

        PageFactory.initElements(driver,this);

    }
    @FindBy(css="div[class='side-bar_side-bar__Rb7T7 h-100 w-100 m-0 container'] img[alt='Oversight Logo']")
    WebElement ovsLogo;

    @FindBy(xpath="//div[contains(@class,'side-bar_side-bar__Rb7T7 h-100 w-100 m-0 container')]//span[contains(@class,'ms-2')][normalize-space()='Devices']")
    WebElement deviceNavBtn;

    @FindBy(xpath="//div[contains(@class,'side-bar_side-bar__Rb7T7 h-100 w-100 m-0 container')]//span[contains(@class,'ms-2')][normalize-space()='Schedule']")
    WebElement scheduleNavBtn;

    @FindBy(xpath="//div[contains(@class,'side-bar_side-bar__Rb7T7 h-100 w-100 m-0 container')]//span[contains(@class,'ms-2')][normalize-space()='Controllers']")
    WebElement controllerNavBtn;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)")
    WebElement ProfileIcon;

    public boolean validateLogo()
    {
        return action.isDisplayed(driver,ovsLogo);
    }


    public ProfilePage navigateProfilePage(){
        action.JSClick(driver, ProfileIcon);
        return new ProfilePage();
    }


    public DevicePage navigateDevicePage(){
        action.click(driver, deviceNavBtn);
        return new DevicePage();
    }

    public SchedulePage navigateSchedulePage(){
        action.click(driver, scheduleNavBtn);
        return new SchedulePage();
    }

    public ControllersPage navigateControllerPage(){
        action.click(driver, controllerNavBtn);
        return new ControllersPage();
    }



}

