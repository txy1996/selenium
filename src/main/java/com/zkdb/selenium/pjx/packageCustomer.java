package com.zkdb.selenium.pjx;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.vo.RequiredField;
import com.zkdb.selenium.util.ExcelWriter;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;

/**
 * 
 * @ClassName: DesignProject 
 * @Description: TODO(填写测试客户) 
 * @author pjx 
 * @date 2020年4月2日 下午2:24:25 
 *
 */
public class packageCustomer {

	//等待方法
    WaitiElementsLoad load = new WaitiElementsLoad();
    //工具类
    static SeleniumUtil util = new SeleniumUtil();
    //日志
    Logger logger =Logger.getLogger(packageCustomer.class);
    /**
     * 
     * @Title: designProjectPositioningExpenses 
     * @Description: TODO(填写测试客户) 
     * @param driver
     * @return  流程事项名称
     */
    @SuppressWarnings("static-access")
    public String packageCustomerPositioningExpenses(WebDriver driver) {
        
//        String url = "D:\\文档\、公司文件\\自动化测试用例\\部件化测试\\部件客户测试用例.xlsx";
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
//        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, "#topbar1 > .item:nth-child(6) > .text");
//        driver.findElement(By.cssSelector("#topbar1 > .item:nth-child(6) > .text")).click();
//        logger.info("点击测试部件");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='topbar1']//div[@data-title='测试部件']");
        driver.findElement(By.xpath("//div[@id='topbar1']//div[@data-title='测试部件']")).click();
        logger.info("点击测试部件");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "程序测试");
        driver.findElement(By.linkText("程序测试")).click();
        logger.info("程序测试");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "客户登记");
        driver.findElement(By.linkText("客户登记")).click();
        logger.info("客户登记");
        //跳转
        driver.switchTo().frame(1);
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "btnAdd");
        driver.findElement(By.id("btnAdd")).click();
        logger.info("点击添加按钮");
        
        String handle= driver.getWindowHandle();
        util.switchWindow();
        
        
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        try {
            Thread.sleep(6500);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "customname");
        driver.findElement(By.id("customname")).sendKeys("测试部件客户名称");
        logger.info("设置客户名称");
      
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"region");
        //鼠标模拟双击
        actions.doubleClick(driver.findElement(By.id("region"))).perform();
        logger.info("双击所在区域");
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "华东地区");
        driver.findElement(By.linkText("华东地区")).click();
        logger.info("选择华东地区");
       
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_ID,"province");
        //鼠标模拟双击
        actions.doubleClick(driver.findElement(By.id("province"))).perform();
        logger.info("双击所在省");
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='dicname' and contains(text(),'山东省')]/..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='dicname' and contains(text(),'山东省')]/.."))).perform();
        logger.info("双击确认选择");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_ID,"city");
        //鼠标模拟双击
        actions.doubleClick(driver.findElement(By.id("city"))).perform();
        logger.info("双击所在市");
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//table[contains(@class,'table')]/tbody//tr//td[@data-field='dicname' and contains(text(),'青岛')]/..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'table')]/tbody//tr//td[@data-field='dicname' and contains(text(),'青岛')]/.."))).perform();
        logger.info("双击确认选择");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "remark");
        driver.findElement(By.id("remark")).sendKeys("备注信息输入"
        		+ "备注信息输入第二行");
        logger.info("设置备注");
        
       
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "linkman");
        driver.findElement(By.id("linkman")).sendKeys("联系人姓名");
        logger.info("设置联系人姓名");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "linkphone");
        driver.findElement(By.id("linkphone")).sendKeys("010-68350423");
        logger.info("设置联系人电话");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "linkemail");
        driver.findElement(By.id("linkemail")).sendKeys("pjxaaa@163.com");
        logger.info("设置联系人邮件");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "linkaddress");
        driver.findElement(By.id("linkaddress")).sendKeys("北京中科大厦1257");
        logger.info("设置联系人地址");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "groupname");
        driver.findElement(By.id("groupname")).sendKeys("四川中科集团");
        logger.info("设置集团名称");
        
        //点击保存
         driver.findElement(By.id("form_save")).click();
         
       //获取表单必填字段
         ArrayList<RequiredField> requiredFields=util.getFormRequiredField();
         // 写入表单信息
         ExcelWriter.inputDataExcel(requiredFields,"D:\\文档\\公司文件\\自动化测试用例\\部件化测试\\客户信息测试用例.xlsx");
         return null;
    }

}
