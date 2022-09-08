package com.test.orangehrm;

import Utils.BrowserUtils;
import Utils.ConfigReader;
import Utils.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod //it will run before every test annotation
    public void setUp() {
       // WebDriverManager.chromedriver().setup(); when using driver helper you dont need this step or line 21
        driver = DriverHelper.getDriver(); //you centralize your driver into 1 spot instead of new chrome
        //driver which opens new chromes this is called singleton pattern design
       // driver.manage().window().maximize();
        driver.get(ConfigReader.readProperty("urlorangehrm"));
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (!result.isSuccess()){ //if it fails
            BrowserUtils.getScreenShot(driver,"OrangeHrmScreenshot");
        }
//        //driver.close();
    }

    }

