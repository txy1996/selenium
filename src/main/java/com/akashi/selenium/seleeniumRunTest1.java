package com.akashi.selenium;



public class seleeniumRunTest1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        seleniumTest1 seleniumTest1 =new seleniumTest1();
        try {
//            seleniumTest1.InitDriver();
            seleniumTest1.Login();
            seleniumTest1.LoanManagementTest();
        }
        finally {
            // TODO: handle finally clause
            seleniumTest1.CloseBrowser();
        }
    }

}
