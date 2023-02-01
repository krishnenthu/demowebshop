package com.demowebshop.testscript;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.ErrorMessage;
import com.demowebshop.listeners.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomeTest extends Base {
    HomePage home;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1, description = "TC001 verify home page title", groups = {"Smoke"})
    public void TC_001_verifyHomePageTitle() {
        extentTest.get().assignCategory("Smoke");
        List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
        String expectedHomePageTitle=data.get(0).get(1);
        home=new HomePage(driver);
        String actualHomePageTitle=home.getHomePageTitle();
        extentTest.get().log(Status.PASS,"Home page title received");
        Assert.assertEquals(actualHomePageTitle,expectedHomePageTitle, ErrorMessage.TITLE_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS,"Expected home page title match with actual home page title");
    }
    @Test(priority = 1, description = "TC002 verify subscribe email message", groups = {"Sanity"})
    public  void TC_002_verifySubscribeEmailMessage(){
        extentTest.get().assignCategory("Sanity");
        List<ArrayList<String>> data =ExcelUtility.excelDataReader("HomePage");
        String expectedSubscribeMessage=data.get(1).get(1);
        home=new HomePage(driver);
        home.enterSubscribeEmailId();
        home.clickOnSubscribeButton();
        String actualSubscribeMessage= home.getSubscribeMessage();
        extentTest.get().log(Status.PASS,"Subscribe email message received");
        Assert.assertEquals(actualSubscribeMessage,expectedSubscribeMessage,ErrorMessage.SUBSCRIBE_FAILURE_MESSAGE);
        extentTest.get().log(Status.PASS,"Expected Subscribe email message match with Subscribe email message");
    }
}
