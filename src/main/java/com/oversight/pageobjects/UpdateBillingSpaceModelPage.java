package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateBillingSpaceModelPage extends BaseClass {

    Action action = new Action();
    public UpdateBillingSpaceModelPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//div[@class='d-block']//input[@name='spaceClusterLabel']")
    WebElement billingSpaceNameField;

    @FindBy(xpath="//div[@class='d-block']//button[@class='undefined undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-medium__WWpFr false']")
    WebElement confirmBtn;

    public DevicePage updateNewBillingSpace(String billingSpaceName){

        action.clearTextField(driver, (By) billingSpaceNameField);
        action.type(billingSpaceNameField, billingSpaceName);
        action.click(driver, confirmBtn);
        return new DevicePage();

    }
}

