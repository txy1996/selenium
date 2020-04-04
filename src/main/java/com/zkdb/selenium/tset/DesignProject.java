package com.zkdb.selenium.tset;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.reimbursement.ReimbursementOpenForm;
import com.zkdb.selenium.reimbursement.RequiredField;
import com.zkdb.selenium.util.ExcelWriter;
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
        //跳转webiframe 验证是否第一次登陆设置在岗状态
        util.verifyOnDuty(driver);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='topbar1']//div[@data-title='项目']");
        driver.findElement(By.xpath("//div[@id='topbar1']//div[@data-title='项目']")).click();
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
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_finish_date");
        actions.doubleClick(driver.findElement(By.id("proj_finish_date"))).perform();
        util.keyboardNumberInput("2020-04-03");
        logger.info("日期");
        
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
            if ("block".equals(webElement.getCssValue("display"))) {
                logger.info("将选择方案设计");
                load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//li//input[@value='方案设计' and @type='checkbox']/..");
                webElement.findElement(By.xpath("//li//input[@value='方案设计' and @type='checkbox']/..")).click();
                logger.info("选择方案设计");
                webElement.findElement(By.xpath("//li/a[contains(@class,'btn') and contains(text(),'确定')]")).click();
            }
        }
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'项目委托')]");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'项目委托')]")).click();
        logger.info("点击项目委托从表");
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'项目委托')]/span");
        driver.findElement(By.xpath("//div[@id='data_panel']//div[@class='tabHeaders']//span[contains(text(),'项目委托')]/span")).click();
        logger.info("点击项目委托从表+");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"/html/body//ul//li[@class='ez-detail-new']");
        driver.findElement(By.xpath("/html/body//ul//li[@class='ez-detail-new']")).click();
        logger.info("点击添加");
        //滚动到页面底部
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        
        String a_org_code2xpth=util.getElementXPath("146157e1-c148-447c-9cbe-8ffb09632501", "1", "a_org_code2");
        logger.info(a_org_code2xpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, a_org_code2xpth);
        actions.doubleClick(driver.findElement(By.xpath(a_org_code2xpth))).perform();
        logger.info("委托类别");

        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='dicname' and contains(text(),'勘测')]");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='dicname' and contains(text(),'勘测')]"))).perform();
        logger.info("选择勘测");
        
        String sheet_titlexpth=util.getElementXPath("146157e1-c148-447c-9cbe-8ffb09632501", "1", "sheet_title");
        logger.info(sheet_titlexpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, sheet_titlexpth);

        actions.doubleClick(driver.findElement(By.xpath(sheet_titlexpth))).perform();
        logger.info("委托委托项");

        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='dicname' and contains(text(),'测试数据')]");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='dicname' and contains(text(),'测试数据')]"))).perform();
        logger.info("选择测试数据");
        
        
        String a_number1xpth=util.getElementXPath("146157e1-c148-447c-9cbe-8ffb09632501", "1", "a_number1");
        logger.info(sheet_titlexpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, a_number1xpth);

        actions.doubleClick(driver.findElement(By.xpath(a_number1xpth))).perform();
        logger.info("计价单位");

        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"平方米");
        driver.findElement(By.linkText("平方米")).click();
        logger.info("选择计价单位");
        
        String a_money_3xpth=util.getElementXPath("146157e1-c148-447c-9cbe-8ffb09632501", "1", "a_money_3");
        logger.info(sheet_titlexpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, a_money_3xpth);
        driver.findElement(By.xpath(a_money_3xpth)).click();
        util.keyboardNumberInput("998.03");
        logger.info("委托量");
        
        String sheet_remalkxpth=util.getElementXPath("146157e1-c148-447c-9cbe-8ffb09632501", "1", "sheet_remalk");
        logger.info(sheet_titlexpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, sheet_remalkxpth);
        driver.findElement(By.xpath(sheet_remalkxpth)).click();
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, sheet_remalkxpth+"/textarea");
        driver.findElement(By.xpath(sheet_remalkxpth+"/textarea")).sendKeys("隐约雷鸣，阴霾天空，即使天无雨，我亦留此地。");

        logger.info("备注");

        //获取表单必填字段
        ArrayList<RequiredField> requiredFields=util.getFormRequiredField(driver);
        // 写入表单信息
        ExcelWriter.inputDataExcel(requiredFields,"D:\\项目立项\\项目立项测试用例.xlsx");
        
        return null;
    }
}
