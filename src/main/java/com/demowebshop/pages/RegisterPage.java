package com.demowebshop.pages;

import com.demowebshop.utilities.TestHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends TestHelperUtility {
    public WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    private final String _firstNameField ="//input[@id='FirstName']";
    @FindBy(xpath = _firstNameField) private WebElement firstNameField;

    private final String _lastNameField ="//input[@id='LastName']";
    @FindBy(xpath = _lastNameField) private WebElement lastNameField;

    private final String _emailField ="//input[@id='Email']";
    @FindBy(xpath = _emailField) private WebElement emailField;

    private final String _passwordField ="//input[@id='Password']";
    @FindBy(xpath = _passwordField) private WebElement passwordField;

    private final String _confirmPasswordField ="//input[@id='ConfirmPassword']";
    @FindBy(xpath = _confirmPasswordField) private WebElement confirmPasswordField;

    private final String _registerButton ="//input[@id='register-button']";
    @FindBy(xpath = _registerButton) private WebElement registerButton;

    private final String _genders ="//input[@name='Gender']/following-sibling::label";
    @FindBy(xpath = _genders) private List<WebElement> genders;

    public void selectGender(String gender){
        for (int i=0;i< genders.size();i++){
            String value=page.getElementText(genders.get(i));
            if (value.equals(gender)){
                page.clickOnElement(genders.get(i));
                break;
            }
        }
    }

    public  void enterFirstName(String fName){
        page.enterText(firstNameField,fName);
    }
    public  void enterLastName(String lName){
        page.enterText(lastNameField,lName);
    }
    public  void enterEmail(String email){
        page.enterText(emailField,email);
    }
    public  void enterPassword ( String password){
        page.enterText(passwordField,password);
    }
    public  void enterConfirmPassword (String confirmpassword){
        page.enterText(confirmPasswordField,confirmpassword);
    }
    public  UserAccountPage clickOnRegister(){
        page.clickOnElement(registerButton);
        return new UserAccountPage(driver);
    }


}
