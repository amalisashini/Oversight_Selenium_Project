package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailChangePage extends BaseClass {

    Action action = new Action();
    public EmailChangePage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name='email']")
    WebElement emailField;

    @FindBy(xpath="//button[@type='submit']")
    WebElement confirmBtn;

    @FindBy(xpath="//div[@class='error justify-content-center font-size-14 mt-2 text-center col']")
    WebElement existEmailValidation;

    public ProfilePage changeEmail(String emailFld){

       action.type(emailField, emailFld);
       action.JSClick(driver, confirmBtn);
       return new ProfilePage();

    }

    public EmailChangePage emailChangeWithExistingEmail(String emailFld){

        action.type(emailField, emailFld);
        action.JSClick(driver, confirmBtn);
        return new EmailChangePage();

    }

    public boolean changeWithExistEmailValidation(){

        return action.isDisplayed(driver, existEmailValidation);

    }

}
