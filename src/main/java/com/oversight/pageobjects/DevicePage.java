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

    @FindBy(css="div[id='space-dropdown-id-65bdd4f1fbe1d57f531e5a5e-65d1f9024384c42837859a01'] span[class='cursor-pointer material-symbols-outlined']")
    WebElement selectSubSpaceDropDown;

    @FindBy(xpath="//div[@class='app-drop-down_menu-container__PQYVS app-drop-down_show-menu__7WhUf app-drop-down_menu-top__nI8Au app-drop-down_menu-left__paQ1+']//div[@class='d-flex align-items-center'][normalize-space()='Edit Space']")
    WebElement selectSubSpaceDropDownUpdateSubSpace;

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

    public AddBillingSpaceModelPage addBillingSpace(){

        action.JSClick(driver, createBillingSpaceBtn);
        return new AddBillingSpaceModelPage();

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

    public UpdateBillingSpaceModelPage UpdateBillingSpace(){

        action.JSClick(driver, selectSpaceDropDown);
        action.JSClick(driver, selectSpaceDropDownEdit);
        return new UpdateBillingSpaceModelPage();

    }

    public UpdateSubSpaceModelPage selectUpdateSubSpace(){

        action.JSClick(driver, selectSubSpaceDropDown);
        action.JSClick(driver, selectSubSpaceDropDownUpdateSubSpace);
        return new UpdateSubSpaceModelPage();

    }

}


