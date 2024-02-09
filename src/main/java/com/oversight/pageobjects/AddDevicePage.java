package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDevicePage extends BaseClass {

    Action action = new Action();
    public AddDevicePage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name='name']")
    WebElement deviceName;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)")
    WebElement deviceType;

    @FindBy(xpath="//input[@name='brand']")
    WebElement brand;

    @FindBy(xpath="//input[@name='modelNumber']")
    WebElement modelNumber;

    @FindBy(xpath="//input[@name='powerUsageInWatt']")
    WebElement PowerUsageInWatt;

    @FindBy(xpath="//div[@class='d-block']//div[@class='col-auto col'][normalize-space()='Confirm']")
    WebElement confirmBtn;

    public DevicePage addNewDevice(String deviceN, String brandNew, String modelNum, String powerUsage){

        action.type(deviceName, deviceN);
        action.selectDrop(driver, deviceType);
        action.type(brand, brandNew);
        action.type(modelNumber, modelNum);
        action.type(PowerUsageInWatt, powerUsage);
        action.click(driver, confirmBtn);
        return new DevicePage();

    }
}
