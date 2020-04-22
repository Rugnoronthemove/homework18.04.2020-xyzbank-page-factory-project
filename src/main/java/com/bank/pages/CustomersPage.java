package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomersPage extends Utility {

    private static final Logger log = LogManager.getLogger(CustomersPage.class.getName());

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement _searchCustomerField;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement _deleteBtn;

    public void searchCustomerName(String custName) {
        Reporter.log(" Seacrch CustomerName: " + custName + " in the field " + _searchCustomerField.toString() + "<br>");
        waitUntilElementToBeClickable(_searchCustomerField, 20);
        sendTextToElement(_searchCustomerField, custName);
        log.info(" Seacrch CustomerName: " + custName + " in the field " + _searchCustomerField.toString());

    }

    public void clickOnDeleteButton() {
        Reporter.log(" Click on Deleter button: " + _deleteBtn.toString() + "<br>");
        waitUntilElementToBeClickable(_deleteBtn, 20);
        clickOnElement(_deleteBtn);
        log.info(" Click on Deleter button: " + _deleteBtn.toString());
    }

}
