package testCases;

import com.oversight.base.BaseClass;
import com.oversight.dataprovider.DataProviders;
import com.oversight.pageobjects.AddDevicePage;
import com.oversight.pageobjects.DashboardPage;
import com.oversight.pageobjects.DevicePage;
import com.oversight.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DeviceTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    DevicePage devicePage;
    AddDevicePage addDevicePage;

    @BeforeMethod
    public void setUp() {

        launchApp();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

    @Test(priority = 1, dataProvider = "addDeviceDetails", dataProviderClass = DataProviders.class)
    public void addBillingSpaceTest(HashMap<String,String> hashMapValue){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        devicePage = dashboardPage.navigateDevicePage();
        addDevicePage = devicePage.addNewDevice();
        addDevicePage.addNewDevice(
                hashMapValue.get("deviceName"),
                hashMapValue.get("brand"),
                hashMapValue.get("model"),
                hashMapValue.get("powerUsage"));
        boolean successToast = devicePage.addDeviceSuccessToast();
        Assert.assertTrue(successToast);
    }

}

