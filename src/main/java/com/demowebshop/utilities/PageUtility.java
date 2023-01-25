package com.demowebshop.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class PageUtility {

    public String getPageTitle(WebDriver driver) {
        String title = driver.getTitle();
        return title;
    }

    public String getCurrentUrl(WebDriver driver) {
        String url = driver.getCurrentUrl();
        return url;
    }

    public String getPageSource(WebDriver driver) {
        String pageSource = driver.getPageSource();
        return pageSource;
    }

    public String getWindowHandleId(WebDriver driver) {
        String handleId = driver.getWindowHandle();
        return handleId;
    }

    public Set<String> getWindowHandles(WebDriver driver) {
        Set<String> handlesIds = driver.getWindowHandles();
        return handlesIds;
    }


    public void pageRefresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void pageForward(WebDriver driver) {
        driver.navigate().forward();
    }

    public void pageBackward(WebDriver driver) {
        driver.navigate().back();
    }


    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void clearField(WebElement element) {
        element.clear();
    }

    public void submitForm(WebElement element) {
        element.submit();
    }

    public String getTagName(WebElement element) {
        String tagName = element.getTagName();
        return tagName;
    }

    public String getText(WebElement element) {
        String text = element.getText();
        return text;
    }

    public String getAttributeValue(WebElement element, String attribute) {
        String attributeValue = element.getAttribute(attribute);
        return attributeValue;
    }

    public String getCSSValue(WebElement element, String property) {
        String cssValue = element.getCssValue(property);
        return cssValue;
    }

    public Point getLocation(WebElement target) {
        Point point = target.getLocation();
        return point;
    }

    public Dimension getSize(WebElement target) {
        Dimension dimension = target.getSize();
        return (dimension);
    }

    public boolean isDisplayed(WebElement target) {
        boolean displayStatus = target.isDisplayed();
        return displayStatus;
    }

    public boolean isEnabled(WebElement target) {
        boolean enabledStatus = target.isEnabled();
        return enabledStatus;
    }

    public boolean isSelected(WebElement target) {
        boolean selectedStatus = target.isSelected();
        return selectedStatus;
    }
    public void simpleAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void confirmationAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void promptAlert(WebDriver driver, String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }
    public  void rightClick(WebDriver driver, WebElement target){
        Actions action = new Actions(driver);
        action.contextClick(target).build().perform();
    }
    public  void doubleClick(WebDriver driver, WebElement target){
        Actions action = new Actions(driver);
        action.doubleClick(target).build().perform();
    }
    public  void mouseOver(WebDriver driver, WebElement target){
        Actions action = new Actions(driver);
        action.moveToElement(target).build().perform();
    }
    public  void mouseOverByOffsetAndWebElement(WebDriver driver, WebElement target,int x, int y){
        Actions action = new Actions(driver);
        action.moveToElement(target,x,y).build().perform();
    }
    public  void mouseOverByOffSet(WebDriver driver, int x, int y){
        Actions action = new Actions(driver);
        action.moveByOffset(x,y).build().perform();
    }

    public void DragAndDrop(WebDriver driver, WebElement source, WebElement destination) {
        Actions action = new Actions(driver);
        action.dragAndDrop(source, destination).build().perform();
    }
    public void DragAndDropByOffset(WebDriver driver, WebElement source, int x, int y) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(source,x,y).build().perform();
    }
    public void reSize(WebDriver driver, WebElement source,int x, int y ) {
        Actions action = new Actions(driver);
        action.clickAndHold().dragAndDropBy(source, x, y).build().perform();
        action.release(source).build().perform();
    }
    public void dropDownSelectByIndex(WebElement target, int index){
        Select select = new Select(target);
        select.selectByIndex(index);
    }
    public void dropDownSelectByValue(WebElement target, String attributeValue){
        Select select = new Select(target);
        select.selectByValue(attributeValue);
    }
    public void dropDownSelectByVisibleText(WebElement target, String text){
        Select select = new Select(target);
        select.selectByVisibleText(text);
    }
    public List<WebElement> getAllDropDownOptions(WebElement target, String text){
        Select select = new Select(target);
        List<WebElement> dropdownOptions = select.getOptions();
        return dropdownOptions;
    }
    public  List<WebElement> getAllSelectedOptionsOfADropDown(WebElement target){
        Select select = new Select(target);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        return  selectedOptions;

    }
    public  WebElement getFirstSelectedOptionsOfADropDown(WebElement target){
        Select select = new Select(target);
        WebElement firstSelectedOption=select.getFirstSelectedOption();
        return firstSelectedOption;
    }
    public  void deselectAllOptionsOfDropDown(WebElement target){
        Select select = new Select(target);
        select.deselectAll();
    }
    public void dropDownDeSelectByIndex(WebElement target, int index){
        Select select = new Select(target);
        select.selectByIndex(index);
    }
    public void dropDownDeSelectByValue(WebElement target, String attributeValue){
        Select select = new Select(target);
        select.deselectByValue(attributeValue);
    }
    public void dropDownDeSelectByVisibleText(WebElement target, String text){
        Select select = new Select(target);
        select.deselectByVisibleText(text);
    }
    public boolean dropDownMultipleSelected(WebElement target){
        Select select = new Select(target);
        boolean multipleStatus = select.isMultiple();
        return multipleStatus;
    }
    public void ScrollDownOfWebpage(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(x,y)");
    }

    public void ScrollingToViewOfWebElement(WebDriver driver, WebElement target) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", target);
    }

    public void ScrollToBottomOfThePage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void HorizontalScroll(WebDriver driver, WebElement target) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", target);
    }



}