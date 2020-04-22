package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.resources.testdata.TestData;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static com.bank.utility.Utility.getRandomNumber;

public class BankTest extends TestBase {

    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    HomePage homePage;
    OpenAccountPage openAccountPage;

    //static variable
    static String firstName = null;

    @BeforeTest(groups = {"Regression"})
    public void setUp() {
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        homePage = new HomePage();
        openAccountPage = new OpenAccountPage();

        firstName = "Severus" + getRandomNumber(2);
    }

    /*
     * Test 01 - bankManagerShouldAddCustomerSuccessfully.
     */
    @Test(priority = 0, groups = {"Regression"}, dataProvider = "AddCustomer", dataProviderClass = TestData.class)
    public void bankManagerShouldAddCustomerSuccessfully(String lastName, String postCode, String popUpText) {
//    click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginTab();
//    click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerTab();
//    enter FirstName
        addCustomerPage.enterFirstName(firstName);
//    enter LastName
        addCustomerPage.enterLastName(lastName);
//    enter PostCode
        addCustomerPage.enterPostCode(postCode);
//    click On "Add Customer" Button
//    popup display
//    verify message "Customer added successfully"
//    click on "ok" button on popup.
        addCustomerPage.clickOnAddCustomerButton(popUpText);
    }


    /*
     * Test 02 -  bankManagerShouldOpenAccountSuccessfully.
     */
    @Test(priority = 1, groups = {"Regression"}, dataProvider = "OpenAccount", dataProviderClass = TestData.class)
    public void bankManagerShouldOpenAccountSuccessfully(String lastName, String popUpText) {
        homePage.clickOnHomeButton();
//    click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginTab();
//    click On "Open Account" Tab
        bankManagerLoginPage.clickOnOpenAccountTab();
//    Search customer that created in first test
        openAccountPage.searchCustomerCreatedInFirstTest(firstName + " " + lastName);
//    Select currency "Pound"
        openAccountPage.selectCurrencyPound(2);
//    click on "process" button
//    popup displayed
//    verify message "Account created successfully"
//    click on "ok" button on popup.
        openAccountPage.clickOnProcessButton(popUpText);
    }

    /*
     * Test 03-customerShouldLoginAndLogoutSuceessfully .
     */
    @Test(priority = 2, groups = {"Regression"}, dataProvider = "LoginLogout", dataProviderClass = TestData.class)

    public void customerShouldLoginAndLogoutSuccessfully(String lastName, String logoutText, String yourNameText) {
        homePage.clickOnHomeButton();
//    click on "Customer Login" Tab
        homePage.clickOnCustomerLoginTab();
//    search customer that you created.
        customerLoginPage.searchCustomer(firstName + " " + lastName);
//    click on "Login" Button
        customerLoginPage.clickOnLoginButton();
//    verify "Logout" Tab displayed.
        accountPage.verifyLogoutTabDisplayed(logoutText);
//    click on "Logout"
        accountPage.clickOnLogout();
//    verify "Your Name" text displayed.
        customerLoginPage.verifyYourNameTextDisplayed(yourNameText);
    }

    /*
     * Test 04-customerShouldDepositMoneySuccessfully .
     */
    @Test(priority = 3, groups = {"Regression"}, dataProvider = "DepositMoney", dataProviderClass = TestData.class)

    public void customerShouldDepositMoneySuccessfully(String lastName, String depositAmount, String depositSuccessText) {
        homePage.clickOnHomeButton();
//    click on "Customer Login" Tab
        homePage.clickOnCustomerLoginTab();
//    search customer that you created.
        customerLoginPage.searchCustomer(firstName + " " + lastName);
//    click on "Login" Button
        customerLoginPage.clickOnLoginButton();
//    click on "Deposit" Tab
        accountPage.clickOnDepositTab();
//    Enter amount 100
        accountPage.enterAmount(depositAmount);
//    click on "Deposit" Button
        accountPage.clickOnDepositButton();
//    verify message "Deposit Successful"
        accountPage.verifyMessageDepositSuccessful(depositSuccessText);
    }

    /*
     * Test 05-customerShouldWithdrawMoneySuccessfully .
     */
    @Test(priority = 4, groups = {"Regression"}, dataProvider = "WithdrawMoney", dataProviderClass = TestData.class)

    public void customerShouldWithdrawMoneySuccessfully(String lastName, String withdrawAmount, String transactionSuccessful) {
        homePage.clickOnHomeButton();
//    click on "Customer Login" Tab
        homePage.clickOnCustomerLoginTab();
//    search customer that you created.
        customerLoginPage.searchCustomer(firstName + " " + lastName);
//    click on "Login" Button
        customerLoginPage.clickOnLoginButton();
//    click on "Withdrawl" Tab
        accountPage.clickOnWithdrawlTab();
//    Enter amount 50
        accountPage.enterAmount(withdrawAmount);
//    click on "Withdraw" Button
        accountPage.clickOnWithdrawButton();
//    verify message "Transaction Successful"
        accountPage.verifyMessageTransactionSuccessful(transactionSuccessful);
    }

    /*
     * Test 06-bankManagerShouldDeleteCustomerSuccessfully .
     */
    @Test(priority = 5, groups = {"Regression"})

    public void bankManagerShouldDeleteCustomerSuccessfully() {
        homePage.clickOnHomeButton();
//   click on Bank Manager Login Tab
        homePage.clickOnBankManagerLoginTab();
//    click on Customers Tab
        bankManagerLoginPage.clickOnCustomersTab();
//    search customer by firstname
        customersPage.searchCustomerName(firstName);
//    click on Delete button.
        customersPage.clickOnDeleteButton();
    }

}
