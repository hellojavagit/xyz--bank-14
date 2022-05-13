package com.bank.testsuite;

import com.bank.Pages.*;
import com.bank.customlisteners.CustomListeners;
import com.bank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends TestBase {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddcustomerPage addCustomerPage;
    CustomerLoginPage customerLoginPage;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddcustomerPage();
        customerLoginPage = new CustomerLoginPage();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        accountPage = new AccountPage();

    }

    @Test(priority = 1, groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        // click On "Bank Manager Login" Tab
        //homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLoginButton();
        //  click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerButton();
        //	enter FirstName
        addCustomerPage.enterFirstName("testing");
        //	enter LastName
        addCustomerPage.enterLastName("account");
        //	enter PostCode
        addCustomerPage.enterPostCode("xx9 0xx");
        //	click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomerButton();
        //	popup display and verify message "Customer added successfully"
        String expectedMessage = "Customer added successfully";
        String actualMessage = addCustomerPage.textFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage, "Actual ,Expected Texts Does Not Match");
        //	click on "ok" button on popup.
        addCustomerPage.clickOkOnAlert();
        addCustomerPage.clickOnHomeButton();

    }

    @Test(priority = 2, groups = {"sanity", "smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        // click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //	click On "Open Account" Tab
        bankManagerLoginPage.clickOnOpenAccountButton();
        //	Search customer that created in first test
        //openAccountPage.selectCustomerJustAddedDropDown("testing account");
        openAccountPage.selectCustomerJustAddedDropDown("testing account");
        //	Select currency "Pound"
        openAccountPage.selectCurrencyDropDown("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcessButton();
        //	popup displayed
        //	verify message "Account created successfully"
        String expectedMessage = "Account created successfully";
        String actualMessage = openAccountPage.textFromAlert();
        Assert.assertEquals(expectedMessage, actualMessage, "Actual,expected texts does not match");
        //	click on "ok" button on popup.
        openAccountPage.clickOkOnAlert();
        openAccountPage.clickOnHomeButton();
    }

    @Test(priority = 3, groups = {"smoke", "regression"})
    public void customerShouldLoginAndLogoutSuccessfully() {
        // click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //	search customer that you created.
        customerLoginPage.selectNameFromDropDownMenu("testing account");
        //	click on "Login" Button
        customerLoginPage.clickLoginButton();
        //	verify "Logout" Tab displayed.
        String expectedMessage = "logout";
        String actualMessage = customersPage.verifyLogoutButton();
        Assert.assertEquals(expectedMessage, actualMessage, "Login Unsuccessfull");
        //	click on "Logout"
        customersPage.clickOnLogoutButton();
        //	verify "Your Name" text displayed.
        String expectedMessage1 = "Your Name";
        String actualMessage1 = customerLoginPage.getYourNameText();
        Assert.assertEquals(expectedMessage1, actualMessage1, "User has not logged out successfully");
        openAccountPage.clickOnHomeButton();
    }

    @Test(priority = 4, groups = {"smoke", "regression"})
    public void customerShouldDepositMoneySuccessfully() {
        //  click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //	search customer that you created.
        customerLoginPage.selectNameFromDropDownMenu("testing account");
        //	click on "Login" Button
        customerLoginPage.clickLoginButton();
        //	click on "Deposit" Tab
        accountPage.clickDepositButton();
        //	Enter amount 100
        accountPage.enterDepositAmount("100");
        //	click on "Deposit" Button
        accountPage.clickSmallDepositButton();
        //	verify message "Deposit Successful"
        String expectedMessage = "Deposit Successful";
        String actualMessage = accountPage.verifyDepositSuccessfulText();
        Assert.assertEquals(expectedMessage, actualMessage, "Actual text does not match expected text");
        accountPage.clickHomeButton();
    }

    @Test(priority = 5, groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        // click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();
        //	search customer that you created.
        customerLoginPage.selectNameFromDropDownMenu("testing account");
        //	click on "Login" Button
        customerLoginPage.clickLoginButton();
        //	click on "Withdrawal" Tab
        accountPage.clickWithdrawalButton();
        //	Enter amount 50
        accountPage.enterWithdrawalAmount("50");
        //	click on "Withdraw" Button
        accountPage.clickSmallWithdrawalButton();
        //	verify message "Transaction Successful"
        String expectedMessage = "Transaction successful";
        String actualMessage = accountPage.verifyWithdrawalSuccessfulText();
        Assert.assertEquals(expectedMessage, actualMessage, "Actual text does not match expected text");
    }
}
