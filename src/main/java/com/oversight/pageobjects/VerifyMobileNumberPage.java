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

    @FindBy(xpath="//div[contains(text(),'User Registration Successfully')]")
    WebElement verifyMobileHeaderText;

    @FindBy(xpath="//div[@class='text-decoration-underline cursor-pointer text-center col']")
    WebElement cancelAccountCreation;

    @FindBy(xpath="//div[contains(text(),'Yes')]")
    WebElement yesBtn;

    public Boolean verifyHeaderText(){

        return action.isDisplayed(driver, verifyMobileHeaderText);

    }

    public LoginPage cancelAccount(){

        action.JSClick(driver, cancelAccountCreation);
        action.JSClick(driver, yesBtn);
        return new LoginPage();

    }

}

