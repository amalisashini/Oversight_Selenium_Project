package testCases;

import com.oversight.base.BaseClass;
import com.oversight.dataprovider.DataProviders;
import com.oversight.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BillingAccountNumberTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProfilePage profilePage;
    AddNewBillingAccNumModelPage addNewBillingAccountNumberPage;
    UpdateBillingAccountNumberPage updateBillingAccountNumberPage;
    RemoveAccountNumberModelPage removeBillingAccountNumberPage;

    @BeforeMethod
    public void setUp(){

        launchApp();

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();

    }


    @Test(priority = 1, dataProvider = "addBillNumberDetails", dataProviderClass = DataProviders.class)
    public void addBillNumberTest(String billingLabel, String billingAccount) throws InterruptedException {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        addNewBillingAccountNumberPage = profilePage.addNewBillingAccountNumber();
        profilePage = addNewBillingAccountNumberPage.addNewBillingAccNumber(billingLabel,billingAccount);
        Thread.sleep(3000);
        boolean toast = profilePage.addAccountNumberSuccessToast();
        Assert.assertTrue(toast);
    }

    @Test(priority = 2)
    public void addAlreadyAddedBillNumberTest() throws InterruptedException {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        addNewBillingAccountNumberPage = profilePage.addNewBillingAccountNumber();
        addNewBillingAccountNumberPage = addNewBillingAccountNumberPage.unSuccessBillingAccNumberTest("labelthhh new","98765476");
        Thread.sleep(2000);
        boolean toast = profilePage.existBillNumberValidation();
        Assert.assertTrue(toast);
    }

    @Test(priority = 3)
    public void addAlreadyAddedBillLabelTest() throws InterruptedException {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        addNewBillingAccountNumberPage = profilePage.addNewBillingAccountNumber();
        addNewBillingAccountNumberPage = addNewBillingAccountNumberPage.unSuccessBillingAccNumberTest("New label a","6776766");
        Thread.sleep(2000);
        boolean toast = profilePage.existBillLabelValidation();
        Assert.assertTrue(toast);
    }

    @Test(priority = 4)
    public void validationTest() {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        addNewBillingAccountNumberPage = profilePage.addNewBillingAccountNumber();
        addNewBillingAccountNumberPage = addNewBillingAccountNumberPage.ValidationTest("","");
        boolean labelToast = addNewBillingAccountNumberPage.labelValidation();
        Assert.assertTrue(labelToast);
        boolean tariffToast = addNewBillingAccountNumberPage.tariffDropValidation();
        Assert.assertTrue(tariffToast);
        boolean billNumToast = addNewBillingAccountNumberPage.accountNumberValidation();
        Assert.assertTrue(billNumToast);
    }

    @Test(priority = 5)
    public void updateBillNumberTest() throws InterruptedException {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        updateBillingAccountNumberPage = profilePage.updateBillingAccountNumber();
        profilePage = updateBillingAccountNumberPage.updateBillingAccNumber("Test","87654");
        Thread.sleep(3000);
        boolean toast = profilePage.updateAccountNumberSuccessToast();
        Assert.assertTrue(toast);
    }

    @Test(priority = 6)
    public void deleteBillNumberTest() {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        removeBillingAccountNumberPage = profilePage.deleteBillingAccountNumber();
        profilePage = removeBillingAccountNumberPage.removeBillingAccNumber();
        boolean toast = profilePage.deleteAccountNumberSuccessToast();
        Assert.assertTrue(toast);
    }

}

