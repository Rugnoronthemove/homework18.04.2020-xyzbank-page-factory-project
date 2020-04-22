package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());


    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement _bankManagerLogin;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement _customerLogin;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement _homeBtn;


    public void clickOnHomeButton() {
        Reporter.log(" Click on Home button: " + _homeBtn.toString() + "<br>");
        waitUntilElementToBeClickable(_homeBtn, 20);
        clickOnElement(_homeBtn);
        log.info(" Click on Home button: " + _homeBtn.toString());
    }

    public void clickOnBankManagerLoginTab() {
        Reporter.log(" Click on BankManagerLogin tab: " + _bankManagerLogin.toString() + "<br>");
        waitUntilElementToBeClickable(_bankManagerLogin, 20);
        clickOnElement(_bankManagerLogin);
        log.info(" Click on BankManagerLogin tab: " + _bankManagerLogin.toString());
    }

    public void clickOnCustomerLoginTab() {
        Reporter.log(" Click on CustomerLogin tab: " + _customerLogin.toString() + "<br>");
        waitUntilElementToBeClickable(_customerLogin, 20);
        clickOnElement(_customerLogin);
        log.info(" Click on CustomerLogin tab: " + _customerLogin.toString());
    }

}
