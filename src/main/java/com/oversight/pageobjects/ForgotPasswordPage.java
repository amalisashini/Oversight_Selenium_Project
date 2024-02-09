package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BaseClass {

    Action action = new Action();
    public ForgotPasswordPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name=\"phoneNumber\"]")
    WebElement forMobileNumber;

    @FindBy(xpath="//button[@type=\"submit\"]")
    WebElement sendOTPBtn;

    public VerifyMobileNumberPage sendOTP(String mobile){

        action.type(forMobileNumber, mobile);
        action.click(driver, sendOTPBtn);
        return new VerifyMobileNumberPage();

    }

}
