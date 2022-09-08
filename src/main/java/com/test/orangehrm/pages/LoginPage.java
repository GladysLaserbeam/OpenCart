package com.test.orangehrm.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //I store all of my loginPage elements and methods here// this method is to initialize all methods
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "txtUsername")
    WebElement username;

    @FindBy(name= "txtPassword")
    WebElement password;

    @FindBy(xpath = "//input[@id='btnLogin']")
    WebElement loginButton;

    @FindBy(id = "spanMessage")
    WebElement message;


    public void sendInformation(String username, String password) throws InterruptedException {
        this.username.sendKeys(username); //we are implementing this to initate the username and password from the instance
        Thread.sleep(3000);
        this.password.sendKeys(password); //variable. Without doing this you are calling it local in the parameters
        loginButton.click();
    }

    public String errorMessage(){
        return BrowserUtils.getText(message);
    }

    public String getColorOfMessage(){
        return message.getCssValue("color");
    }
}
