package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(CustomerLoginPage.class.getName());

    @FindBy(id = "userSelect")
    WebElement _yourNameField;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement _loginBtn;

    @FindBy(xpath = "//label[contains(text(),'Your Name')]")
    WebElement _yourNameText;


    public void searchCustomer(String srchCust) {
        Reporter.log(" Search customer: " + _yourNameField.toString() + "<br>");
        waitUntilElementToBeClickable(_yourNameField, 20);
        selectByVisibleTextFromDropDown(_yourNameField, srchCust);
        log.info(" Search customer: " + _yourNameField.toString());
    }

    public void clickOnLoginButton() {
        Reporter.log(" Search customer: " + _yourNameField.toString() + "<br>");
        waitUntilElementToBeClickable(_loginBtn, 20);
        clickOnElement(_loginBtn);
        log.info(" Search customer: " + _yourNameField.toString());
    }

    public void verifyYourNameTextDisplayed(String yourName) {
        Reporter.log(" Verify your name: " + yourName + " is displayed " + _yourNameText.toString() + "<br>");
        waitUntilElementToBeClickable(_yourNameText, 20);
        verifyTextAssertMethod(_yourNameText, yourName);
        log.info(" Verify your name: " + yourName + " is displayed " + _yourNameText.toString());
    }

}
