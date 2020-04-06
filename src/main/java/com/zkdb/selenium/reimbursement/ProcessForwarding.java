package com.zkdb.selenium.reimbursement;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;

/**
 * 
 * @ClassName: ProcessForwarding 
 * @Description: TODO(流程批转) 
 * @author tangxiaoyu 
 * @date 2020年3月20日 下午2:00:54 
 *
 */
public class ProcessForwarding {

    

    
    WaitiElementsLoad load = new WaitiElementsLoad();
    Logger logger = Logger.getLogger(ProcessForwarding.class);
    
    /**
     * 
     * @Title: processOperation 
     * @Description: TODO(流程批转) 
     * @param driver
     * @param processName
     * @throws InterruptedException
     */
    public void processOperation(WebDriver driver, String processName) throws InterruptedException {
        //跳转iframe
        
        SeleniumUtil util = new SeleniumUtil();
        //跳转webiframe 验证是否第一次登陆设置在岗状态
        util.verifyOnDuty(driver);
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".fa-tasks");
        //new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("a_number3")));
        driver.findElement(By.cssSelector(".fa-tasks")).click();
        logger.info("-----------点击工作箱------------");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_NAME, "workframe");
        driver.switchTo().frame("workframe");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".working .glyphicon");
        driver.findElement(By.cssSelector(".working .glyphicon")).click();
        logger.info("-----------点击工作箱搜索------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"自定义搜索");
        driver.findElement(By.linkText("自定义搜索")).click();
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[4]/div/div[2]/div/input");
        driver.findElement(By.xpath("//div[4]/div/div[2]/div/input")).click();
        driver.findElement(By.xpath("//div[4]/div/div[2]/div/input")).sendKeys(processName);
        
        logger.info("-----------点击事项标题------------");
        
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".querybtn");
        driver.findElement(By.cssSelector(".querybtn")).click();
        logger.info("-----------点击查询------------");
        Thread.sleep(2000);
        String text="";
        By elementGroup = new By.ByCssSelector(".wftasks .name");
        
        By elementUnclassified = new By.ByCssSelector("#box_data .name");
        
        boolean flag =true; 
        if(util.checkExistsElement(driver, elementGroup)) {
            load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".wftasks .name");
            text=  driver.findElement(By.cssSelector(".wftasks .name")).getText();
            logger.info("-----------分组------------"+text);
            
        }else if (util.checkExistsElement(driver, elementUnclassified)) {
            load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,"#box_data .name");
            text=  driver.findElement(By.cssSelector("#box_data .name")).getText();
            flag=false;
            logger.info("-----------未分组------------"+text);
        }
        
        
        
        
        
        
        //判断是否存在
        if (processName.equals(text)) {
            if (flag) {
                driver.findElement(By.cssSelector(".wftasks .name")).click();
            }
            else {
                driver.findElement(By.cssSelector("#box_data .name")).click();
            }
            
            
            
            String handle= driver.getWindowHandle();

            util.switchWindow(driver);
            Thread.sleep(4000);
            By unreadMessages = new By.ByCssSelector(".close");
            if(util.checkExistsElement(driver, unreadMessages)) {
                logger.info("-----------@未阅消息提醒------------");
                load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".close");
                driver.findElement(By.cssSelector(".close")).click();
            }
            //点击批转
            load.Wait(driver,60,ElementLocateMode.FIND_ELEMENT_ID,"form_transmitNext");
            driver.findElement(By.id("form_transmitNext")).click();
            

            
            
            
            
            
            
            
            
            
            //确定办理
            By  confirmation = new By.ByXPath("//button[contains(text(),'确定办理')] ");
            Thread.sleep(4000);
            if(util.checkExistsElement(driver, confirmation)) {
            load.Wait(driver,40,ElementLocateMode.FIND_ELEMENT_XPATH,"//button[contains(text(),'确定办理')]");
            driver.findElement(By.xpath("//button[contains(text(),'确定办理')]")).click();
            logger.info("-----------确定办理------------");
            }
            
            //如果没有勾选人员会弹出提示信息,然后进行人员选择,再点击办理
            By  element = new By.ByXPath("//span[contains(text(),'确定') and contains(@class,'okbtn')]");
            By promptXpath=new By.ByXPath("//body//div[contains(@class,'modal')]//div[contains(@class,'modal-body')]/div[contains(@class,'modal-alert') and contains(text(),'必须选择接收人')]");
            if(util.checkExistsElement(driver, element)&&util.checkExistsElement(driver, promptXpath)) {
                load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//span[contains(text(),'确定') and contains(@class,'okbtn')]");
                driver.findElement(By.xpath("//span[contains(text(),'确定') and contains(@class,'okbtn')]")).click();
                
                logger.info("-----------选中人员1------------");
                load.Wait(driver,60,ElementLocateMode.FIND_ELEMENT_ID,"Transmit_userTree_2_check");
                driver.findElement(By.id("Transmit_userTree_2_check")).click();
                
                logger.info("-----------选中人员2------------");
                load.Wait(driver,60,ElementLocateMode.FIND_ELEMENT_ID,"Transmit_userTree_5_check");
                driver.findElement(By.id("Transmit_userTree_5_check")).click();
                
                logger.info("-----------选中人员3------------");
                
                load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//button[contains(.,'确定办理')]");
                driver.findElement(By.xpath("//button[contains(.,'确定办理')]")).click();
                logger.info("-----------确定办理------------");
            }
            //流程接收人为自己
            By elBy=new By.ByXPath("//body//div[contains(@class,'modal')]//div[contains(@class,'modal-body')]/div[contains(@class,'modal-confirm') and contains(text(),'您选择的接收人为您自己，系统将为您打开流程继续办理')]");
            logger.info("-----------流程接收人为自己------------");
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(util.checkExistsElement(driver, elBy)) {
                load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//body//div[contains(@class,'modal')]//div[contains(@class,'modal-footer')]//span[contains(@class,'btn-default') and contains(text(),'取消')]");
                driver.findElement(By.xpath("//body//div[contains(@class,'modal')]//div[contains(@class,'modal-footer')]//span[contains(@class,'btn-default') and contains(text(),'取消')]")).click();
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
}
