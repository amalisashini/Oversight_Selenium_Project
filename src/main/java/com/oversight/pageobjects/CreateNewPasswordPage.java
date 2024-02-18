package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPasswordPage extends BaseClass {

    Action action = new Action();
    public CreateNewPasswordPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath="//input[@name='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(xpath="//button[@type='submit']")
    WebElement confirmBtn;

    @FindBy(xpath="//span[contains(text(),'Password is required')]")
    WebElement passwordValidation;

    @FindBy(xpath="//span[contains(text(),'Password confirmation is required')]")
    WebElement confirmPasswordValidation;

    public ProfilePage editPassword(String passField, String conPassField){

        action.type(passwordField, passField);
        action.type(confirmPasswordField, conPassField);
        action.JSClick(driver, confirmBtn);
        return new ProfilePage();

    }

    public CreateNewPasswordPage ValidationTest(String passField, String conPassField){

        action.type(passwordField, passField);
        action.type(confirmPasswordField, conPassField);
        action.JSClick(driver, confirmBtn);
        return new CreateNewPasswordPage();

    }

    public boolean passwordValidation(){

        return action.isDisplayed(driver, passwordValidation);

    }

    public boolean conPasswordValidation(){

        return action.isDisplayed(driver, confirmPasswordValidation);

    }

}
