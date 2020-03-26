package com.akashi.selenium.tset;

public class seleeniumRunTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ActionSelenium actionSelenium =new ActionSelenium();
        try {
            actionSelenium.InitDriver();
            actionSelenium.Login();
            actionSelenium.LoanManagementTest();
        }
        finally {
            // TODO: handle finally clause
            actionSelenium.CloseBrowser();
        }
        

    }

}
