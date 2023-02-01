package com.demowebshop.testscript;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessage;
import com.demowebshop.dataprovider.Dataproviders;
import com.demowebshop.listeners.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends Base {
    HomePage home;
    LoginPage login;
    UserAccountPage useraccountpage;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1,description = "TC001 Verify Login Page Title",groups = {"Sanity"})
    public void TC001_verifyLoginPageTitle(){
        extentTest.get().assignCategory("Sanity");
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String expLoginPageTitle=data.get(1).get(0);
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        String actLogingPageTitle=login.getLoginPageTitle();
        extentTest.get().log(Status.PASS,"Login page title received");
        Assert.assertEquals(actLogingPageTitle,expLoginPageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS,"Expected login page title match with actual login page title");
    }
    @Test(priority = 1,description = "TC002 Verify Valid Login",groups = {"Sanity"})
    public void TC002_verifyValidLogin(){
        extentTest.get().assignCategory("Sanity");
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String userEmailId=data.get(1).get(1);
        login.enterUserEmailId(userEmailId);
        String userPassword=data.get(1).get(2);
        login.enterUserPassword(userPassword);
        useraccountpage = login.clickOnLoginButton();
        String actEmail=useraccountpage.getUserAccountEmailId();
        extentTest.get().log(Status.PASS,"Subscribe email message received");
        Assert.assertEquals(userEmailId,actEmail, ErrorMessage.INVALID_EMAIL_ID);
        extentTest.get().log(Status.PASS,"Expected email id matches with actual email id");
    }
    @Test(priority = 1,description = "TC003 Verify Invalid Login error message", dataProvider = "InvalidUserCredentials", dataProviderClass = Dataproviders.class,groups = {"Regression"})
    public void TC003_verifyInValidLoginErrorMessage(String userName, String password) {
        extentTest.get().assignCategory("Regression");
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
        String expectedErrorMessage=data.get(1).get(3);
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        login.enterUserEmailId(userName);
        login.enterUserPassword(password);
        login.clickOnLoginButton();
        extentTest.get().log(Status.PASS,"Login error message received");
        String actualErrorMessage= login.getLoginErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,ErrorMessage.INVALID_ERROR_MESSAGE);
        extentTest.get().log(Status.PASS,"Expected Login error message matches with actual Login error message");
    }
}

