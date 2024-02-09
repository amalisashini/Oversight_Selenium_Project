package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    Action action = new Action();
    public LoginPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name='username']")
    WebElement usernameTextField;

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath="//div[@class='justify-content-center align-items-center g-2 row']")
    WebElement loginButton;

    @FindBy(xpath="//a[contains(text(),\"Forgot password\")]")
    WebElement forgotPasswordLink;

    @FindBy(xpath="//a[contains(text(),\"Register\")]")
    WebElement registerLink;

    @FindBy(xpath="//div[contains(text(),'Bad credentials')]")
    WebElement unSuccessToastMessage;

    @FindBy(xpath="//span[contains(text(),'Username or Email is required')]")
    WebElement usernameValidation;

    @FindBy(xpath="//span[contains(text(),'Password is required')]")
    WebElement passwordValidation;

    public DashboardPage successLogin(String uName, String password){

        action.type(usernameTextField, uName);
        action.type(passwordField, password);
        action.click(driver, loginButton);
        return new DashboardPage();
    }

    public LoginPage UnSuccessLogin(String uName, String password){

        action.type(usernameTextField, uName);
        action.type(passwordField, password);
        action.click(driver, loginButton);
        return new LoginPage();
    }

    public boolean UnSuccessToast(){

        return action.isDisplayed(driver, unSuccessToastMessage);

    }

    public boolean emailValidation(){

        return action.isDisplayed(driver, usernameValidation);

    }

    public boolean passwordValidation(){

        return action.isDisplayed(driver, passwordValidation);

    }

    public RegisterPage createNewAccount(){

        action.JSClick(driver, registerLink);
        return new RegisterPage();
    }

    public ForgotPasswordPage ForgotPassword(){

        action.click(driver, forgotPasswordLink);
        return new ForgotPasswordPage();
    }

}




