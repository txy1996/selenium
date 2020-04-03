package com.zkdb.selenium.tset;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.reimbursement.ReimbursementOpenForm;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;

/**
 * 
 * @ClassName: DesignProject 
 * @Description: TODO(填写项目立项表单) 
 * @author tangxiaoyu 
 * @date 2020年4月1日 下午2:24:25 
 *
 */
public class DesignProject {

    //等待方法
    WaitiElementsLoad load = new WaitiElementsLoad();
    //工具类
    static SeleniumUtil util = new SeleniumUtil();
    //日志
    Logger logger =Logger.getLogger(ReimbursementOpenForm.class);
    /**
     * 
     * @Title: designProjectPositioningExpenses 
     * @Description: TODO(费用报销填写表单并发起) 
     * @param driver
     * @return  流程事项名称
     */
    @SuppressWarnings("static-access")
    public String designProjectPositioningExpenses(WebDriver driver) {
        
//        String url = "D:\\费用报销模块\\测试用例\\费用报销测试用例.xlsx";
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
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, "#topbar1 > .item:nth-child(3) > .text");
        driver.findElement(By.cssSelector("#topbar1 > .item:nth-child(3) > .text")).click();
        logger.info("点击项目");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "启动规划");
        driver.findElement(By.linkText("启动规划")).click();
        logger.info("启动规划");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "设计项目立项");
        driver.findElement(By.linkText("设计项目立项")).click();
        logger.info("设计项目立项");
        //跳转
        driver.switchTo().frame(2);
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "btnAdd");
        driver.findElement(By.id("btnAdd")).click();
        logger.info("点击添加按钮");
        
        String handle= driver.getWindowHandle();
        util.switchWindow(driver);
        
        
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        try {
            Thread.sleep(6500);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_ID,"a_number2");
        //鼠标模拟双击
        actions.doubleClick(driver.findElement(By.id("a_number2"))).perform();
        logger.info("双击立项依据");
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "备案项目");
        driver.findElement(By.linkText("备案项目")).click();
        logger.info("选择备案项目");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_ID,"a_user4");
        //鼠标模拟双击
        actions.doubleClick(driver.findElement(By.id("a_user4"))).perform();
        logger.info("双击备案项目");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-header']/div/ul//div/input[@data-field='sheet_title']");
        driver.findElement(By.xpath("//div[@class='modal-header']/div/ul//div/input[@data-field='sheet_title']")).sendKeys("华为西部研发中心");
        logger.info("输入项目名称");
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modal-content')]/div[@class='modal-header']/div/ul//button[contains(text(),'搜索')]");
        driver.findElement(By.xpath("//div[contains(@class,'modal-content')]/div[@class='modal-header']/div/ul//button[contains(text(),'搜索')]")).click();
        logger.info("点击搜索");
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='sheet_title' and contains(text(),'华为西部研发中心')]/..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='sheet_title' and contains(text(),'华为西部研发中心')]/.."))).perform();
        logger.info("双击确认选择");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_shortname");
        driver.findElement(By.id("proj_shortname")).sendKeys("华为西部研发中心");
        logger.info("设置项目简称");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_author");
        actions.doubleClick(driver.findElement(By.id("proj_author"))).perform();
        logger.info("双击负责人");
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-header']//input[@placeholder='搜索']");
      
        driver.findElement(By.xpath("//div[@class='modal-header']//input[@placeholder='搜索']")).sendKeys("张飞");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'张飞')]/../../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'张飞')]/../../.."))).perform();
        logger.info("选择负责人");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_org_code3");
        driver.findElement(By.id("a_org_code3")).sendKeys("中建五局");
        logger.info("建设单位");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_assistant");
        actions.doubleClick(driver.findElement(By.id("proj_assistant"))).perform();
        logger.info("双击项目助理");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-header']//input[@placeholder='搜索']");
        
        driver.findElement(By.xpath("//div[@class='modal-header']//input[@placeholder='搜索']")).sendKeys("赵云");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'赵云')]/../../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'赵云')]/../../.."))).perform();
        logger.info("选择项目助理");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_number5");
        actions.doubleClick(driver.findElement(By.id("a_number5"))).perform();
        logger.info("双击项目性质");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "新建");
        driver.findElement(By.linkText("新建")).click();
        logger.info("选择项目性质");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_number3");
        actions.doubleClick(driver.findElement(By.id("a_number3"))).perform();
        logger.info("双击管理级别");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "院级");
        driver.findElement(By.linkText("院级")).click();
        logger.info("选择管理级别");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_number4");
        actions.doubleClick(driver.findElement(By.id("a_number4"))).perform();
        logger.info("双击质量目标");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "市优");
        driver.findElement(By.linkText("市优")).click();
        logger.info("选择质量目标");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_money1");
        driver.findElement(By.id("a_money1")).click();
        util.keyboardNumberInput("998");
        logger.info("设置项目规模");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_number1");
        actions.doubleClick(driver.findElement(By.id("a_number1"))).perform();
        logger.info("双击规模单位");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-header']/div/ul//div/input[@data-field='dicname']");
        driver.findElement(By.xpath("//div[@class='modal-header']/div/ul//div/input[@data-field='dicname']")).sendKeys("亿元");
        logger.info("输入规模单位");
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modal-content')]/div[@class='modal-header']/div/ul//button[contains(text(),'搜索')]");
        driver.findElement(By.xpath("//div[contains(@class,'modal-content')]/div[@class='modal-header']/div/ul//button[contains(text(),'搜索')]")).click();
        logger.info("点击搜索");
        
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr/td[@data-field='dicname' and contains(text(),'亿元')]/..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr/td[@data-field='dicname' and contains(text(),'亿元')]/../td[1]/input"))).perform();
        logger.info("双击确认选择");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_description");
        driver.findElement(By.id("proj_description")).sendKeys("等一条离群太远的深海游鱼 碰到一只 离群太远的蚁");
        logger.info("设置描 述");
        
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_org_code2");
        actions.doubleClick(driver.findElement(By.id("a_org_code2"))).perform();
        logger.info("双击设计阶段");
        List<WebElement> elements=driver.findElements(By.xpath("/html/body/ul"));
        logger.info("获取元素");
        for (WebElement webElement : elements) {
            logger.info(webElement.getCssValue("display"));
            if ("blcok".equals(webElement.getCssValue("display"))) {
                
                webElement.findElement(By.xpath("//li[@class='active']//input[@value='方案设计' and @type='checkbox']")).click();
                logger.info("选择方案设计");
                webElement.findElement(By.xpath("//li/a[contains(@class,'btn') and contains(text(),'确定')]")).click();
            }
        }
        
//        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"/body/ul/li[@class='active']//input[@value='方案设计' and @type='checkbox']");
//        WebElement elementFN =driver.findElement(By.xpath("//body/ul/li[@class='active']//input[@value='方案设计' and @type='checkbox']"));
//        elementFN.click();
//        if (elementFN.isSelected()) {
//            logger.info("选择方案设计");
//        }else {
//            elementFN.click();
//            logger.info("选择方案设计");
//        }
//        
//        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//body/ul[9]//li/a[contains(@class,'btn') and contains(text(),'确定')]");
//        driver.findElement(By.xpath("//body/ul[9]//li/a[contains(@class,'btn') and contains(text(),'确定')]")).click();
//        logger.info("点击搜索");
//        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_ID,"sheet_code");
//        //鼠标模拟双击
//        actions.doubleClick(driver.findElement(By.id("sheet_code"))).perform();
//        logger.info("双击业务板块");
//        
//        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr[@data-rowid='2']/td/input[@class='checkbox']");
//        
//        driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr[@data-rowid='2']/td/input[@class='checkbox']")).click();
//        driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr[@data-rowid='1']/td/input[@class='checkbox']")).click();
//        logger.info("选择字典");
//        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modal-content')]/div[@class='modal-footer']/span[contains(text(),'确定')]");
//        driver.findElement(By.xpath("//div[contains(@class,'modal-content')]/div[@class='modal-footer']/span[contains(text(),'确定')]")).click();
//        logger.info("点击确认");
        return null;
    }
}
