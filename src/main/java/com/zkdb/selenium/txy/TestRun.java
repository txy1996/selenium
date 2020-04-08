package com.zkdb.selenium.txy;

import com.zkdb.selenium.constant.InitDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * FileName: TestRun
 * Author:   tangxiaoyu
 * Date:     2020/4/8 11:13
 * Description: TODO(这里用一句话描述这个类的作用)
 *
 * @since 1.0.0
 */
public class TestRun {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Logger logger = Logger.getLogger(TestRun.class);
        //初始化
        try {
            AdditionalProjectPhase projectPhase =new AdditionalProjectPhase();
            projectPhase.login();
            projectPhase.LocateModule();
            projectPhase.addBusinessData();
            projectPhase.writeFormData();
        }
        catch (Exception e){

            logger.info(e.toString());
            //错误截图
            //SeleniumUtil.runExceptionScreenshot(driver);
        }
        finally {
            WebDriver driver=InitDriver.getDriver();
            driver.quit();
        }



    }
}