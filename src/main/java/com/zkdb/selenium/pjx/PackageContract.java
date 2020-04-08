package com.zkdb.selenium.pjx;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.vo.RequiredField;
import com.zkdb.selenium.util.ExcelWriter;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.SimulationFileUpload;
import com.zkdb.selenium.util.WaitiElementsLoad;

public class PackageContract {

	//等待方法
    WaitiElementsLoad load = new WaitiElementsLoad();
    //工具类
    static SeleniumUtil util = new SeleniumUtil();
    //日志
    Logger logger =Logger.getLogger(PackageContract.class);
    /**
     * 
     * @Title: designProjectPositioningExpenses 
     * @Description: TODO(填写测试客户) 
     * @param driver
     * @return  流程事项名称
     */
    @SuppressWarnings("static-access")
    public String PackageContractPositioningExpenses(WebDriver driver) {
        
//        String url = "D:\\文档\\公司文件\\自动化测试用例\\部件化测试\\部件客户测试用例.xlsx";
//        @SuppressWarnings("static-access")
//        Map<String, String[]>  valueMap=util.getEncapsulationFormData(url);
//        if(valueMap==null) {
//            logger.info("文件不存在,转换输入模式");
//        }
        
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
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='topbar1']//div[@data-title='测试部件']");
        driver.findElement(By.xpath("//div[@id='topbar1']//div[@data-title='测试部件']")).click();
        logger.info("点击测试部件");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "程序测试");
        driver.findElement(By.linkText("程序测试")).click();
        logger.info("程序测试");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "合同审批");
        driver.findElement(By.linkText("合同审批")).click();
        logger.info("合同审批");
        //跳转
        driver.switchTo().frame(1);
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "btnAdd");
        driver.findElement(By.id("btnAdd")).click();
        logger.info("点击添加按钮");
        
        String handle= driver.getWindowHandle();
        util.switchWindow();
        
        
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        
        
        
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "contractname");
        driver.findElement(By.id("contractname")).sendKeys("测试部件合同名称");
        logger.info("设置客户合同");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "manager");
        //双击
        actions.doubleClick(driver.findElement(By.id("manager"))).perform();
        logger.info("双击负责人");
        String userName="曹操";
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-header']//input[@placeholder='搜索']");
        driver.findElement(By.xpath("//div[@class='modal-header']//input[@placeholder='搜索']")).sendKeys(userName);
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+userName+"')]/../../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+userName+"')]/../../.."))).perform();
        logger.info("选择负责人");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "signdate");
        //点击
        driver.findElement(By.id("signdate")).click();
        logger.info("点击签订日期");
        //设置时间格式
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd)");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 0); // -设置为上一个月      +为后一个月  0 为本月
        date = calendar.getTime();
        String time = format.format(date);
        //设置时间
        util.keyboardNumberInput(time);

        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "businesstype");
        actions.doubleClick(driver.findElement(By.id("businesstype"))).perform();
        logger.info("所属板块");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "设计业");
        driver.findElement(By.linkText("设计业")).click();
        logger.info("选择项目性质");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "建筑业");
        driver.findElement(By.linkText("建筑业")).click();
        logger.info("选择项目性质");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//body//ul//li[contains(@class,'btn-dicok')]/a[contains(@class,'btn')]");
        List<WebElement> elements =driver.findElements(By.xpath("//body//ul//li[contains(@class,'btn-dicok')]/a[contains(@class,'btn')]"));
        for (WebElement webElement : elements) {
			if (webElement.isDisplayed()) {
				webElement.click();
				logger.info("点击确定");
			}
		}
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "contractmoney");
        driver.findElement(By.id("contractmoney")).sendKeys("90000.58");
        logger.info("设置合同额");
         
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "startdate");
        //点击
        driver.findElement(By.id("startdate")).click();
        logger.info("点击开始日期");

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 0); // -设置为上一个月      +为后一个月  0 为本月
        date = calendar.getTime();
        String startdate = format.format(date);
        util.keyboardNumberInput(startdate);

        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "endate");
        //点击
        driver.findElement(By.id("endate")).click();
        logger.info("点击结束日期");
        //设置时间格式
         calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1); // -设置为上一个月      +为后一个月  0 为本月
        date = calendar.getTime();
        String endate = format.format(date);
        util.keyboardNumberInput(endate);

        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "signaddress");
        driver.findElement(By.id("signaddress")).sendKeys("合同签订地址");
        logger.info("设置签订地址");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "projectaddress");
        driver.findElement(By.id("projectaddress")).sendKeys("合同项目地址");
        logger.info("设置项目地址");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_ID,"customer");
        //鼠标模拟双击
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "customer");
        actions.doubleClick(driver.findElement(By.id("customer"))).perform();
        logger.info("客户");
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//body//div[contains(@class,'modal-header')]/div[contains(@class,'fixed-table-toolbar')]/ul//li//button[@data-toggle='dropdown']");
        driver.findElement(By.xpath("//body//div[contains(@class,'modal-header')]/div[contains(@class,'fixed-table-toolbar')]/ul//li//button[@data-toggle='dropdown']")).click();
        logger.info("选择高级搜索");
	
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "高级搜索");
        driver.findElement(By.linkText("高级搜索")).click();
        logger.info("点击");
              
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@class='advfilter']//div//div/input[@data-field='customcode']");
        driver.findElement(By.xpath("//div[@class='advfilter']//div//div/input[@data-field='customcode']")).sendKeys("测客200072");
        logger.info("选择客户编号");
       
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@class='advfilter']//div//button[contains(text(),'查询')]");
        driver.findElement(By.xpath("//div[@class='advfilter']//div//button[contains(text(),'查询')]")).click();
        logger.info("查询");
               
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, "//tbody//tr/td/span[contains(text(),'所在区域')]");
        actions.doubleClick(driver.findElement(By.xpath("//tbody//tr/td/span[contains(text(),'所在区域')]"))).perform();
        logger.info("所在区域");
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, "//tbody//tr//td[@data-field='customcode' and contains(text(),'测客200072')]");
        actions.doubleClick(driver.findElement(By.xpath("//tbody//tr//td[@data-field='customcode' and contains(text(),'测客200072')]"))).perform();
        logger.info("双击选择");
        
        
        //滚动到页面底部
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        //明细
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收费项')]");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收费项')]")).click();
        logger.info("点击收费项从表");
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收费项')]/span");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收费项')]/span")).click();
        logger.info("点击收费项从表+");
         /*
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"/html/body//ul//li[@class='ez-detail-new']");
        driver.findElement(By.xpath("/html/body//ul//li[@class='ez-detail-new']")).click();
        logger.info("点击添加");
        */


        
        String FWXdataid="a7594a13-ce79-462e-8c7e-8e2b7ef5eefa";
        String serviceitemxpth=util.getElementXPath(FWXdataid, "1", "serviceitem");
        logger.info(serviceitemxpth);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, serviceitemxpth);
        driver.findElement(By.xpath(serviceitemxpth)).click();
        driver.findElement(By.xpath(serviceitemxpth+"/input")).sendKeys("服务项");
        logger.info("输入服务项");
        

        String itemnumberxpth=util.getElementXPath(FWXdataid, "1", "itemnumber");
        logger.info(itemnumberxpth);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, itemnumberxpth);
        driver.findElement(By.xpath(itemnumberxpth)).click();
        util.keyboardNumberInput("1");
        logger.info("数量");
        
        String unitpricexpth=util.getElementXPath(FWXdataid, "1", "unitprice");
        logger.info(unitpricexpth);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, unitpricexpth);
        driver.findElement(By.xpath(unitpricexpth)).click();
        util.keyboardNumberInput("999.96");
        logger.info("单价");
        
  
        //添加从表第二条记录
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[@data-dataid='"+FWXdataid+"']//tr[1]//td//span[contains(@class,'ez-detail-action') and @data-action='ez-detail-plus']");
        driver.findElement(By.xpath("//table[@data-dataid='"+FWXdataid+"']//tr[1]//td//span[contains(@class,'ez-detail-action') and @data-action='ez-detail-plus']")).click();
        logger.info("点击收费项从表添加");
        
        String serviceitemxpth2=util.getElementXPath(FWXdataid, "2", "serviceitem");
        logger.info(serviceitemxpth2);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, serviceitemxpth2);
        driver.findElement(By.xpath(serviceitemxpth2)).click();
        driver.findElement(By.xpath(serviceitemxpth2+"/input")).sendKeys("技术类");
        logger.info("输入服务项");
        

        String itemnumberxpth2=util.getElementXPath(FWXdataid, "2", "itemnumber");
        logger.info(itemnumberxpth2);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, itemnumberxpth2);
        driver.findElement(By.xpath(itemnumberxpth2)).click();
        util.keyboardNumberInput("2");
        logger.info("数量");
        
        String unitpricexpth2=util.getElementXPath(FWXdataid, "2", "unitprice");
        logger.info(unitpricexpth2);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, unitpricexpth2);
        driver.findElement(By.xpath(unitpricexpth2)).click();
        util.keyboardNumberInput("100.24");
        logger.info("单价");
        
         //添加收费计划从表
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收款计划')]");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收款计划')]")).click();
        logger.info("点击收款计划从表");
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收款计划')]/span");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收款计划')]/span")).click();
        logger.info("点击收款计划从表+");
        
        
        
        String SFJHdataid="40c47e92-d6ae-4c2a-9c86-3978f1bf45f0";
        
        String plandatexpth=util.getElementXPath(SFJHdataid, "1", "plandate");
        logger.info(plandatexpth);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, plandatexpth);
        actions.doubleClick(driver.findElement(By.xpath(plandatexpth))).perform();
        //设置时间格式
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1); // -设置为上一个月      +为后一个月  0 为本月
        date = calendar.getTime();
        String plandate = format.format(date);
        util.keyboardNumberInput(plandate);
        
        
        
        String conditionxpth=util.getElementXPath(SFJHdataid, "1", "condition");
        logger.info(conditionxpth);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, conditionxpth);
        driver.findElement(By.xpath(conditionxpth)).click();
        driver.findElement(By.xpath(conditionxpth+"/input")).sendKeys("合同签订");
        logger.info("输入服务项");
        

        String planscalexpth=util.getElementXPath(SFJHdataid, "1", "planscale");
        logger.info(planscalexpth);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, planscalexpth);
        driver.findElement(By.xpath(planscalexpth)).click();
        util.keyboardNumberInput("30");
        logger.info("收费比例30");
        
        String remarkxpth=util.getElementXPath(SFJHdataid, "1", "remark");
        logger.info(unitpricexpth);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, remarkxpth);
        driver.findElement(By.xpath(remarkxpth)).click();
        driver.findElement(By.xpath(remarkxpth+"/input")).sendKeys("自动输入第一条记录");
        logger.info("输入备注");

        //添加从表第二条记录
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[@data-dataid='"+SFJHdataid+"']//tr[1]//td//span[contains(@class,'ez-detail-action') and @data-action='ez-detail-plus']");
        driver.findElement(By.xpath("//table[@data-dataid='"+SFJHdataid+"']//tr[1]//td//span[contains(@class,'ez-detail-action') and @data-action='ez-detail-plus']")).click();
        logger.info("点击收费项从表添加");
        
        String plandatexpth2=util.getElementXPath(SFJHdataid, "2", "plandate");
        logger.info(plandatexpth2);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, plandatexpth2);
        actions.doubleClick(driver.findElement(By.xpath(plandatexpth2))).perform();
        //设置时间格式
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 3); // -设置为上一个月      +为后一个月  0 为本月
        date = calendar.getTime();
        String plandate2 = format.format(date);
        util.keyboardNumberInput(plandate2);
        
        String conditionxpth2=util.getElementXPath(SFJHdataid, "2", "condition");
        logger.info(conditionxpth2);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, conditionxpth2);
        driver.findElement(By.xpath(conditionxpth2)).click();
        driver.findElement(By.xpath(conditionxpth2+"/input")).sendKeys("合同验收");
        logger.info("输入服务项");
        

        String planscalexpth2=util.getElementXPath(SFJHdataid, "2", "planscale");
        logger.info(planscalexpth);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, planscalexpth2);
        driver.findElement(By.xpath(planscalexpth2)).click();
        util.keyboardNumberInput("70");
        logger.info("收费比例70");
        
        String remarkxpth2=util.getElementXPath(SFJHdataid, "2", "remark");
        logger.info(remarkxpth2);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, remarkxpth2);
        driver.findElement(By.xpath(remarkxpth2)).click();
        driver.findElement(By.xpath(remarkxpth2+"/input")).sendKeys("自动输入第二条记录");
        logger.info("输入备注");
        
        

        //滚动到页面底部
        JavascriptExecutor js2 = ((JavascriptExecutor) driver);
        js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@class='panel-heading']//div/span[contains(@class,'new_upload')]/span[contains(text(),'上传文件')]");
        driver.findElement(By.xpath("//div[@class='panel-heading']//div/span[contains(@class,'new_upload')]/span[contains(text(),'上传文件')]")).click();
               
        //文件上传
        SimulationFileUpload fileUpload =new SimulationFileUpload();
        //上传文件路径
        String fileUrl ="C:\\Users\\Akashi\\Desktop\\UserAccountContracttVO.xlsx";
        //
        fileUpload.fileUpload(fileUrl);    
        logger.info("-----------准备上传------------"+System.currentTimeMillis());
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary");
        driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
        System.currentTimeMillis();
        logger.info("-----------开始上传------------"+System.currentTimeMillis());
        
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("form_newWfInstance")));
        logger.info("-----------文件上传完毕------------"+System.currentTimeMillis());

        
        
        
        //点击保存
        // driver.findElement(By.id("form_save")).click();
        //点击发起
        driver.findElement(By.id("form_newWfInstance")).click();
         
       //获取表单必填字段
         ArrayList<RequiredField> requiredFields=util.getFormRequiredField();
         // 写入表单信息
         ExcelWriter.inputDataExcel(requiredFields,"D:\\文档\\公司文件\\自动化测试用例\\部件化测试\\合同信息测试用例.xlsx");
         
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
