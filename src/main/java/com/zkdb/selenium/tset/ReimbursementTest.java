package com.zkdb.selenium.tset;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.constant.AttributesEnum;
import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.constant.InitDriver;
import com.zkdb.selenium.reimbursement.RequiredField;
import com.zkdb.selenium.util.ExcelReader;
import com.zkdb.selenium.util.ExcelWriter;
import com.zkdb.selenium.util.Login;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.SimulationFileUpload;
import com.zkdb.selenium.util.WaitiElementsLoad;
import com.zkdb.selenium.vo.UserAccountVO;

public class ReimbursementTest {

    public static void main(String[] args) {

        run();

//        String url = "D:\\费用报销模块\\测试用例\\费用报销测试用例.xlsx";
//        ArrayList<RequiredField> requiredFields = (ArrayList<RequiredField>) SeleniumUtil.getExcelDate(url,
//                new RequiredField());
//        Map<String, String> valueMap = new HashMap<String, String>();
//        for (RequiredField requiredField : requiredFields) {
//            if (requiredField.getSerialNumber().equals("") || requiredField == null) {
//                valueMap.put(requiredField.getField(), requiredField.getFieldValue());
//            }
//            System.out.println(requiredField.toString());
//        }

    }

    public static void testReflect(Object model) throws Exception {
        for (Field field : model.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + ":" + field.get(model) + field.getType());
        }
    }

    @SuppressWarnings("static-access")
    public static void run() {
        // TODO Auto-generated method stub
        // 等待方法
        WaitiElementsLoad load = new WaitiElementsLoad();
        // 工具类
        SeleniumUtil util = new SeleniumUtil();
        // 日志输出
        Logger logger = Logger.getLogger(ReimbursementTest.class);
        // 初始化driver
        WebDriver driver = InitDriver.INSTANCE.getDriver();
        // 鼠标模拟
        Actions actions = new Actions(driver);
        // 登录方法
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
            String url = "D:\\费用报销模块\\测试用例\\费用报销测试用例12.xlsx";
            Map<String, String[]>  valueMap=util.getEncapsulationFormData(url);
            if(valueMap==null) {
            	logger.info("文件不存在,转换输入模式");
            }
            

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "webiframe");
            driver.switchTo().frame("webiframe");
            logger.info("跳转到webiframe");

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "财务事项申请");
            driver.findElement(By.linkText("财务事项申请")).click();
            logger.info("点击财务事项申请");
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "费用报销");
            driver.findElement(By.linkText("费用报销")).click();
            logger.info("点击费用报销");

            // 记录当前窗口
            String handle = driver.getWindowHandle();
            // 跳转到新窗口
            util.switchWindow(driver);

            // 等待body加载完毕
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
            try {
                Thread.sleep(6500);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_ID, "a_number3");
            actions.doubleClick(driver.findElement(By.id("a_number3"))).perform();
            logger.info("-----------点击费用报销支出类型------------");

            logger.info("-----------点击费用报销支出类型------------");

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, valueMap.get("a_number3")[0]);
            driver.findElement(By.linkText(valueMap.get("a_number3")[0])).click();

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_org_code3");
            actions.doubleClick(driver.findElement(By.id("a_org_code3"))).perform();
            logger.info("-----------点击费用科目------------");
            logger.info("-----------点击费用报销支出类型------------");

            load.Wait(driver, 20, ElementLocateMode.FIND_ELEMENT_XPATH, "//table[contains(@class,'tree_grid')]/tbody//td/span[contains(text(), '"+valueMap.get("a_org_code3")[1]+"')]/../..");
            actions.doubleClick(driver.findElement(By.xpath("//table[contains(@class,'tree_grid')]/tbody//td/span[contains(text(), '"+valueMap.get("a_org_code3")[1]+"')]/../.."))).perform();
            logger.info("-----------点击通讯费------------");



            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "sheet_title");
            driver.findElement(By.id("sheet_title")).sendKeys(valueMap.get("sheet_title")[0]);
            logger.info("-----------支出事由------------");

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_number2");
            driver.findElement(By.id("a_number2")).sendKeys(valueMap.get("a_number2")[0]);
            logger.info("-----------原始单据附件数------------");

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "a_text1");
            driver.findElement(By.id("a_text1")).sendKeys(valueMap.get("a_text1")[0]);
            logger.info("-----------原始单据附件数------------");

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, ".activitetab > .detail-count");
            driver.findElement(By.cssSelector(".activitetab > .detail-count")).click();

            logger.info("-----------新增费用明细从表------------");

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_date"));
            actions.doubleClick(driver.findElement(By.xpath(util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_date")))).perform();

            util.keyboardNumberInput(valueMap.get("69ea52b9-0976-4643-aa87-4407f2f2baf2"+"1"+"sheet_date")[0]);
            logger.info("-----------点击日期------------");



            logger.info("-----------选择日期------------");

            driver.switchTo().defaultContent();

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_money"));
            driver.findElement(By.xpath(util.getElementXPath("69ea52b9-0976-4643-aa87-4407f2f2baf2", "1", "sheet_money"))).click();
            logger.info("-----------child(7)------------");

            // 模拟键盘输入 10092.909
            util.keyboardNumberInput(valueMap.get("69ea52b9-0976-4643-aa87-4407f2f2baf2"+"1"+"sheet_money")[0]);

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, ".cell:nth-child(8)");
            driver.findElement(By.cssSelector(".cell:nth-child(8)")).click();

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, ".cell:nth-child(8)");
            driver.findElement(By.cssSelector(".cell:nth-child(8)")).click();

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//td[8]/div/span/span");
            driver.findElement(By.xpath("//td[8]/div/span/span")).click();

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "服务票3%");
            driver.findElement(By.linkText("服务票3%")).click();

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, ".cell:nth-child(11)");
            driver.findElement(By.cssSelector(".cell:nth-child(11)")).click();

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//td[11]/input");
            driver.findElement(By.xpath("//td[11]/input")).sendKeys("芳树笼秦栈，春流绕蜀城");

            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, ".cell:nth-child(12)");
            driver.findElement(By.cssSelector(".cell:nth-child(12)")).click();

            // 点击新增从表
             load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".fa-plus-square");
             driver.findElement(By.cssSelector(".fa-plus-square")).click();
             logger.info("点击新增从表");
             
            // 双击 费用科目

             load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//tr[2]/td[4]");
             actions.doubleClick(driver.findElement(By.xpath("//tr[2]/td[4]"))).perform();
            
            // 点击发起
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "form_newWfInstance");
            driver.findElement(By.id("form_newWfInstance")).click();
            // 获取流程名称
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div/div[2]/div/div/div[2]/input");
            String processName = driver.findElement(By.xpath("//div/div[2]/div/div/div[2]/input"))
                    .getAttribute("value");
            // li
            List<WebElement> elements = driver.findElements(By.xpath(
                    "//div[contains(@class,'modalWorkFlow')]//ul[@id='Transmit_userTree' and contains(@class,'ztree')]/li"));

            for (WebElement webElement : elements) {
                // span
                List<WebElement> spanElements = webElement.findElements(By.xpath("//span[@data-nodetype='activity']"));
                for (WebElement webElement2 : spanElements) {
                    if ("部门审核".equals(webElement2.getAttribute("data-activity_name"))
                            && "14d5c31c5f0649".equals(webElement2.getAttribute("data-activity_id"))) {
                        logger.info("ces ");

                        List<WebElement> webElements = webElement
                                .findElements(By.xpath("//span[@data-nodetype='user']"));

                        for (WebElement webElement1 : webElements) {
                            if ("1005118".equals(webElement1.getAttribute("data-user_userid"))) {
                                System.out.println(webElement1.getAttribute("data-user_userid"));
                                System.out.println(webElement1.getAttribute("id"));
                                String spanId = webElement1.getAttribute("id");
                                logger.info(spanId.replace("_span", "_check"));
                                WebElement checkElement = driver.findElement(By.id(spanId.replace("_span", "_check")));
                                logger.info(checkElement.getAttribute("class"));
                                String classValue = checkElement.getAttribute("class");
                                // 判断是否选中,如果没有选择,点击勾选
                                if ("button chk checkbox_false_full".equals(classValue)) {
                                    checkElement.click();
                                }

                            }
                        }

                    }
                }
            }

            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            // 获取表单信息
             ArrayList<RequiredField>
             requiredFields1=util.getFormRequiredField(driver);
             
             
            // 写入表单信息
             ExcelWriter.inputDataExcel(requiredFields1,url);

            logger.info("完成");

        }
        catch (Exception e) {
            System.out.println(e.toString());
            // 失败截图
            // SeleniumUtil.runExceptionScreenshot(driver);
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
