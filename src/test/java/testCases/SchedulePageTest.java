package testCases;

import com.oversight.base.BaseClass;
import com.oversight.pageobjects.AddSchedulePage;
import com.oversight.pageobjects.DashboardPage;
import com.oversight.pageobjects.LoginPage;
import com.oversight.pageobjects.SchedulePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SchedulePageTest extends BaseClass {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    SchedulePage schedulePage;
    AddSchedulePage addSchedulePage;

    @BeforeMethod
    public void setUp() {

        launchApp();

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

    @Test
    public void addSchedule() throws InterruptedException {

        loginPage = new LoginPage();

        dashboardPage = loginPage.successLogin(prop.getProperty("userName"), prop.getProperty("password") );
        schedulePage = dashboardPage.navigateSchedulePage();
        addSchedulePage = schedulePage.addSchedule();
        schedulePage = addSchedulePage.addNewSchedule("new schedule");

    }

}

