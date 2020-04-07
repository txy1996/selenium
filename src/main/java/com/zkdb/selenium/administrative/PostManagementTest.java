package com.zkdb.selenium.administrative;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.reimbursement.ReimbursementOpenForm;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;

/**
 * 
 * @ClassName: PostManagementTest 
 * @Description: TODO(发文管理) 
 * @author wxf 
 * @date 2020年4月3日 上午10:53:48 
 *
 */
public class PostManagementTest {
    
    
  //等待方法
    WaitiElementsLoad load = new WaitiElementsLoad();
    //工具类
    static SeleniumUtil util = new SeleniumUtil();
    //日志
    Logger logger =Logger.getLogger(ReimbursementOpenForm.class);
    
    /**
     * 
     * @Title: PostManagement 
     * @Description: TODO(打开表单填写数据) 
     * @param driver
     * @return
     */
    public String  PostManagement(WebDriver driver) {
        
      //鼠标模拟
        Actions actions =new Actions(driver);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "webiframe");
        //窗口跳转
        driver.switchTo().frame("webiframe");
        logger.info("跳转到webiframe");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//*[@id='topbar1']//div//span[contains(text(),'行政')]");
        driver.findElement(By.xpath("//*[@id='topbar1']//div//span[contains(text(),'行政')]")).click();
        logger.info("点击行政");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "行政事务");
        driver.findElement(By.linkText("行政事务")).click();
        logger.info("行政事务");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "发文管理");
        driver.findElement(By.linkText("发文管理")).click();
        logger.info("发文管理");
        
        //
        driver.switchTo().frame(2);
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "btnAdd");
        driver.findElement(By.id("btnAdd")).click();
        logger.info("点击添加按钮");
        //获取当前窗口
        String handle= driver.getWindowHandle();
        //调用切换窗口的方法
        util.switchWindow();
        
        
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        try {
            Thread.sleep(6500);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return null;
    }
}
