package com.zkdb.selenium.turnovermanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.reimbursement.ReimbursementOpenForm;
import com.zkdb.selenium.reimbursement.RequiredField;
import com.zkdb.selenium.util.ExcelWriter;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;

public class TurnoverManagement {

	//等待方法
    WaitiElementsLoad load = new WaitiElementsLoad();
    //工具类
    static SeleniumUtil util = new SeleniumUtil();
    //日志
    Logger logger =Logger.getLogger(ReimbursementOpenForm.class);
	
	public String  turnoverManagementOpenFrom(WebDriver driver) {
		
		//鼠标模拟
        Actions actions =new Actions(driver);
        //跳转webiframe 验证是否第一次登陆设置在岗状态
        util.verifyOnDuty();
		
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='topbar1']//div[@data-title='人力']");
        driver.findElement(By.xpath("//div[@id='topbar1']//div[@data-title='人力']")).click();
        logger.info("点击人力");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "入职管理");
        driver.findElement(By.linkText("入职管理")).click();
        logger.info("入职管理");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "离职管理");
        driver.findElement(By.linkText("离职管理")).click();
        logger.info("设计离职管理");
        //跳转
        driver.switchTo().frame(2);
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "btnAdd");
        driver.findElement(By.id("btnAdd")).click();
        logger.info("点击添加按钮");
        //记录当前窗口编号
        String handle= driver.getWindowHandle();
        util.switchWindow();
        
        
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        try {
            Thread.sleep(6500);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "sheet_author");
        //双击
        actions.doubleClick(driver.findElement(By.id("sheet_author"))).perform();
        logger.info("双击离职人");
        String userName="林黛玉";
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-header']//input[@placeholder='搜索']");
       
        driver.findElement(By.xpath("//div[@class='modal-header']//input[@placeholder='搜索']")).sendKeys(userName);
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+userName+"')]/../../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+userName+"')]/../../.."))).perform();
        logger.info("选择离职人");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "sheet_org_code");
        actions.doubleClick(driver.findElement(By.id("sheet_org_code"))).perform();
        logger.info("双击离职类型");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "个人离职");
        driver.findElement(By.linkText("个人离职")).click();
        logger.info("选择离职类型");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_date1");
        //点击
        driver.findElement(By.id("a_date1")).click();
        logger.info("点击上班截止日");
        //设置时间格式
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd)");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1); // -设置为上一个月      +为后一个月  0 为本月
        date = calendar.getTime();
        String time = format.format(date);
        //设置时间
        util.keyboardNumberInput(time);
       
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_org_code3");
        actions.doubleClick(driver.findElement(By.id("a_org_code3"))).perform();
        logger.info("双击知会部门");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-dialog']//input[@placeholder='搜索']");
        
        driver.findElement(By.xpath("//div[@class='modal-dialog']//input[@placeholder='搜索']")).sendKeys("财务部");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='seldeptname']//span[contains(text(),'财务部')]/../../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='seldeptname']//span[contains(text(),'财务部')]/../../.."))).perform();
        logger.info("选择财务部");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-dialog']//input[@placeholder='搜索']");
        driver.findElement(By.xpath("//div[@class='modal-dialog']//input[@placeholder='搜索']")).clear();
        driver.findElement(By.xpath("//div[@class='modal-dialog']//input[@placeholder='搜索']")).sendKeys("综合部");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='seldeptname']//span[contains(text(),'综合部')]/../../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='seldeptname']//span[contains(text(),'综合部')]/../../.."))).perform();
        logger.info("选择综合部");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modal')]//div[contains(@class,'modal-footer')]/span[contains(text(),'确定')]");
        driver.findElement(By.xpath("//div[contains(@class,'modal')]//div[contains(@class,'modal-footer')]/span[contains(text(),'确定')]")).click();
        logger.info("点击确定");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "sheet_remalk");
        driver.findElement(By.id("sheet_remalk")).sendKeys("个人原因");
        logger.info("设置离职原因");
        
        
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'离职资料')]");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'离职资料')]")).click();
        logger.info("点击离职资料从表");
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'离职资料')]/span");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'离职资料')]/span")).click();
        logger.info("点击离职资料从表+");
        

        //滚动到页面底部
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        String ZLdataid="44a36dbd-c799-475c-8e2f-9c609647117e";
        String sheet_titlexpth=util.getElementXPath(ZLdataid, "1", "sheet_title");
        logger.info(sheet_titlexpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, sheet_titlexpth);
        driver.findElement(By.xpath(sheet_titlexpth)).click();
        driver.findElement(By.xpath(sheet_titlexpth+"/input")).sendKeys("隐约雷鸣");
        logger.info("资料名称");
        
        String sheet_numberxpth=util.getElementXPath(ZLdataid, "1", "sheet_number");
        logger.info(sheet_numberxpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, sheet_numberxpth);
        actions.doubleClick(driver.findElement(By.xpath(sheet_numberxpth))).perform();
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "纸质");
        driver.findElement(By.linkText("纸质")).click();
        logger.info("形式");
        
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"form_newWfInstance");
      
      try {
          Thread.sleep(2000);
      }
      catch (InterruptedException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
      }
      //点击发起
       driver.findElement(By.id("form_newWfInstance")).click();
       logger.info("点击发起");
      
       //获取表单必填字段
       ArrayList<RequiredField> requiredFields=util.getFormRequiredField();
       // 写入表单信息
       ExcelWriter.inputDataExcel(requiredFields,"D:\\项目立项\\项目立项测试用例.xlsx");
       
       //获取流程事项名称
       String processName= driver.findElement(By.xpath("//div[contains(@class,'modalWorkFlow')]//div[contains(@class,'modal-body')]//div/label[contains(text(), '事项名称')]/../input")).getAttribute("value");
       
     //点击发起
     load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary");
     driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
     logger.info("-----------发起成功------------");

     
     try {
         Thread.sleep(2000);
     }
     catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
     driver.switchTo().window(handle);
     
     //跳转窗体
     load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"webiframe");
     driver.switchTo().frame("webiframe");
     driver.navigate().refresh();
       
	return processName;
	}
}
