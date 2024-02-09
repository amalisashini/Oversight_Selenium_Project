package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseClass {

    Action action = new Action();
    public ProfilePage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//button[@id='add-bill-number']")
    WebElement addBillNumberBtn;

    @FindBy(xpath="//div[contains(text(),'Account Number Added Successfully')]")
    WebElement addingSuccessToastMessage;

    @FindBy(xpath="//div[@id='root']//following::div[text()='Inserted billing label is already in use, please add a different one']")
    WebElement existBillLabelValidation;

    @FindBy(xpath="//div[@id='root']//following::div[text()='Account number cannot be added or updated using an already added account number']")
    WebElement existBillNumberValidation;

    public AddNewBillingAccNumModelPage addNewBillingAccountPage(){

        action.JSClick(driver, addBillNumberBtn);
        return new AddNewBillingAccNumModelPage();
    }
    public boolean addSuccessToast(){

        return action.isDisplayed(driver, addingSuccessToastMessage);

    }

    public boolean existBillNumberToast(){

        return action.isDisplayed(driver, existBillNumberValidation);

    }

    public boolean existBillLabelToast(){

        return action.isDisplayed(driver, existBillLabelValidation);

    }

}

