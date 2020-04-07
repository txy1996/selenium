package com.zkdb.selenium.administrative;

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

public class PostManagementRun {

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
        WebDriver driver =InitDriver.getDriver();
        //调用登录
        Login login = new Login();

        
        //使用账号登录
        login.loginAccount(driver, userDate.get(0).getOrguid(), userDate.get(0).getUserName(), userDate.get(0).getPassWord());
        logger.info("登陆账号:"+userDate.get(0).getUserName());
        try {
            //填写表单
           PostManagementTest pManagementTest =new PostManagementTest();
            //返回流程事项名称
            String processName = pManagementTest.PostManagement(driver);
            //等待页面加载
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //删除集合中前两位的数据
            for(int i=0;i<1;i++) {
                userDate.remove(0);
            }
            ProcessForwarding processForwarding = new ProcessForwarding();
            
            //循环预设的账号,进行流程批转
            for (UserAccountVO userAccountVO : userDate) {
                
                login.loginTestAccount(driver, userAccountVO.getOrguid(), userAccountVO.getUserName(), userAccountVO.getPassWord());
                logger.info(userAccountVO.getUserName());
                processForwarding.processOperation(driver, processName);
            }
   
        }catch (Exception e){
            
            logger.info(e.toString());
            //错误截图
            SeleniumUtil.runExceptionScreenshot();
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
