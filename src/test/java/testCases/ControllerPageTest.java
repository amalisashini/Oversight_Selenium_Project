package testCases;

import com.oversight.base.BaseClass;
import com.oversight.dataprovider.DataProviders;
import com.oversight.pageobjects.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ControllerPageTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ControllersPage controllersPage;
    AddControllerPage addControllerPage;
    LinkControllerPage linkControllerPage;


    @BeforeMethod
    public void setUp() {

        launchApp();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

    @Test(dataProvider = "addControllerDetails", dataProviderClass = DataProviders.class)
    public void addNewController(String controllerName, String serialKey){


        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        controllersPage = dashboardPage.navigateControllerPage();
        addControllerPage = controllersPage.createNewController();
        addControllerPage.AddControllerDetails(controllerName, serialKey);
        linkControllerPage = addControllerPage.selectDevice();
        addControllerPage = linkControllerPage.linkDeviceToController("new");
        controllersPage = addControllerPage.AddControllerConfirm();

    }

}

