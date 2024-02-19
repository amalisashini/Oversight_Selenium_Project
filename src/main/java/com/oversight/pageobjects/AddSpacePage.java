package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSpacePage extends BaseClass {

    Action action = new Action();
    public AddSpacePage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(css="div[class='d-block'] input[placeholder='Space Name']")
    WebElement spaceNameField;

    @FindBy(css="div[class='d-block'] div[class='col-auto'] div[class='col-auto col']")
    WebElement confirmBtn;

    @FindBy(xpath="//div[contains(text(),'Space name Already Exists')]")
    WebElement addSubSpaceUnSuccessToast;

    @FindBy(xpath="//span[normalize-space()='Space name is required']")
    WebElement subSpaceValidation;

    public DevicePage addSubSpace(String spaceName){

        action.type(spaceNameField, spaceName);
        action.click(driver, confirmBtn);
        return new DevicePage();

    }

    public AddSpacePage addSubSpaceUnSuccess(String spaceName){

        action.type(spaceNameField, spaceName);
        action.click(driver, confirmBtn);
        return new AddSpacePage();

    }

    public boolean addSubSpaceUnSuccessToast(){
        return action.isDisplayed(driver, addSubSpaceUnSuccessToast);

    }

    public boolean addSubSpaceValidation(){
        return action.isDisplayed(driver, subSpaceValidation);

    }

}
