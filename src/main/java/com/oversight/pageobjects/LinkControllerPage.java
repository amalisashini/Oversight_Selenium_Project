package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkControllerPage extends BaseClass {

    Action action = new Action();
    public LinkControllerPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@placeholder=\"Search Device\"]")
    WebElement searchDeviceBox;

    @FindBy(xpath="//button[@class=\"undefined undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-medium__WWpFr app-button_appIconButton__9mhgd\"]")
    WebElement searchButton;

    @FindBy(xpath="//div[@class='link-device-card_device-card__WatMa undefined cursor-pointer p-2 align-items-center justify-content-between row']")
    WebElement linkedDevice;

    @FindBy(xpath="//div[contains(@class,'app-modal_modal-lg__x4Q86 app-modal_app-modal-container__Z+qQ7')]//button[contains(@class,'undefined undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-medium__WWpFr false')]")
    WebElement linkButton;

    public AddControllerPage linkDeviceToController(String deviceName){

        action.type(searchDeviceBox, deviceName);
        action.click(driver, searchButton);
        action.click(driver, linkedDevice);
        action.click(driver, linkButton);
        return new AddControllerPage();

    }

}

