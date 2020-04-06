package com.zkdb.selenium.tset;

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
import com.zkdb.selenium.reimbursement.ReimbursementOpenForm;
import com.zkdb.selenium.reimbursement.RequiredField;
import com.zkdb.selenium.util.ExcelWriter;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;

public class DesignProject1 {

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
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "sheet_code");
        actions.doubleClick(driver.findElement(By.id("sheet_code"))).perform();
        logger.info("设置项目简称");
        
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table/tbody//tr//td[contains(text(),'建筑')]/../td/input");
        actions.doubleClick(driver.findElement(By.xpath("//table/tbody//tr//td[contains(text(),'建筑')]/../td/input"))).perform();
        logger.info("选择建筑");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table/tbody//tr//td[contains(text(),'市政')]/../td/input");
        actions.doubleClick(driver.findElement(By.xpath("//table/tbody//tr//td[contains(text(),'市政')]/../td/input"))).perform();
        logger.info("选择市政");
        
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modal-dialog')]//div[contains(@class,'modal-footer')]/span[contains(text(),'确定')]");
        driver.findElement(By.xpath("//div[contains(@class,'modal-dialog')]//div[contains(@class,'modal-footer')]/span[contains(text(),'确定')]")).click();
        logger.info("点击确定");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "customid");
        actions.doubleClick(driver.findElement(By.id("customid"))).perform();
        logger.info("设置甲方名称");
        
        String partyName="国家电网有限公司";
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-header']/div/ul//div/input[@data-field='sheet_title']");
        driver.findElement(By.xpath("//div[@class='modal-header']/div/ul//div/input[@data-field='sheet_title']")).sendKeys(partyName);
        logger.info("输入甲方名称");
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modal-content')]/div[@class='modal-header']/div/ul//button[contains(text(),'搜索')]");
        driver.findElement(By.xpath("//div[contains(@class,'modal-content')]/div[@class='modal-header']/div/ul//button[contains(text(),'搜索')]")).click();
        logger.info("点击搜索");
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='sheet_title' and contains(text(),'"+partyName+"')]/..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='sheet_title' and contains(text(),'"+partyName+"')]/.."))).perform();
        logger.info("双击确认选择");
        
        String proj_name="selenium自动化测试项目";
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_name");
        driver.findElement(By.id("proj_name")).sendKeys(proj_name+System.currentTimeMillis());
        logger.info("设置项目名称");
        
        
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_shortname");
        driver.findElement(By.id("proj_shortname")).sendKeys(proj_name);
        logger.info("设置 项目简称");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_author");
        actions.doubleClick(driver.findElement(By.id("proj_author"))).perform();
        logger.info("双击负责人");
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[@class='modal-header']//input[@placeholder='搜索']");
        String principal="曹操";
        driver.findElement(By.xpath("//div[@class='modal-header']//input[@placeholder='搜索']")).sendKeys(principal);
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+principal+"')]/../../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='username']//span[contains(text(),'"+principal+"')]/../../.."))).perform();
        logger.info("选择负责人");
        
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd)");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1); // 设置为上一个月      +为后一个月  0 为本月
        date = calendar.getTime();
        String time = format.format(date);
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "proj_finish_date");
        actions.doubleClick(driver.findElement(By.id("proj_finish_date"))).perform();
        util.keyboardNumberInput(time);
        logger.info("结束日期");
        
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
            if ("block".equals(webElement.getCssValue("display"))) {
                logger.info("将选择方案设计");
                load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//li//input[@value='方案设计' and @type='checkbox']/..");
                webElement.findElement(By.xpath("//li//input[@value='方案设计' and @type='checkbox']/..")).click();
                logger.info("选择方案设计");
                webElement.findElement(By.xpath("//li/a[contains(@class,'btn') and contains(text(),'确定')]")).click();
            }
        }
        
        String dataId="360476a2-402d-43a8-8fe7-f709b40ed1c1";
        
        String a_string2Xpth=util.getElementXPath(dataId, "1", "a_string2");
        logger.info(a_string2Xpth);
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, a_string2Xpth);
        actions.doubleClick(driver.findElement(By.xpath(a_string2Xpth))).perform();
        logger.info("委托类别");

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
//        //获取表单必填字段
//        ArrayList<RequiredField> requiredFields=util.getFormRequiredField(driver);
//        // 写入表单信息
//        ExcelWriter.inputDataExcel(requiredFields,"D:\\项目立项\\项目立项测试用例.xlsx");
        //获取流程事项名称
        load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[contains(@class,'modalWorkFlow')]//div[contains(@class,'modal-body')]//div/label[contains(text(), '事项名称')]/../input");
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
