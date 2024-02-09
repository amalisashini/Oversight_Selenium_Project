package testCases;

import com.oversight.base.BaseClass;
import com.oversight.dataprovider.DataProviders;
import com.oversight.pageobjects.DashboardPage;
import com.oversight.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp(){

        launchApp();

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();

    }

    @Test(priority = 1, dataProvider = "loginCredentials", dataProviderClass = DataProviders.class)
    public void successLoginTest(String username, String password){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(username,password);
        boolean header = dashboardPage.validateHeader();
        Assert.assertTrue(header);

        boolean toast = dashboardPage.successToast();
        Assert.assertTrue(toast);
    }

    @Test(priority = 2, dataProvider = "UnSuccessLoginCredentials", dataProviderClass = DataProviders.class)
    public void UnSuccessLoginTest(String wrongUserName, String wrongPassword) throws InterruptedException {

        loginPage = new LoginPage();

        loginPage = loginPage.UnSuccessLogin(wrongUserName, wrongPassword);
        Thread.sleep(3000);
        boolean unSuccessToast = loginPage.UnSuccessToast();
        Assert.assertTrue(unSuccessToast);
    }

    @Test(priority = 3)
    public void validationLoginTest(){

        loginPage = new LoginPage();

        loginPage = loginPage.UnSuccessLogin(prop.getProperty(""), prop.getProperty(""));

        boolean emlValidation = loginPage.emailValidation();
        Assert.assertTrue(emlValidation);

        boolean passValidation = loginPage.passwordValidation();
        Assert.assertTrue(passValidation);


    }

}

