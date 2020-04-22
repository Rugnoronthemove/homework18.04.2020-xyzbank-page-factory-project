package com.bank.resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "AddCustomer")
    //method returning two dimensional object
    public Object[][] getDataAddCustomer() {
        //creating object of two dimensional Object[][]
        return new Object[][]{
            //adding data set to two dimensional Object[][]
                {"Snape", "HG3 14WB","Customer added successfully"}

        };
    }

    @DataProvider(name = "OpenAccount")
    //method returning two dimensional object
    public Object[][] getDataOpenAccount() {
        //creating object of two dimensional Object[][]
        return new Object[][]{
                //adding data set to two dimensional Object[][]
                {"Snape", "Account created successfully"}

        };
    }

    @DataProvider(name = "LoginLogout")
    //method returning two dimensional object
    public Object[][] getDataLoginLogout() {
        //creating object of two dimensional Object[][]
        return new Object[][]{
                //adding data set to two dimensional Object[][]
                {"Snape", "Logout", "Your Name :"}

        };
    }

    @DataProvider(name = "DepositMoney")
    //method returning two dimensional object
    public Object[][] getDataDepositMoney() {
        //creating object of two dimensional Object[][]
        return new Object[][]{
                //adding data set to two dimensional Object[][]
                {"Snape", "100", "Deposit Successful"}

        };
    }

    @DataProvider(name = "WithdrawMoney")
    //method returning two dimensional object
    public Object[][] getDataWithdrawMoney() {
        //creating object of two dimensional Object[][]
        return new Object[][]{
                //adding data set to two dimensional Object[][]
                {"Snape", "50", "Transaction successful"}

        };
    }


}
