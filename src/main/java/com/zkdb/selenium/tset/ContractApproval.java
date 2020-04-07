package com.zkdb.selenium.tset;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.constant.InitDriver;
import com.zkdb.selenium.reimbursement.ProcessForwarding;
import com.zkdb.selenium.reimbursement.ReimbursementOpenForm;
import com.zkdb.selenium.reimbursement.ReimbursementRun;
import com.zkdb.selenium.util.Login;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;
import com.zkdb.selenium.vo.UserAccountVO;

public class ContractApproval {

	static //等待方法
    WaitiElementsLoad load = new WaitiElementsLoad();
    //工具类
    static SeleniumUtil util = new SeleniumUtil();
    //日志
    Logger logger =Logger.getLogger(ReimbursementOpenForm.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}
	
	public static void run() {
        Logger logger =Logger.getLogger(ReimbursementRun.class);
        //读取配置文件 (预设账号)
        //初始化 
        WebDriver driver = new ChromeDriver();
        driver.get("http://epplus.cn/d/signin_test.jsp");
        //调用登录
        Login login = new Login();
        //使用账号登录
        login.loginDevelopmentAccount(driver, "15882891378", "888888");
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        login.loginTestAccount(driver, "BEP", "1005118", "888888");
        logger.info("登陆账号:1005118");
        
        try {
            //填写费用报销表单
        	//鼠标模拟
            Actions actions =new Actions(driver);
            //跳转webiframe 验证是否第一次登陆设置在岗状态
            util.verifyOnDuty();
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='topbar1']//div[@data-title='测试部件']");
            driver.findElement(By.xpath("//div[@id='topbar1']//div[@data-title='测试部件']")).click();
            logger.info("测试部件");
            
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "程序测试");
            driver.findElement(By.linkText("程序测试")).click();
            logger.info("程序测试");
            
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "合同审批");
            driver.findElement(By.linkText("合同审批")).click();
            logger.info("合同审批");
            //跳转
            driver.switchTo().frame("page_bb15ba87-0f01-455e-8bb6-d64b14beb79c");
            
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "btnAdd");
            driver.findElement(By.id("btnAdd")).click();
            logger.info("点击添加按钮");
            
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
            //driver.findElement(By.xpath("//div[@class='modal-header']//input[@placeholder='搜索']")).sendKeys("赵云");
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
            
            
//            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收费项')]");
//            driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收费项')]")).click();
//            logger.info("点击离职资料从表");
//            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收费项')]/span");
//            driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收费项')]/span")).click();
//            logger.info("点击离职资料从表+");
//            
//            //滚动到页面底部
//            JavascriptExecutor js = ((JavascriptExecutor) driver);
//            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//            
//            String FWXdataid="a7594a13-ce79-462e-8c7e-8e2b7ef5eefa";
//            String serviceitemxpth=util.getElementXPath(FWXdataid, "1", "serviceitem");
//            logger.info(serviceitemxpth);
//            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, serviceitemxpth);
//            driver.findElement(By.xpath(serviceitemxpth)).click();
//            driver.findElement(By.xpath(serviceitemxpth+"/input")).sendKeys("服务项");
//            logger.info("输入服务项");
            
            
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
            
//            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"/html/body//ul//li[@class='ez-detail-new']");
//            driver.findElement(By.xpath("/html/body//ul//li[@class='ez-detail-new']")).click();
//            logger.info("点击添加");



            
            String FWXdataid="a7594a13-ce79-462e-8c7e-8e2b7ef5eefa";
            String serviceitemxpth=util.getElementXPath(FWXdataid, "1", "serviceitem");
            logger.info(serviceitemxpth);
            load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, serviceitemxpth);
            driver.findElement(By.xpath(serviceitemxpth)).click();
            driver.findElement(By.xpath(serviceitemxpth+"/input")).sendKeys("服务项");
            logger.info("输入服务项");
            

            String itemnumberxpth=util.getElementXPath(FWXdataid, "1", "itemnumber");
            logger.info(itemnumberxpth);
            load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, itemnumberxpth);
            driver.findElement(By.xpath(itemnumberxpth)).click();
            util.keyboardNumberInput("1");
            logger.info("数量");
            
            String unitpricexpth=util.getElementXPath(FWXdataid, "1", "unitprice");
            logger.info(unitpricexpth);
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, unitpricexpth);
            driver.findElement(By.xpath(unitpricexpth)).click();
            util.keyboardNumberInput("999.96");
            logger.info("单价");
            
            
            
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收款计划')]");
            driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收款计划')]")).click();
            logger.info("点击收款计划从表");
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收款计划')]/span");
            driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'收款计划')]/span")).click();
            logger.info("点击收款计划从表+");
            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"/html/body//ul//li[@class='ez-detail-new']");
            driver.findElement(By.xpath("/html/body//ul//li[@class='ez-detail-new']")).click();
            logger.info("点击添加");
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
            //SeleniumUtil.runExceptionScreenshot(driver);
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
