package com.zkdb.selenium.cyf;

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
import com.zkdb.selenium.vo.RequiredField;
import com.zkdb.selenium.util.ExcelWriter;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;

public class BussTravel {
	//等待方法
    WaitiElementsLoad load = new WaitiElementsLoad();
    //工具类
    static SeleniumUtil util = new SeleniumUtil();
    //日志
    Logger logger =Logger.getLogger(ReimbursementOpenForm.class);
	
    public String  bussTravelOpenFrom(WebDriver driver) {
    	//鼠标模拟
        Actions actions =new Actions(driver);
        //跳转webiframe 验证是否第一次登陆设置在岗状态
        util.verifyOnDuty();
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='topbar1']//div[@data-title='人力']");
        driver.findElement(By.xpath("//div[@id='topbar1']//div[@data-title='人力']")).click();
        logger.info("点击人力");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "考勤管理");
        driver.findElement(By.linkText("考勤管理")).click();
        logger.info("考勤管理");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "出差管理");
        driver.findElement(By.linkText("出差管理")).click();
        logger.info("出差管理");
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
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_id");
        actions.doubleClick(driver.findElement(By.id("proj_id"))).perform();
        logger.info("双击出差项目");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[contains(@class,'advfilter')]//div//div/input[@data-field='proj_name']");
        driver.findElement(By.xpath("//div[contains(@class,'advfilter')]//div//div/input[@data-field='proj_name']")).sendKeys("追加立项策划测试");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modal-header')]//div[contains(@class,'fixed-table-toolbar')]//ul//li[@class='btn-group']//button[contains(.,'搜索')]");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[contains(@class,'modal-header')]//div[contains(@class,'fixed-table-toolbar')]//ul//li[@class='btn-group']//button[contains(.,'搜索')]")).click();
       // driver.findElement(By.xpath("//div[contains(@class,'modal-header')]//div[contains(@class,'fixed-table-toolbar')]//ul//li[@class='btn-group']//button[contains(.,'搜索')]")).click();
        logger.info("点击搜索");
        
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, "//tbody//tr//td[@data-field='proj_name' and contains(text(),'追加立项策划测试')]");
        actions.doubleClick(driver.findElement(By.xpath("//tbody//tr//td[@data-field='proj_name' and contains(text(),'追加立项策划测试')]"))).perform();
        logger.info("双击选择");
        
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "sheet_content");
        actions.doubleClick(driver.findElement(By.id("sheet_content"))).perform();
        logger.info("双击出差事由");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "项目出差");
        driver.findElement(By.linkText("项目出差")).click();
        logger.info("选择出差事由");
        
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_org_code2");
        //双击
        actions.doubleClick(driver.findElement(By.id("a_org_code2"))).perform();
        logger.info("双击同行人");
        String userName="袭人";
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-body']//div[@class='fixed-table-toolbar']//div[@class='pull-right search client-search']//input[@placeholder='搜索']");
       
        driver.findElement(By.xpath("//div[@class='modal-body']//div[@class='fixed-table-toolbar']//div[@class='pull-right search client-search']//input[@placeholder='搜索']")).sendKeys(userName);
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+userName+"')]/../../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+userName+"')]/../../.."))).perform();
        logger.info("选择同行人");
        
        String userName2="张辽";
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-body']//div[@class='fixed-table-toolbar']//div[@class='pull-right search client-search']//input[@placeholder='搜索']");
        driver.findElement(By.xpath("//div[@class='modal-body']//div[@class='fixed-table-toolbar']//div[@class='pull-right search client-search']//input[@placeholder='搜索']")).clear();
        driver.findElement(By.xpath("//div[@class='modal-body']//div[@class='fixed-table-toolbar']//div[@class='pull-right search client-search']//input[@placeholder='搜索']")).sendKeys(userName2);
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+userName2+"')]/../../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+userName2+"')]/../../.."))).perform();
        logger.info("选择同行人");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modal')]//div[contains(@class,'modal-footer')]/span[contains(text(),'确定')]");
        driver.findElement(By.xpath("//div[contains(@class,'modal')]//div[contains(@class,'modal-footer')]/span[contains(text(),'确定')]")).click();
        logger.info("点击确定");
        
        
      //设置时间格式
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1); 
        date = calendar.getTime();
        String time = format.format(date);
        
        
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 7); 
        date = calendar.getTime();
        String time2 = format.format(date);
        
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_date1");
        driver.findElement(By.id("a_date1")).sendKeys(time);
        logger.info("设置请假开始时间");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_date2");
        driver.findElement(By.id("a_date2")).click();
        driver.findElement(By.id("a_date2")).sendKeys(time2);
        logger.info("设置请假结束");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "sheet_remalk");
        driver.findElement(By.id("sheet_remalk")).click();
        driver.findElement(By.id("sheet_remalk")).sendKeys("因项目客户需要，需要去现场进行技术支持和售后培训一周！");
        logger.info("设置备注");
        
        
        //从表数据的处理
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'交通工具情况')]");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'交通工具情况')]")).click();
        logger.info("点击交通工具从表");
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'交通工具情况')]/span");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'交通工具情况')]/span")).click();
        logger.info("点击交通工具从表+");
        

        //滚动到页面底部
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        String Detaildataid="0c27ddca-7f40-42bf-ae26-58a24aa20a67";
       
        //设置出差项目
        String proj_idxpth=util.getElementXPath(Detaildataid, "1", "proj_id");
        logger.info(proj_idxpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, proj_idxpth);
        actions.doubleClick(driver.findElement(By.xpath(proj_idxpth))).perform();
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='proj_name' and contains(text(),'追加立项策划测试')]");
        driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='proj_name' and contains(text(),'追加立项策划测试')]"));
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='proj_name' and contains(text(),'追加立项策划测试')]"))).perform();
        logger.info("出差项目");
        
        //交通工具
        String a_org_code2xpth=util.getElementXPath(Detaildataid, "1", "a_org_code2");
        logger.info(a_org_code2xpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, a_org_code2xpth);
        actions.doubleClick(driver.findElement(By.xpath(a_org_code2xpth))).perform();
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "火车");
        driver.findElement(By.linkText("火车")).click();
        logger.info("交通工具");
        

        
        
        //出发时间
        String sheet_datexpth=util.getElementXPath(Detaildataid, "1", "sheet_date");
        logger.info(sheet_datexpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, sheet_datexpth);
        actions.doubleClick(driver.findElement(By.xpath(sheet_datexpth))).perform();
        driver.findElement(By.xpath(sheet_datexpth)).click();
        driver.findElement(By.xpath(sheet_datexpth+"/div/input")).sendKeys(time);
        logger.info("出发时间");



      //设置出发地
        String sheet_contentxpth=util.getElementXPath(Detaildataid, "1", "sheet_content");
        logger.info(sheet_contentxpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, sheet_contentxpth);
        driver.findElement(By.xpath(sheet_contentxpth)).click();
        driver.findElement(By.xpath(sheet_contentxpth+"/input")).sendKeys("北京");
        logger.info("出发地");
       

      //设置目的地
        String a_text1xpth=util.getElementXPath(Detaildataid, "1", "a_text1");
        logger.info(a_text1xpth);
        
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, a_text1xpth);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",driver.findElement(By.xpath(a_text1xpth)));
       
        driver.findElement(By.xpath(a_text1xpth)).click();
        driver.findElement(By.xpath(a_text1xpth+"/input")).sendKeys("南京");
        logger.info("目的地");
        
        
        //设置备注
        String sheet_remalkxpth=util.getElementXPath(Detaildataid, "1", "sheet_remalk");
        logger.info(sheet_remalkxpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, sheet_remalkxpth);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",driver.findElement(By.xpath(sheet_remalkxpth)));
        //driver.findElement(By.xpath(sheet_remalkxpth)).click();
        driver.findElement(By.xpath(sheet_remalkxpth+"/input")).sendKeys("南京");
        logger.info("备注");

        
       
     
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
      ExcelWriter.inputDataExcel(requiredFields,"D:\\Excel\\人力招聘申请.xlsx");
      
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
 
 	 //return null;
    }
}
