package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddControllerPage extends BaseClass {

    Action action = new Action();
    public AddControllerPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name='name']")
    WebElement controllerName;

    @FindBy(xpath="//input[@name='serialKey']")
    WebElement controllerSerialKey;

    @FindBy(xpath="//div[contains(@class,'app-input-wrapper mt-4 font-size-14')]//div[contains(@class,'css-19bb58m')]")
    WebElement controllerType;

    @FindBy(xpath="//span[@icon=\"link\"]")
    WebElement selectDeviceIcon;

    @FindBy(xpath="//div[contains(@class,'container-white')]//button[contains(@class,'undefined undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-medium__WWpFr false')]")
    WebElement confirmBtn;

    public void AddControllerDetails(String conName, String conSerial){

        action.type(controllerName, conName);
        action.type(controllerSerialKey, conSerial);
        action.selectDrop(driver, controllerType);

    }

    public LinkControllerPage selectDevice(){

        action.click(driver, selectDeviceIcon);
        return new LinkControllerPage();

    }

    public ControllersPage AddControllerConfirm(){

        action.click(driver, confirmBtn);
        return new ControllersPage();

    }

}
