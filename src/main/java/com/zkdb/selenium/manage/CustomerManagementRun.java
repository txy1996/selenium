package com.zkdb.selenium.manage;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zkdb.selenium.constant.InitDriver;
import com.zkdb.selenium.reimbursement.ProcessForwarding;
import com.zkdb.selenium.reimbursement.ReimbursementRun;
import com.zkdb.selenium.tset.DesignProject;
import com.zkdb.selenium.util.Login;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.vo.UserAccountVO;

public class CustomerManagementRun {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        run();
    }

    public static void run() {
        Logger logger =Logger.getLogger(ReimbursementRun.class);
        //读取配置文件 (预设账号)
        String excelFileName ="D:\\项目立项\\UserAccountVO.xlsx";
        UserAccountVO user =new UserAccountVO();
        ArrayList<UserAccountVO> userDate=  (ArrayList<UserAccountVO>) SeleniumUtil.getExcelDate(excelFileName,user);
        //初始化 
        WebDriver driver =InitDriver.INSTANCE.getDriver();
        //调用登录
        Login login = new Login();
        //使用预设的账号数据登录
//        login.loginDevelopmentAccount(driver, userDate.get(0).getUserName(), userDate.get(0).getPassWord());
//        logger.info("登陆开发者账号:"+userDate.get(0).getUserName());
//        try {
//            Thread.sleep(2000);
//        }
//        catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        //使用账号登录
//        login.loginAccount(driver, userDate.get(0).getOrguid(), userDate.get(0).getUserName(), userDate.get(0).getPassWord());
//        logger.info("登陆账号:"+userDate.get(0).getUserName());
        
        login.loginAccount(driver, "fep", "1005118", "888888");
        logger.info("登陆账号:"+"1005118");
        
        try {
            //填写费用报销表单
            CustomerManagementTest rManagementRun= new CustomerManagementTest();
            //返回流程事项名称
            rManagementRun.customerManagementFillInForm(driver);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


   
        }catch (Exception e){
            
            logger.info(e.toString());
            //错误截图
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
