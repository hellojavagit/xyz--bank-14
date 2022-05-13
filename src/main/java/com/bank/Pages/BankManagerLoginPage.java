package com.bank.Pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
    public BankManagerLoginPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomerButton;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement openAccountButton;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[3]")
    WebElement customerButton;



    public void clickOnHomeButton(){
        clickOnElement(homeButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Home' Button");
        Reporter.log("Click on 'Home' Button" + "<br>");
    }

    public void clickOnAddCustomerButton(){
        clickOnElement(addCustomerButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Add Customer' Button");
        Reporter.log("Click on 'Add Customer' Button" + "<br>");
    }

    public void clickOnOpenAccountButton(){
        clickOnElement(openAccountButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Open Account' Button");
        Reporter.log("Click on 'Open Account' Button" + "<br>");
    }

    public void clickOnCustomerButton(){
        clickOnElement(customerButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Customer' Button");
        Reporter.log("Click on 'Customer' Button" + "<br>");
    }

}
