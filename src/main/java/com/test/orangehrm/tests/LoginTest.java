package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
//    WebDriver driver;
//    @BeforeMethod //it will run before every test annotation
//    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
//        System.out.println("I am running for BeforeMethod Annotation");
//
//    }
    @Test
    public void validatePositiveLoginTest()throws InterruptedException{
        LoginPage loginPage=new LoginPage(driver); //to call the constructor. Thats why we cant make it static
        loginPage.sendInformation(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
//        String actualUrl=driver.getCurrentUrl();
//        String expectedUrl="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }

    @Test
    public void validateNegativeLoginTest1()throws InterruptedException{
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation("Admin","adgh1222"); //incorrect password
//        String actualMessage=loginPage.errorMessage();
//        String expectedMessage="Invalid credentials";
        Assert.assertEquals(loginPage.errorMessage(),"Invalid credentials");
        driver.close();
    }
    @Test
    public void validateNegativeLoginTest2() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login/");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendInformation("",""); //incorrect password
//        String actualMessage=loginPage.errorMessage();
//        String expectedMessage=";
        Assert.assertEquals(loginPage.errorMessage(),"Username cannot be empty");
//        String actualColor=loginPage.getColorOfMessage();
//        String expectedColor="rgba(221, 119, 0, 1)";
        Assert.assertEquals(loginPage.getColorOfMessage(),"rgba(221, 119, 0, 1)");
    }
    @AfterMethod
    public void tearDown(){
//        System.out.println("this is running for after method annotation");
//
   }
}
