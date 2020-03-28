package com.zkdb.selenium.reimbursement;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zkdb.selenium.util.InitDriver;
import com.zkdb.selenium.util.Login;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.vo.UserAccountVO;

public class ReimbursementRun {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        run();
    }
       public static void run() {
        Logger logger =Logger.getLogger(ReimbursementRun.class);
        //读取文件
        String excelFileName ="D:\\费用报销模块\\UserAccountVO.xlsx";
        UserAccountVO user =new UserAccountVO();
        ArrayList<UserAccountVO> userDate=  (ArrayList<UserAccountVO>) SeleniumUtil.getExcelDate(excelFileName,user);
        //初始化 
        WebDriver driver =InitDriver.INSTANCE.getDriver();
        //调用登录
        Login login = new Login();
        login.loginDevelopmentAccount(driver, userDate.get(0).getUserName(), userDate.get(0).getPassWord());
        logger.info("登陆开发者账号:"+userDate.get(0).getUserName());
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        login.loginTestAccount(driver, userDate.get(1).getOrguid(), userDate.get(1).getUserName(), userDate.get(1).getPassWord());
        logger.info("登陆账号:"+userDate.get(1).getUserName());
        try {
            //填写费用报销表单
            ReimbursementOpenForm openForm =new ReimbursementOpenForm();
            //返回流程事项名称
            String processName = openForm.reimbursementPositioningExpenses(driver);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //删除集合中前两位的数据
            for(int i=0;i<2;i++) {
                userDate.remove(0);
            }
            ProcessForwarding processForwarding = new ProcessForwarding();
            
            //循环预设的账号
            for (UserAccountVO userAccountVO : userDate) {
                
                login.loginTestAccount(driver, userAccountVO.getOrguid(), userAccountVO.getUserName(), userAccountVO.getPassWord());
                logger.info(userAccountVO.getUserName());
                processForwarding.processOperation(driver, processName);
            }
   
        }catch (Exception e){
            System.out.println(e.toString());
            
            SeleniumUtil.runExceptionScreenshot(driver);
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
