package com.oversight.pageobjects;

import com.oversight.actiondriver.Action;
import com.oversight.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewBillingAccNumModelPage extends BaseClass {

    Action action = new Action();
    public AddNewBillingAccNumModelPage() {

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//div[@class='d-block']//input[@name='label']")
    WebElement billingLabelField;

    @FindBy(xpath="//div[@class=' css-19bb58m']")
    WebElement tariffType;

    @FindBy(xpath="//div[@class='d-block']//input[@placeholder='Billing Account number']")
    WebElement billingAccNumField;

    @FindBy(xpath="//button[@id='billing-account-confirm']")
    WebElement confirmBtn;

    @FindBy(xpath="//span[contains(text(),'Label is required')]")
    WebElement labelValidation;

    @FindBy(xpath="//span[contains(text(),'Please select a tariff code')]")
    WebElement tariffDropValidation;

    @FindBy(xpath="//span[contains(text(),'Account number is required')]")
    WebElement accountNumberValidation;

    public ProfilePage addNewBillingAccNumber(String billLabel, String billAccNum){

        action.type(billingLabelField, billLabel);
        action.selectDrop(driver, tariffType);
        action.type(billingAccNumField, billAccNum);
        action.JSClick(driver, confirmBtn);
        return new ProfilePage();

    }

    public AddNewBillingAccNumModelPage unSuccessBillingAccNumberTest(String billLabel, String billAccNum){

        action.type(billingLabelField, billLabel);
        action.selectDrop(driver, tariffType);
        action.type(billingAccNumField, billAccNum);
        action.JSClick(driver, confirmBtn);
        return new AddNewBillingAccNumModelPage();

    }

    public AddNewBillingAccNumModelPage ValidationTest(String billLabel, String billAccNum){

        action.type(billingLabelField, billLabel);
        action.click(driver, tariffType);
        action.type(billingAccNumField, billAccNum);
        action.JSClick(driver, confirmBtn);
        return new AddNewBillingAccNumModelPage();

    }

    public boolean labelValidation(){

        return action.isDisplayed(driver, labelValidation);

    }

    public boolean tariffDropValidation(){

        return action.isDisplayed(driver, tariffDropValidation);

    }

    public boolean accountNumberValidation(){

        return action.isDisplayed(driver, accountNumberValidation);

    }

}

