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

    @FindBy(css="tbody tr:nth-child(1) td:nth-child(5) span:nth-child(1)")
    WebElement editBillNumberBtn;

    @FindBy(css="tbody tr:nth-child(1) td:nth-child(6) span:nth-child(1)")
    WebElement deleteBillNumberBtn;

    @FindBy(xpath="//div[contains(@class,'mt-4 mt-xl-0 row')]//span[contains(@class,'font-size-14 material-symbols-outlined')][normalize-space()='border_color']")
    WebElement passwordEditBtn;

    @FindBy(xpath="//body/div[@id='root']/div[@class='dashboard-layout_main-container__Y8Akm vh-100']/div[@class='dashboard-layout_main-content__VncRM dashboard-layout_main-content-notCollapsed__BChL8']/div[@class='dashboard-scrollable-parent ps-lg-2 pb-4 pt-4 pt-xl-0 dashboard-layout_content-container__dfesD']/div[@class='container-fluid']/div[@class='row']/div[@class='col-12']/div[@class='container-white']/div[@class='row']/div[@class='col-xl-6']/div[3]/div[1]/div[1]/div[2]/span[1]")
    WebElement emailEditBtn;

    @FindBy(xpath="//div[contains(text(),'Account Number Added Successfully')]")
    WebElement addingSuccessToastMessage;

    @FindBy(xpath="//div[contains(text(),'Account Number Updated Successfully')]")
    WebElement updatingSuccessToastMessage;

    @FindBy(xpath="//div[contains(text(),'Account Number Deleted Successfully')]")
    WebElement deletingSuccessToastMessage;

    @FindBy(xpath="//div[@id='root']//following::div[text()='Inserted billing label is already in use, please add a different one']")
    WebElement existBillLabelValidation;

    @FindBy(xpath="//div[@id='root']//following::div[text()='Account number cannot be added or updated using an already added account number']")
    WebElement existBillNumberValidation;

    @FindBy(xpath="//div[contains(text(),'Password Reset Successfully')]")
    WebElement passwordEditSuccessToastMessage;

    @FindBy(xpath="//div[contains(text(),'Email updated successfully')]")
    WebElement emailEditSuccessToastMessage;

    public AddNewBillingAccNumModelPage addNewBillingAccountNumber(){

        action.JSClick(driver, addBillNumberBtn);
        return new AddNewBillingAccNumModelPage();
    }

    public UpdateBillingAccountNumberPage updateBillingAccountNumber(){

        action.JSClick(driver, editBillNumberBtn);
        return new UpdateBillingAccountNumberPage();

    }

    public RemoveAccountNumberModelPage deleteBillingAccountNumber(){

        action.JSClick(driver, deleteBillNumberBtn);
        return new RemoveAccountNumberModelPage();

    }

    public CreateNewPasswordPage passwordEdit(){

        action.JSClick(driver, passwordEditBtn);
        return new CreateNewPasswordPage();

    }

    public EmailChangePage emailChange(){

        action.JSClick(driver, emailEditBtn);
        return new EmailChangePage();

    }

    public boolean addAccountNumberSuccessToast(){

        return action.isDisplayed(driver, addingSuccessToastMessage);

    }

    public boolean updateAccountNumberSuccessToast(){

        return action.isDisplayed(driver, updatingSuccessToastMessage);

    }

    public boolean deleteAccountNumberSuccessToast(){

        return action.isDisplayed(driver, deletingSuccessToastMessage);

    }

    public boolean existBillNumberValidation(){

        return action.isDisplayed(driver, existBillNumberValidation);

    }

    public boolean existBillLabelValidation(){

        return action.isDisplayed(driver, existBillLabelValidation);

    }

    public boolean editPasswordSuccessToast(){

        return action.isDisplayed(driver, passwordEditSuccessToastMessage);

    }

    public boolean changeEmailSuccessToast(){

        return action.isDisplayed(driver, emailEditSuccessToastMessage);

    }

}

