package com.demowebshop.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessage;
import com.demowebshop.listeners.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import com.demowebshop.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RegisterTest extends Base {
    HomePage home;
    RegisterPage register;
    UserAccountPage useraccountpage;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1,description = "TC001 Verify Register Page Title",groups = {"Regression"})
    public void TC001_verifyUserRegistration() {
        extentTest.get().assignCategory("Regression");
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("RegisterPage");
        String gender=data.get(0).get(1);
        String fName=RandomDataUtility.getfName();
        String lName=RandomDataUtility.getlName();
        String email=RandomDataUtility.getRandomEmail();
        String password=fName+"@123";
        String confirmPassword=password;
        home=new HomePage(driver);
        home.clickOnRegisterMenu();
        register=new RegisterPage(driver);
        register.selectGender(gender);
        register.enterFirstName(fName);
        register.enterLastName(lName);
        register.enterEmail(email);
        register.enterPassword(password);
        register.enterConfirmPassword(confirmPassword);
        useraccountpage = register.clickOnRegister();
        String actEmail=useraccountpage.getUserAccountEmailId();
        Assert.assertEquals(email,actEmail, ErrorMessage.INVALID_EMAIL_ID);
        extentTest.get().log(Status.PASS,"User registration completed successfully");
    }
}
