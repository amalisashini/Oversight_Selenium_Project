package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ControllersPage extends BaseClass {

    Action action = new Action();
    public ControllersPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//button[@class='undefined undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-small__TRSUX false']//div[@class='col-auto col'][normalize-space()='Add Controller']")
    WebElement addControllerBtn;

    public AddControllerPage createNewController(){

        action.JSClick(driver, addControllerBtn);
        return new AddControllerPage();

    }

}

