package com.bank.Pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    public OpenAccountPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement selectCustomerJustAdded;

    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement selectCurrency;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;


    public void clickOnHomeButton() {
        clickOnElement(homeButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Home' Button");
        Reporter.log("Click on 'Home' Button" + "<br>");
    }

    public void selectCustomerJustAddedDropDown(String name) {
        selectByVisibleTextFromDropDown(selectCustomerJustAdded,name);
        CustomListeners.node.log(Status.PASS, "Select Customer Just Added '" + name + "'");
        Reporter.log("Select Customer Just Added '" + name + "'" + "<br>");
    }

    public void selectCurrencyDropDown(String currency) {
        selectByVisibleTextFromDropDown(selectCurrency, currency);
        CustomListeners.node.log(Status.PASS, "Select Currency '" + currency + "'");
        Reporter.log("Select Currency '" + currency + "'" + "<br>");
    }

    public void clickOnProcessButton() {
        clickOnElement(processButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Process' Button");
        Reporter.log("Click on 'Process' Button" + "<br>");
    }

    public String textFromAlert() {
        String successfullyCreatedMessage = getTextFromAlert();
        String actualSuccessfullyCreatedMessage = successfullyCreatedMessage.substring(0,28);
        CustomListeners.node.log(Status.PASS, "Get Account created successfully text : " + actualSuccessfullyCreatedMessage);
        Reporter.log("Get Account created successfully text : " + actualSuccessfullyCreatedMessage + "<br>");
        return actualSuccessfullyCreatedMessage;
    }

    public void clickOkOnAlert() {
        acceptAlert();
    }
}
