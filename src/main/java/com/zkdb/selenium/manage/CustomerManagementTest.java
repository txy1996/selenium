package com.zkdb.selenium.manage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.reimbursement.ReimbursementOpenForm;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;

public class CustomerManagementTest {

    //等待方法
    WaitiElementsLoad load = new WaitiElementsLoad();
    //工具类
    static SeleniumUtil util = new SeleniumUtil();
    //日志
    Logger logger =Logger.getLogger(ReimbursementOpenForm.class);
    
    public void customerManagementFillInForm(WebDriver driver) {
        
        //鼠标模拟
        Actions actions =new Actions(driver);

        
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//*[@id='topbar1']/div//span[contains(text(),'经营')]");
        driver.findElement(By.xpath("//*[@id='topbar1']/div//span[contains(text(),'经营')]")).click();
        logger.info("点击经营");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//*[@id='module_navs']//div/ul//li/ul/li/div/a[@data-moduleid='1c430119-08a7-4df2-8c21-6bbc2c158dcf']");
        driver.findElement(By.xpath("//*[@id='module_navs']//div/ul//li/ul/li/div/a[@data-moduleid='1c430119-08a7-4df2-8c21-6bbc2c158dcf']")).click();
        logger.info("点击客户管理分组");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//*[@id='module_navs']//div/ul//li/ul/li/div/a[@data-moduleid='6d852fcc-2fba-4146-b626-f87a09b36389']");
        driver.findElement(By.xpath("//*[@id='module_navs']//div/ul//li/ul/li/div/a[@data-moduleid='6d852fcc-2fba-4146-b626-f87a09b36389']")).click();
        logger.info("点击客户模块");
        
        //跳转
        driver.switchTo().frame(2);
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "btnAdd");
        driver.findElement(By.id("btnAdd")).click();
        logger.info("点击添加按钮");
        
        String handle= driver.getWindowHandle();
        util.switchWindow(driver);
    }
}
