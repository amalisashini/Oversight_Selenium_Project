package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBillingSpaceModelPage extends BaseClass {

    Action action = new Action();
    public AddBillingSpaceModelPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//div[@class='d-block']//input[@name='spaceClusterLabel']")
    WebElement billingSpaceNameField;

    @FindBy(xpath="//div[@id='billing-account-number']")
    WebElement billingAccNumberDropDown;

    @FindBy(xpath="//button[@id='add-space-confirm']")
    WebElement confirmBtn;

    @FindBy(xpath="//div[contains(text(),'Space name Already Exists')]")
    WebElement addBillingSpaceUnSuccessToast;

    @FindBy(xpath="//span[normalize-space()='Space name is required']")
    WebElement spaceNameValidation;

    @FindBy(xpath="//span[normalize-space()='Space name is required']")
    WebElement accountNumberValidation;

    public DevicePage addNewBillingSpace(String billingSpaceName) throws InterruptedException {

        action.type(billingSpaceNameField, billingSpaceName);
        action.selectDrop(driver, billingAccNumberDropDown);
        action.JSClick(driver, confirmBtn);
        return new DevicePage();

    }

    public AddBillingSpaceModelPage UnSuccessAddNewBillingSpace(String billingSpaceName){

        action.type(billingSpaceNameField, billingSpaceName);
        action.selectDrop(driver, billingAccNumberDropDown);
        action.JSClick(driver, confirmBtn);
        return new AddBillingSpaceModelPage();

    }

    public boolean addBillingSpaceUnSuccessToast(){
        return action.isDisplayed(driver, addBillingSpaceUnSuccessToast);

    }

    public boolean spaceNameValidation(){
        return action.isDisplayed(driver, spaceNameValidation);

    }

    public boolean accountNumberValidation(){
        return action.isDisplayed(driver, accountNumberValidation);

    }

}

