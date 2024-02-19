package testCases;

import com.oversight.base.BaseClass;
import com.oversight.dataprovider.DataProviders;
import com.oversight.pageobjects.AddSpacePage;
import com.oversight.pageobjects.DashboardPage;
import com.oversight.pageobjects.DevicePage;
import com.oversight.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SubSpaceTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    DevicePage devicePage;
    AddSpacePage addSpacePage;

    @BeforeMethod
    public void setUp() {

        launchApp();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

    @Test(priority = 1, dataProvider = "addSubSpaceDetails", dataProviderClass = DataProviders.class)
    public void addSpaceTest(String spaceName){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        devicePage = dashboardPage.navigateDevicePage();
        addSpacePage = devicePage.selectAddSpace();
        devicePage = addSpacePage.addSubSpace(spaceName);
        boolean successToast = devicePage.addSubSpaceSuccessToast();
        Assert.assertTrue(successToast);
    }

    @Test(priority = 2, dataProvider = "addSubSpaceDetails", dataProviderClass = DataProviders.class)
    public void addExistingSpaceTest(String spaceName){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        devicePage = dashboardPage.navigateDevicePage();
        addSpacePage = devicePage.selectAddSpace();
        addSpacePage = addSpacePage.addSubSpaceUnSuccess(spaceName);
        boolean UnSuccessToast = addSpacePage.addSubSpaceUnSuccessToast();
        Assert.assertTrue(UnSuccessToast);
    }

    @Test(priority = 3)
    public void addSubSpaceValidationTest(){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        devicePage = dashboardPage.navigateDevicePage();
        addSpacePage = devicePage.selectAddSpace();
        addSpacePage = addSpacePage.addSubSpaceUnSuccess("");
        boolean validation = addSpacePage.addSubSpaceValidation();
        Assert.assertTrue(validation);
    }

}

