package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateBillingAccountNumberPage extends BaseClass {

    Action action = new Action();
    public UpdateBillingAccountNumberPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//div[@class='d-block']//input[@name='label']")
    WebElement billingLabelField;

    @FindBy(xpath="//div[@class='d-block']//input[@placeholder='Billing Account number']")
    WebElement billingAccNumField;

    @FindBy(xpath="//button[@id='billing-account-confirm']")
    WebElement confirmBtn;

    public ProfilePage updateBillingAccNumber(String billLabel, String billAccNum){

        action.clearTextField(driver, (By) billingLabelField);
        action.type(billingLabelField, billLabel);
        action.clearTextField(driver, (By) billingAccNumField);
        action.type(billingAccNumField, billAccNum);
        action.JSClick(driver, confirmBtn);
        return new ProfilePage();

    }


}
