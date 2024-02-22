package testCases;

import com.oversight.base.BaseClass;
import com.oversight.dataprovider.DataProviders;
import com.oversight.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BillingSpacesTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    DevicePage devicePage;
    AddBillingSpaceModelPage addNewSpaceModelPage;
    UpdateBillingSpaceModelPage updateSpaceModelPage;

    @BeforeMethod
    public void setUp() {

        launchApp();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }


    @Test(priority = 1, dataProvider = "addBillingSpaceDetails", dataProviderClass = DataProviders.class)
    public void addBillingSpaceTest(String billingSpaceName) throws InterruptedException {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        devicePage = dashboardPage.navigateDevicePage();
        addNewSpaceModelPage = devicePage.addBillingSpace();
        devicePage = addNewSpaceModelPage.addNewBillingSpace(billingSpaceName);
        Thread.sleep(2000);
        boolean successToast = devicePage.addBillingSpaceSuccessToast();
        Assert.assertTrue(successToast);
    }

    @Test(priority = 2, dataProvider = "addBillingSpaceDetails", dataProviderClass = DataProviders.class)
    public void addExistingBillingSpaceTest(String billingSpaceName){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        devicePage = dashboardPage.navigateDevicePage();
        addNewSpaceModelPage = devicePage.addBillingSpace();
        addNewSpaceModelPage = addNewSpaceModelPage.UnSuccessAddNewBillingSpace(billingSpaceName);
        boolean successToast = addNewSpaceModelPage.addBillingSpaceUnSuccessToast();
        Assert.assertTrue(successToast);
    }

    @Test(priority = 3)
    public void spaceValidationTest(){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        devicePage = dashboardPage.navigateDevicePage();
        addNewSpaceModelPage = devicePage.addBillingSpace();
        addNewSpaceModelPage = addNewSpaceModelPage.UnSuccessAddNewBillingSpace("");
        boolean spaceNameValidation = addNewSpaceModelPage.spaceNameValidation();
        Assert.assertTrue(spaceNameValidation);
        boolean billingAccNoValidation = addNewSpaceModelPage.accountNumberValidation();
        Assert.assertTrue(billingAccNoValidation);
    }

    @Test(priority = 4)
    public void updateBillingSpaceTest(){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        devicePage = dashboardPage.navigateDevicePage();
        updateSpaceModelPage = devicePage.UpdateBillingSpace();
        devicePage = updateSpaceModelPage.updateNewBillingSpace("Bil");
        boolean successToast = devicePage.updateBillingSpaceSuccessToast();
        Assert.assertTrue(successToast);
    }

}

