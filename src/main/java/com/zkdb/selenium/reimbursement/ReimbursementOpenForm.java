package com.zkdb.selenium.reimbursement;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.tset.ExcelWriterTest;
import com.zkdb.selenium.util.ElementLocateMode;
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
    SeleniumUtil util = new SeleniumUtil();
    Logger logger =Logger.getLogger(ReimbursementOpenForm.class);
    /**
     * 
     * @Title: reimbursementPositioningExpenses 
     * @Description: TODO(费用报销填写表单并发起) 
     * @param driver
     * @return  流程事项名称
     */
    public String reimbursementPositioningExpenses(WebDriver driver) {
        
        
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
        util.switchWindow(driver);

        
        
        
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        try {
            Thread.sleep(6500);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_ID,"a_number3");

//        driver.findElement(By.id("a_number3")).click();
//        logger.info("-----------点击费用报销支出类型------------");
        
        actions.doubleClick(driver.findElement(By.id("a_number3"))).perform();
        logger.info("-----------点击费用报销支出类型------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"其他费用");
        driver.findElement(By.linkText("其他费用")).click();
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"a_org_code3");
        driver.findElement(By.id("a_org_code3")).click();
        logger.info("-----------点击费用科目------------");
        
        actions.doubleClick(driver.findElement(By.id("a_org_code3"))).perform();
        
        logger.info("-----------点击费用报销支出类型------------");
        

        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,"tr:nth-child(6) > td:nth-child(3)");
        driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(3)")).click();
        logger.info("-----------点击通讯费------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn:nth-child(1)");
        driver.findElement(By.cssSelector(".modal-footer > .btn:nth-child(1)")).click();
        logger.info("-----------点击确定------------");

        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"sheet_title");
        driver.findElement(By.id("sheet_title"))
        .sendKeys("少女祈祷中…");
        logger.info("-----------支出事由------------");
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"a_number2");
        driver.findElement(By.id("a_number2"))
        .sendKeys("2");
        logger.info("-----------原始单据附件数------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"a_text1");
        driver.findElement(By.id("a_text1"))
        .sendKeys("瞿塘嘈嘈十二滩，此中道路古来难。长恨人心不如水，等闲平地起波澜。");
        logger.info("-----------原始单据附件数------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".activitetab > .detail-count");
        driver.findElement(By.cssSelector(".activitetab > .detail-count")).click();
        
        logger.info("-----------新增费用明细从表------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell:nth-child(6)");
        driver.findElement(By.cssSelector(".cell:nth-child(6)")).click();
        
        logger.info("-----------点击日期------------");
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell .glyphicon");
        driver.findElement(By.cssSelector(".cell .glyphicon")).click();
        
        
        //跳转窗体
        driver.switchTo().frame(0);
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".mh-today > .mh-solar");
        driver.findElement(By.cssSelector(".mh-today > .mh-solar")).click();
        
        logger.info("-----------选择日期------------");
        
        driver.switchTo().defaultContent();
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell:nth-child(7)");
        driver.findElement(By.cssSelector(".cell:nth-child(7)")).click();
        logger.info("-----------child(7)------------");
        
        //模拟键盘输入
        util.keyboardNumberInput("10092.90");
        

        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell:nth-child(8)");
        driver.findElement(By.cssSelector(".cell:nth-child(8)")).click();
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell:nth-child(8)");
        driver.findElement(By.cssSelector(".cell:nth-child(8)")).click();
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//td[8]/div/span/span");
        driver.findElement(By.xpath("//td[8]/div/span/span")).click();
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"服务票3%");
        driver.findElement(By.linkText("服务票3%")).click();
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell:nth-child(11)");
        driver.findElement(By.cssSelector(".cell:nth-child(11)")).click();
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//td[11]/input");
        driver.findElement(By.xpath("//td[11]/input")).sendKeys("芳树笼秦栈，春流绕蜀城");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell:nth-child(12)");
        driver.findElement(By.cssSelector(".cell:nth-child(12)")).click();
        
        
        //获取表单必填字段
        ArrayList<RequiredField> requiredFields=util.getFormRequiredField(driver);
        // 写入表单信息
        ExcelWriter.inputDataExcel(requiredFields,"D:\\费用报销模块\\测试用例\\费用报销测试用例.xlsx");
        
        
        
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
