package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSchedulePage extends BaseClass {

    Action action = new Action();
    public AddSchedulePage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//input[@name='title']")
    WebElement titleField;

    @FindBy(xpath="//div[@class='align-items-center justify-content-between text-light font-weight-400 font-size-14 mt-4 row row-cols-auto']//div[@class='app-switch_switch__xyKIW app-switch_sm__JKmxS cursor-pointer  app-switch_offBackground__Ucsdi']")
    WebElement selectDevices;

    @FindBy(xpath="//button[@class='undefined undefined app-button_app-button__xBnO8 app-button_app-button-blue__MyFQW app-button_app-button-medium__WWpFr false']//div[contains(text(),'Automate')]")
    WebElement automateBtn;

    public SchedulePage addNewSchedule(String title){

        action.type(titleField, title);
        action.selectTimeSlot(driver, selectDevices);
        action.click(driver, automateBtn);
        return new SchedulePage();

    }

}

