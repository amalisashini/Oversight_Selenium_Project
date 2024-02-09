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

    public DevicePage addSubSpace(String spaceName){

        action.type(spaceNameField, spaceName);
        action.click(driver, confirmBtn);
        return new DevicePage();

    }

    public AddSpacePage addExistingSubSpace(String spaceName){

        action.type(spaceNameField, spaceName);
        action.click(driver, confirmBtn);
        return new AddSpacePage();

    }

}
