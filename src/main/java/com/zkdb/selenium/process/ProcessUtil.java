package com.zkdb.selenium.process;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.constant.InitDriver;
import com.zkdb.selenium.reimbursement.ProcessForwarding;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Akashi 流程处理工具类
 */
public class ProcessUtil {

    static SeleniumUtil util = new SeleniumUtil();
    static  WaitiElementsLoad load = new WaitiElementsLoad();
    static Logger logger = Logger.getLogger(ProcessForwarding.class);
    static WebDriver driver = InitDriver.getDriver();

    /**
     * 工作箱流程处理
     */
    public static String workboxProcess(String processName) {
        // 跳转webiframe 验证是否第一次登陆设置在岗状态
        util.verifyOnDuty();
        util.getElement(10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".fa-tasks").click();
        logger.info("-----------点击工作箱------------");

        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_NAME, "workframe");
        driver.switchTo().frame("workframe");


        util.getElement(10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".working .glyphicon").click();
        logger.info("-----------点击工作箱搜索------------");


        util.getElement(ElementLocateMode.FIND_ELEMENT_LINKTEXT,"自定义搜索").click();


        WebElement  workitemname =util.getElement(ElementLocateMode.FIND_ELEMENT_XPATH,"//body//div[@class='advfilter']//div/input[@data-field='workitemname']");
        workitemname.click();
        workitemname.sendKeys(processName);

        logger.info("-----------点击事项标题------------");


        util.getElement(30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".querybtn").click();
        logger.info("-----------点击查询------------");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String text = "";
        By elementGroup = new By.ByCssSelector(".wftasks .name");

        By elementUnclassified = new By.ByCssSelector("#box_data .name");
        WebElement wftasksEle = null;
        WebElement box_data = null;
        boolean flag = true;
        if (util.checkExistsElement(elementGroup)) {

            wftasksEle=util.getElement(30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".wftasks .name");
            text = wftasksEle.getText();
            logger.info("-----------分组------------" + text);

        }
        else if (util.checkExistsElement(elementUnclassified)) {
            box_data=util.getElement(30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,"#box_data .name");
            text = box_data.getText();
            flag = false;
            logger.info("-----------未分组------------" + text);
        }
        String handle = driver.getWindowHandle();
        // 判断是否存在
        if (processName.equals(text)) {
            if (flag) {
                wftasksEle.click();
            }
            else {
                box_data.click();
            }
            util.switchWindow();
            try {
                Thread.sleep(4000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            By unreadMessages = new By.ByCssSelector(".close");
            if (util.checkExistsElement(unreadMessages)) {
                logger.info("-----------@未阅消息提醒------------");
                util.getElement(30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".close").click();
            }
        }
        return handle;
    }

    /**
     * 批准确认办理
     */
    public static void processForwarding() throws InterruptedException {
        // 点击批转
        util.getElement(30,ElementLocateMode.FIND_ELEMENT_ID,"form_transmitNext").click();
        // 确定办理
        By confirmation = new By.ByXPath("//button[contains(.,'确定办理')]");

            Thread.sleep(4000);

        if (util.checkExistsElement(confirmation)) {
            util.getElement(30,ElementLocateMode.FIND_ELEMENT_XPATH,"//button[contains(.,'确定办理')]").click();
            logger.info("-----------确定办理------------");
        }


    }

    /**
     * 任务接收人为自己
     */
    public static void taskRecipientIsSelf(String handle) throws InterruptedException {
        // 流程接收人为自己
        By elBy = new By.ByXPath(
                "//body//div[contains(@class,'modal')]//div[contains(@class,'modal-body')]/div[contains(@class,'modal-confirm') and contains(text(),'您选择的接收人为您自己，系统将为您打开流程继续办理')]");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        logger.info("-----------是否存在接收人为自己------------");
        if (util.checkExistsElement(elBy)) {
            logger.info("-----------查询等待------------");

            util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,
                    "//body//div[contains(@class,'modal')]//div[contains(@class,'modal-footer')]//span[contains(@class,'btn-default') and contains(text(),'取消')]").click();
            logger.info("-----------点击取消------------");
        }

        Thread.sleep(2000);

        driver.switchTo().window(handle);
        logger.info("-----------跳转窗口------------"+handle);

        //刷新页面
        driver.navigate().refresh();
        Thread.sleep(4000);
    }


}
