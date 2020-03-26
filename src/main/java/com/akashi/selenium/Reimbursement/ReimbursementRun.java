package com.akashi.selenium.Reimbursement;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReimbursementRun {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String url ="http://epplus.cn/d/signin_test.jsp";
        WebDriver driver =InitDriver.INSTANCE.getDriver(url);
        
        Login login = new Login();
        login.loginDevelopmentAccount(driver, "15882891378", "888888");
     
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        login.loginTestAccount(driver, "BEP", "241", "11111111");
        try {
            ReimbursementOpenForm openForm =new ReimbursementOpenForm();
            String processName = openForm.reimbursementPositioningExpenses(driver);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            
            login.loginTestAccount(driver, "BEP", "1005118", "11111111");
            ProcessForwarding processForwarding = new ProcessForwarding();
            processForwarding.processOperation(driver, processName);

            

            
            login.loginTestAccount(driver, "BEP", "1008483", "11111111");
            processForwarding.processOperation(driver, processName);
            

            

            
            login.loginTestAccount(driver, "BEP", "1005118", "11111111");
            
            processForwarding.processOperation(driver, processName);
            

            

            
            login.loginTestAccount(driver, "BEP", "1008482", "11111111");
            
            processForwarding.processOperation(driver, processName);
            
            login.loginTestAccount(driver, "BEP", "1008484", "11111111");
            
            processForwarding.processOperation(driver, processName);
            //复核银行汇款
            login.loginTestAccount(driver, "BEP", "1005118", "11111111");
            
            processForwarding.processOperation(driver, processName);
            //driver.get(url);
        }catch (Exception e){
            System.out.println(e.toString());
            long date =System.currentTimeMillis();
            String path =String.valueOf(date);
            String curPath = System.getProperty("user.dir");
            path =path+".png";
            String scrrrnPath = curPath+"/"+path;
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile,new File(scrrrnPath));
            } catch (IOException io) {
                e.printStackTrace();
            }
        }
        finally {
            // TODO: handle finally clause
            try {
                Thread.sleep(6200);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            driver.quit();
        }
        
    }

}
