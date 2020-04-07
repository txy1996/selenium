package com.zkdb.selenium.reimbursement;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.tset.ExcelWriterTest;
import com.zkdb.selenium.util.ExcelWriter;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.SimulationFileUpload;
import com.zkdb.selenium.util.WaitiElementsLoad;

/**
 * 
 * @ClassName: ReimbursementOpenForm 
 * @Description: TODO(费用报销打开表单) 
 * @author tangxiaoyu 
 * @date 2020年3月18日 下午2:46:12 
 *
 */
public class ReimbursementOpenForm {
    

    
    WaitiElementsLoad load = new WaitiElementsLoad();
    static SeleniumUtil util = new SeleniumUtil();
    Logger logger =Logger.getLogger(ReimbursementOpenForm.class);
    /**
     * 
     * @Title: reimbursementPositioningExpenses 
     * @Description: TODO(费用报销填写表单并发起) 
     * @param driver
     * @return  流程事项名称
     */
    @SuppressWarnings("static-access")
    public String reimbursementPositioningExpenses(WebDriver driver) {
        
        String url = "D:\\费用报销模块\\测试用例\\费用报销测试用例.xlsx";
        @SuppressWarnings("static-access")
        Map<String, String[]>  valueMap=util.getEncapsulationFormData(url);
        if(valueMap==null) {
            logger.info("文件不存在,转换输入模式");
        }
        
        //鼠标模拟
        Actions actions =new Actions(driver);
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "webiframe");
        driver.switchTo().frame("webiframe");
        logger.info("跳转到webiframe");

        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"财务事项申请");
        driver.findElement(By.linkText("财务事项申请")).click();
        logger.info("点击财务事项申请");
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"费用报销");
        driver.findElement(By.linkText("费用报销")).click();
        logger.info("点击费用报销");
        
        
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
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_ID,"a_number3");
        actions.doubleClick(driver.findElement(By.id("a_number3"))).perform();
        
        logger.info("-----------点击费用报销支出类型------------");
        
//        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"其他费用");
//        driver.findElement(By.linkText("其他费用")).click();
        
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, valueMap.get("a_number3")[0]);
        driver.findElement(By.linkText(valueMap.get("a_number3")[0])).click();
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"a_org_code3");
        actions.doubleClick(driver.findElement(By.id("a_org_code3"))).perform();
        logger.info("-----------点击费用报销支出类型------------");
        

        
        load.Wait(driver, 20, ElementLocateMode.FIND_ELEMENT_XPATH, "//table[contains(@class,'tree_grid')]/tbody//td/span[contains(text(), '"+valueMap.get("a_org_code3")[1]+"')]/../..");
        actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'tree_grid')]/tbody//td/span[contains(text(), '"+valueMap.get("a_org_code3")[1]+"')]/../.."))).perform();
        logger.info("-----------点击通讯费------------");
        
//        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn:nth-child(1)");
//        driver.findElement(By.cssSelector(".modal-footer > .btn:nth-child(1)")).click();
//        logger.info("-----------点击确定------------");

        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "sheet_title");
        driver.findElement(By.id("sheet_title")).sendKeys(valueMap.get("sheet_title")[0]);
        logger.info("-----------支出事由------------");
        
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_number2");
        driver.findElement(By.id("a_number2")).sendKeys(valueMap.get("a_number2")[0]);
        logger.info("-----------原始单据附件数------------");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_text1");
        driver.findElement(By.id("a_text1")).sendKeys(valueMap.get("a_text1")[0]);
        logger.info("-----------报销说明------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".activitetab > .detail-count");
        driver.findElement(By.cssSelector(".activitetab > .detail-count")).click();
        
        logger.info("-----------新增费用明细从表------------");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_date"));
        actions.doubleClick(driver.findElement(By.xpath(util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_date")))).perform();

        util.keyboardNumberInput(valueMap.get("69ea52b9-0976-4643-aa87-4407f2f2baf2"+"1"+"sheet_date")[0]);
        logger.info("-----------点击日期------------");



        logger.info("-----------选择日期------------");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_money"));
        driver.findElement(By.xpath(util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_money"))).click();
        logger.info("-----------child(7)------------");

        // 模拟键盘输入 10092.909
        util.keyboardNumberInput(valueMap.get("69ea52b9-0976-4643-aa87-4407f2f2baf2"+"1"+"sheet_money")[0]);
        

        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "a_number2"));
        actions.doubleClick(driver.findElement(By.xpath(util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "a_number2")))).perform();
        
//        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell:nth-child(8)");
//        driver.findElement(By.cssSelector(".cell:nth-child(8)")).click();
        
//        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//td[8]/div/span/span");
//        driver.findElement(By.xpath("//td[8]/div/span/span")).click();
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,valueMap.get("69ea52b9-0976-4643-aa87-4407f2f2baf2"+"1"+"a_number2")[0]);
        driver.findElement(By.linkText(valueMap.get("69ea52b9-0976-4643-aa87-4407f2f2baf2"+"1"+"a_number2")[0])).click();
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_content"));
        driver.findElement(By.xpath(util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_content"))).sendKeys(valueMap.get("69ea52b9-0976-4643-aa87-4407f2f2baf2"+"1"+"sheet_content")[0]);
        

        

        
        
        
        
        
        
        //
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".btn:nth-child(5)");
        driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
        
        //点击报销附件
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".fa > .text");
        driver.findElement(By.cssSelector(".fa > .text")).click();
        
        
        //文件上传
        SimulationFileUpload fileUpload =new SimulationFileUpload();
        //上传文件路径
        String fileUrl ="D:\\资料文档\\电子书\\森见登美彦\\春宵苦短，少女前进吧！.txt";
        //
        fileUpload.fileUpload(fileUrl);
        

        
        logger.info("-----------准备上传------------"+System.currentTimeMillis());
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary");
        driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
        System.currentTimeMillis();
        logger.info("-----------开始上传------------"+System.currentTimeMillis());
        
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("form_newWfInstance")));
        logger.info("-----------文件上传完毕------------"+System.currentTimeMillis());
        
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
         
       //获取表单必填字段
         ArrayList<RequiredField> requiredFields=util.getFormRequiredField();
         // 写入表单信息
         ExcelWriter.inputDataExcel(requiredFields,"D:\\费用报销模块\\测试用例\\费用报销测试用例.xlsx");
        //获取流程名称
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//div/div[2]/div/div/div[2]/input");
        String processName= driver.findElement(By.xpath("//div/div[2]/div/div/div[2]/input")).getAttribute("value");
        
        logger.info("-----------元素------------"+processName);
        
        

        logger.info("-----------确认发起------------");
        
        
        
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
