package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveAccountNumberModelPage extends BaseClass {

    Action action = new Action();
    public RemoveAccountNumberModelPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//button[contains(@class,'undefined undefined app-button_app-button__xBnO8 app-button_app-button-red__OarAA app-button_app-button-medium__WWpFr false')]")
    WebElement deleteBillNumberBtn;

    public ProfilePage removeBillingAccNumber(){

        action.JSClick(driver, deleteBillNumberBtn);
        return new ProfilePage();

    }

}
