package com.zkdb.selenium.tset;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.reimbursement.RequiredField;
import com.zkdb.selenium.util.AttributesEnum;
import com.zkdb.selenium.util.ElementLocateMode;
import com.zkdb.selenium.util.ExcelReader;
import com.zkdb.selenium.util.ExcelWriter;
import com.zkdb.selenium.util.InitDriver;
import com.zkdb.selenium.util.Login;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.SimulationFileUpload;
import com.zkdb.selenium.util.WaitiElementsLoad;
import com.zkdb.selenium.vo.UserAccountVO;

public class ReimbursementTest {

    
    public static void main(String[] args) {
        
        
        run();
        
        
//        String url="D:\\费用报销模块\\测试用例\\费用报销测试用例.xlsx";
//        ArrayList<RequiredField> requiredFields= (ArrayList<RequiredField>) SeleniumUtil.getExcelDate(url,new RequiredField());
//        
//        for (RequiredField requiredField2 : requiredFields) {
//            
//            System.out.println(requiredField2.toString());
//        }

  
    }
    
    public static void testReflect(Object model) throws Exception{
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + ":" + field.get(model)+field.getType() );
            }
    }
    
    public static void run() {
        // TODO Auto-generated method stub
        WaitiElementsLoad load = new WaitiElementsLoad();
        SeleniumUtil util = new SeleniumUtil();
        Logger logger =Logger.getLogger(ReimbursementTest.class);
        
        WebDriver driver =InitDriver.INSTANCE.getDriver();
        
        Login login = new Login();
        login.loginDevelopmentAccount(driver, "15882891378", "888888");
     
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        login.loginTestAccount(driver, "BEP", "241", "11111111");
        logger.info("登陆账号:241");
        try {
            String url="D:\\费用报销模块\\测试用例\\费用报销测试用例.xlsx";
            //ArrayList<RequiredField> requiredFieldExecl= (ArrayList<RequiredField>) SeleniumUtil.getExcelDate(url,new RequiredField());
            
            
            
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

            driver.findElement(By.id("a_number3")).click();
            logger.info("-----------点击费用报销支出类型------------");
            
            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,"#group_head_1504769941216 > div > div.row > div > div > span.input-group-addon");
            driver.findElement(By.cssSelector("#group_head_1504769941216 > div > div.row > div > div > span.input-group-addon")).click();
            logger.info("-----------点击费用报销支出类型------------");
            
            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"其他费用");
            driver.findElement(By.linkText("其他费用")).click();
            
            
            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"a_org_code3");
            driver.findElement(By.id("a_org_code3")).click();
            logger.info("-----------点击费用科目------------");
            
            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,"#group_body_1504769941216 > div > div:nth-child(1) > div:nth-child(4) > div > span.input-group-addon");
            driver.findElement(By.cssSelector("#group_body_1504769941216 > div > div:nth-child(1) > div:nth-child(4) > div > span.input-group-addon")).click();
            
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
            util.keyboardNumberInput((float) 10092.90);
            

            
            
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
//            //
//            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".btn:nth-child(5)");
//            driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
            
//            //点击报销附件
//            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".fa > .text");
//            driver.findElement(By.cssSelector(".fa > .text")).click();
            
            
//            //文件上传
//            SimulationFileUpload fileUpload =new SimulationFileUpload();
//            //上传文件路径
//            String fileUrl ="D:\\资料文档\\电子书\\森见登美彦\\春宵苦短，少女前进吧！.txt";
//            //
//            fileUpload.fileUpload(fileUrl);
//            
//
//            
//            logger.info("-----------准备上传------------"+System.currentTimeMillis());
//            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary");
//            driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
//            System.currentTimeMillis();
//            logger.info("-----------开始上传------------"+System.currentTimeMillis());
//            
//            new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("form_newWfInstance")));
//            logger.info("-----------文件上传完毕------------"+System.currentTimeMillis());
//            
//            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"form_newWfInstance");
            
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            

            
          //获取表单必填字段
            ArrayList<RequiredField> requiredFields = new ArrayList<>();
            
            List<WebElement> elementsCBdate=driver.findElements(By.xpath("//table[@class='detailData']"));
            
            for (WebElement webElement : elementsCBdate) {
                //logger.info(webElement.getAttribute("data-dataid"));
                List<WebElement> elementsCB =webElement.findElements(By.xpath("//td[contains(@class,'ui-resizable')]"));
                List<WebElement> elementTR=webElement.findElements(By.xpath("//tr[contains(@class,'detail-row')]"));
                for (WebElement webElement2 : elementTR) {
                    List<WebElement> elementsTDData=webElement2.findElements(By.tagName("td"));
                    for (WebElement webElement3 : elementsTDData) {
                        if(webElement3.getAttribute("data-field")!=null&&!"checked".equals(webElement3.getAttribute("data-field"))) {
                           logger.info(webElement3.getAttribute("data-field")+"-----data-field-----"+webElement3.getAttribute("title")+"-----title-----"); 
                           
                        }
                    }
                }
                for (WebElement webElement1 : elementsCB) {
                    //获取从表必填字段
                    if ("1".equals(webElement1.getAttribute("data-required"))) {
                        
                       util.secondaryDataInput(driver,webElement,webElement1,requiredFields,AttributesEnum.Required.getValue());
                       //只读
                    }else if ("1".equals(webElement1.getAttribute("data-readonly"))) {
                        
                        util.secondaryDataInput(driver,webElement,webElement1,requiredFields,AttributesEnum.Readonly.getValue());
                        
                        //可填
                    }else if(!"1".equals(webElement.getAttribute("data-readonly"))
                            &&!"1".equals(webElement.getAttribute("data-required"))
                            ) {
                        util.secondaryDataInput(driver,webElement,webElement1,requiredFields,AttributesEnum.Fillable.getValue());
                        //不可见
                    }else if ("1".equals(webElement.getAttribute("data-readonly"))&&!webElement.isDisplayed()) {
                        util.secondaryDataInput(driver,webElement,webElement1,requiredFields,AttributesEnum.Invisible.getValue());
                    }
                    
                }
            }
            
            ExcelWriter.inputDataExcel(requiredFields,url);
            
//            for (RequiredField requiredField : requiredFields) {
//                testReflect(requiredField);
//                logger.info(requiredField.toString());
//            }
            
            logger.info("完成");
            
            
            
//            //获取表单必填字段
//            ArrayList<RequiredField> requiredFields=util.getFormRequiredField(driver);
//            ExcelWriterTest.test(requiredFields);
//            
//            for (RequiredField requiredField : requiredFields) {
//                logger.info(requiredField.toString());
//            }
            
            
           


            


            
        }catch (Exception e){
            System.out.println(e.toString());
            SeleniumUtil.runExceptionScreenshot(driver);
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
