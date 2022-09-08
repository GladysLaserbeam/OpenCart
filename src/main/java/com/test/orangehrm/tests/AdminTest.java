package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.OrangeHrmDataProviderClass;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {
//    WebDriver driver;
//
//    @BeforeMethod //it will run before every test annotation
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");


    @Test
    public void validateUrlAndAddButton() throws InterruptedException {
         /*
        1-Choose the User Role "Admin"
        2-Employee Name "Alice Duval"
        3-Username can be anything but should be different for each run
        4-Status should be disabled
        5-put your password
        6-put your confirm password
        7-Click save button
         */
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendInformation("Admin", "admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdmin();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAddButton();
        adminPage.sendEmployeeInformation("Admin", "Alice Duval", "ahmet53333",
                "Disabled", "12345678", "12345678");
        Assert.assertTrue(adminPage.validationUserNameIsCreated("ahmet53333"));

    }

    @Test(dataProvider = "HrmcreateAccount",dataProviderClass = OrangeHrmDataProviderClass.class)
    public void creatingEmployeeAccount(String role,String name, String username,String status, String Password,String confirmPassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendInformation(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdmin();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.clickAddButton();
        adminPage.sendEmployeeInformation(role, name, username, status, Password, confirmPassword);
        Assert.assertTrue(adminPage.validationUserNameIsCreated(username));



    }


    }
