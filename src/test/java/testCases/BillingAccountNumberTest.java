package testCases;

import com.oversight.base.BaseClass;
import com.oversight.dataprovider.DataProviders;
import com.oversight.pageobjects.AddNewBillingAccNumModelPage;
import com.oversight.pageobjects.DashboardPage;
import com.oversight.pageobjects.LoginPage;
import com.oversight.pageobjects.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BillingAccountNumberTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProfilePage profilePage;
    AddNewBillingAccNumModelPage addNewBillingAccountNumberPage;

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
        addNewBillingAccountNumberPage = profilePage.addNewBillingAccountPage();
        profilePage = addNewBillingAccountNumberPage.addNewBillingAccNumber(billingLabel,billingAccount);
        Thread.sleep(3000);
        boolean toast = profilePage.addSuccessToast();
        Assert.assertTrue(toast);
    }

    @Test(priority = 2)
    public void addAlreadyAddedBillNumberTest() throws InterruptedException {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        addNewBillingAccountNumberPage = profilePage.addNewBillingAccountPage();
        addNewBillingAccountNumberPage = addNewBillingAccountNumberPage.unSuccessBillingAccNumberTest("labelthhh new","98765476");
        Thread.sleep(2000);
        boolean toast = profilePage.existBillNumberToast();
        Assert.assertTrue(toast);
    }

    @Test(priority = 3)
    public void addAlreadyAddedBillLabelTest() throws InterruptedException {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        addNewBillingAccountNumberPage = profilePage.addNewBillingAccountPage();
        addNewBillingAccountNumberPage = addNewBillingAccountNumberPage.unSuccessBillingAccNumberTest("New label a","6776766");
        Thread.sleep(2000);
        boolean toast = profilePage.existBillLabelToast();
        Assert.assertTrue(toast);
    }

    @Test(priority = 1)
    public void validationTest() throws InterruptedException {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        addNewBillingAccountNumberPage = profilePage.addNewBillingAccountPage();
        addNewBillingAccountNumberPage = addNewBillingAccountNumberPage.ValidationTest("","");
        boolean labelToast = addNewBillingAccountNumberPage.labelValidation();
        Assert.assertTrue(labelToast);
        boolean tariffToast = addNewBillingAccountNumberPage.tariffDropValidation();
        Assert.assertTrue(tariffToast);
        boolean billNumToast = addNewBillingAccountNumberPage.accountNumberValidation();
        Assert.assertTrue(billNumToast);
    }
}

