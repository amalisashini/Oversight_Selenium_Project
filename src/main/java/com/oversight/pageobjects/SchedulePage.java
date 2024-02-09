package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage extends BaseClass {

    Action action = new Action();
    public SchedulePage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//div[@id=\"cellId294\"]")
    WebElement timeSlot;

    public AddSchedulePage addSchedule() throws InterruptedException {

        action.scrollByVisibilityOfElement(driver, timeSlot);
        Thread.sleep(3000);
        action.selectTimeSlot(driver, timeSlot);
        return new AddSchedulePage();

    }

}

