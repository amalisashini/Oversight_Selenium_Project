package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyMobileNumberPage extends BaseClass {

    Action action = new Action();
    public VerifyMobileNumberPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//div[contains(text(),'Verify Mobile Number')]")
    WebElement verifyMobileHeaderText;

    public Boolean verifyHeaderText(){

        return action.isDisplayed(driver, verifyMobileHeaderText);

    }

}

