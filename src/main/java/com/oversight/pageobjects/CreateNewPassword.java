package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPassword extends BaseClass {

    Action action = new Action();
    public CreateNewPassword() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name=\"password\"]")
    WebElement password;

    @FindBy(xpath="//input[@name=\"confirmPassword\"]")
    WebElement confirmPassword;

    @FindBy(xpath="//button[@type=\"submit\"]")
    WebElement confirmBtn;

    public ProfilePage createNewPwd(String psw, String conPsw){

        action.type(password, psw);
        action.type(confirmPassword, conPsw);
        action.click(driver, confirmBtn);
        return new ProfilePage();

    }

}

