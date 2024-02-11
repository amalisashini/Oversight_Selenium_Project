package testCases;

import com.oversight.base.BaseClass;
import com.oversight.dataprovider.DataProviders;
import com.oversight.pageobjects.LoginPage;
import com.oversight.pageobjects.RegisterPage;
import com.oversight.pageobjects.VerifyMobileNumberPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RegisterPageTest extends BaseClass {

    LoginPage loginPage;
    RegisterPage registerPage;
    VerifyMobileNumberPage verifyMobileNumberPage;


    @BeforeMethod
    public void setUp(){

        launchApp();

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();

    }

    @Test(dataProvider = "registerCredentials", dataProviderClass = DataProviders.class)
    public void registerTest(HashMap<String,String> hashMapValue) throws InterruptedException {

        loginPage = new LoginPage();

        registerPage = loginPage.createNewAccount();
        verifyMobileNumberPage = registerPage.RegisterAccount(
                hashMapValue.get("firstName"),
                hashMapValue.get("lastName"),
                hashMapValue.get("userName"),
                hashMapValue.get("NIC"),
                hashMapValue.get("mobileNumber"),
                hashMapValue.get("email"),
                hashMapValue.get("password"),
                hashMapValue.get("confirmPassword")
        );
        boolean headerText = verifyMobileNumberPage.verifyHeaderText();
        Assert.assertTrue(headerText);
        loginPage = verifyMobileNumberPage.cancelAccount();

    }

}

