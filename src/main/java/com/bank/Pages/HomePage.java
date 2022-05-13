package com.bank.Pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginButton;


    public void clickOnHomeButton() {
        clickOnElement(homeButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Home' Button");
        Reporter.log("Click on 'Home' Button" + "<br>");
    }

    public void clickOnCustomerLoginButton() {
        clickOnElement(customerLoginButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Customer Login' Button");
        Reporter.log("Click on 'Customer Login' Button" + "<br>");
    }

    public void clickOnBankManagerLoginButton() {
        clickOnElement(bankManagerLoginButton);
        CustomListeners.node.log(Status.PASS, "Click on 'Bank Manager Login' Button");
        Reporter.log("Click on 'Bank Manager Login' Button" + "<br>");
    }

}
