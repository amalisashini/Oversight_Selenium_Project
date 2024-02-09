package com.oversight.base;

import com.oversight.actiondriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;

    @BeforeTest
    public void loadConfig() {

        try {

            prop = new Properties();
            String propertiesPath = System.getProperty("user.dir") + "\\Configuration\\Config.properties";
            FileInputStream fis = new FileInputStream(propertiesPath);
            prop.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void launchApp() {
        Action action = new Action();
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("ie")) {

            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        }

        driver.manage().window().maximize();
        action.implicitWait(driver, 20);
        action.pageLoadTimeOut(driver, 40);
        driver.get(prop.getProperty("url"));

    }


}



