package com.oversight.pageobjects;

import com.github.javafaker.Faker;
import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

public class RegisterPage extends BaseClass {

    Action action = new Action();
    public RegisterPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name='firstName']")
    WebElement firstName;

    @FindBy(xpath="//input[@name='lastName']")
    WebElement lastName;

    @FindBy(xpath="//input[@name='username']")
    WebElement userName;

    @FindBy(xpath="//input[@name='NIC']")
    WebElement NIC;

    @FindBy(xpath="//input[@name='mobileNumber']")
    WebElement mobileNumber;

    @FindBy(xpath="//input[@name='email']")
    WebElement email;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    @FindBy(xpath="//input[@name='confirmPassword']")
    WebElement confirmPassword;

    @FindBy(xpath="//span[@class='check-box_checkmark__z1UzH ']")
    WebElement termsAndConditionsBtn;

    @FindBy(css=".mt-4.false.false.app-button_app-button__xBnO8.app-button_app-button-blue__MyFQW.app-button_app-button-large__uIHei.false")
    WebElement signUpButton;

    public VerifyMobileNumberPage RegisterAccount(String fName, String lName, String usName, String nic, String mobileNum, String eml, String psw, String conPsw) throws InterruptedException {

        action.type(firstName, fName);
        action.type(lastName, lName);
        action.type(userName, usName);
        action.type(NIC, nic);
        action.type(mobileNumber, mobileNum);
        action.type(email, eml);
        action.type(password, psw);
        action.type(confirmPassword, conPsw);
        action.JSClick(driver, termsAndConditionsBtn);
        action.scrollByVisibilityOfElement(driver, signUpButton);
        action.JSClick(driver, signUpButton);
        return new VerifyMobileNumberPage();
    }


}

