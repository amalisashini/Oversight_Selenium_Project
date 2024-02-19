package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevicePage extends BaseClass {

    Action action = new Action();
    public DevicePage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(css="span[class='me-2 material-symbols-outlined']")
    WebElement createBillingSpaceBtn;

    @FindBy(xpath="//div[@class='app-drop-down_drop-down-icon__2ktVW false']//span[@icon='more_vert']")
    WebElement selectSpaceDropDown;

    @FindBy(xpath="//div[contains(@class, 'app-drop-down_menu-container') and contains(@style, 'visibility: visible')]//li[contains(., 'Edit Space')]")
    WebElement selectSpaceDropDownEdit;

    @FindBy(xpath="//div[contains(@class, 'app-drop-down_menu-container') and contains(@style, 'visibility: visible')]//li[contains(., 'Add Subspace')]")
    WebElement selectSpaceDropDownAddSubSpace;

    @FindBy(xpath="//div[contains(text(),'Add Device')]")
    WebElement addDeviceBtn;

    @FindBy(xpath="//div[contains(text(),'Billing Space Added Successfully')]")
    WebElement addBillingSpaceSuccessToast;

    @FindBy(xpath="//div[contains(text(),'Billing Space Updated Successfully')]")
    WebElement updateBillingSpaceSuccessToast;

    @FindBy(xpath="//div[contains(text(),'Space Added Successfully')]")
    WebElement addSubSpaceSuccessToast;

    @FindBy(xpath="//div[contains(text(),'Device Added Successfully')]")
    WebElement addDeviceSuccessToast;

    public AddNewSpaceModelPage addBillingSpace(){

        action.JSClick(driver, createBillingSpaceBtn);
        return new AddNewSpaceModelPage();

    }

    public boolean addBillingSpaceSuccessToast(){
        return action.isDisplayed(driver, addBillingSpaceSuccessToast);

    }

    public boolean updateBillingSpaceSuccessToast(){
        return action.isDisplayed(driver, updateBillingSpaceSuccessToast);

    }

    public boolean addSubSpaceSuccessToast(){
        return action.isDisplayed(driver, addSubSpaceSuccessToast);

    }

    public boolean addDeviceSuccessToast(){
        return action.isDisplayed(driver, addDeviceSuccessToast);

    }

    public AddDevicePage addNewDevice(){

        action.click(driver, addDeviceBtn);
        return new AddDevicePage();

    }

    public AddSpacePage selectAddSpace(){

        action.JSClick(driver, selectSpaceDropDown);
        action.JSClick(driver, selectSpaceDropDownAddSubSpace);
        return new AddSpacePage();

    }

    public UpdateSpaceModelPage UpdateBillingSpace(){

        action.JSClick(driver, selectSpaceDropDown);
        action.JSClick(driver, selectSpaceDropDownEdit);
        return new UpdateSpaceModelPage();

    }

}


