package testCases;

import com.oversight.base.BaseClass;
import com.oversight.dataprovider.DataProviders;
import com.oversight.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProfilePage profilePage;
    CreateNewPasswordPage createNewPasswordPage;
    EmailChangePage emailChangePage;

    @BeforeMethod
    public void setUp(){

        launchApp();

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();

    }

    @Test(priority = 1, dataProvider = "editPasswordDetails", dataProviderClass = DataProviders.class)
    public void editPasswordTest(String password, String confirmPassword){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        createNewPasswordPage = profilePage.passwordEdit();
        profilePage = createNewPasswordPage.editPassword(password,confirmPassword);
        boolean toast = profilePage.editPasswordSuccessToast();
        Assert.assertTrue(toast);
    }

    @Test(priority = 2)
    public void PasswordEditValidationTest(){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        createNewPasswordPage = profilePage.passwordEdit();
        createNewPasswordPage = createNewPasswordPage.ValidationTest("","");
        boolean passwordToast = createNewPasswordPage.passwordValidation();
        Assert.assertTrue(passwordToast);
        boolean conPasswordToast = createNewPasswordPage.conPasswordValidation();
        Assert.assertTrue(conPasswordToast);
    }

    @Test(priority = 3, dataProvider = "changeEmailDetails", dataProviderClass = DataProviders.class)
    public void changeEmailTest(String email){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        emailChangePage = profilePage.emailChange();
        profilePage = emailChangePage.changeEmail(email);
        boolean toast = profilePage.changeEmailSuccessToast();
        Assert.assertTrue(toast);
    }

    @Test(priority = 4, dataProvider = "changeExistEmailDetails", dataProviderClass = DataProviders.class)
    public void emailChangeWithExistingEmailTest(String existEmail){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        emailChangePage = profilePage.emailChange();
        emailChangePage = emailChangePage.emailChangeValidation(existEmail);
        boolean validation = emailChangePage.changeWithExistEmailValidation();
        Assert.assertTrue(validation);
    }

    @Test(priority = 5)
    public void emailChangeValidationTest(){

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password"));
        profilePage = dashboardPage.navigateProfilePage();
        emailChangePage = profilePage.emailChange();
        emailChangePage = emailChangePage.emailChangeValidation("");
        boolean validation = emailChangePage.changeEmailValidation();
        Assert.assertTrue(validation);
    }



}
