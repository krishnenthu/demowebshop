package com.demowebshop.dataprovider;

import com.demowebshop.utilities.ExcelUtility;
import org.testng.annotations.DataProvider;

public class Dataproviders {

    ExcelUtility excel=new ExcelUtility();
    @DataProvider(name = "InvalidUserCredentials")
    public Object[][] invalidUserCredentialsToLogin(){
        Object[][] data=excel.dataProviderRead("LoginPageDataProvider");
        return data;
    }

}
