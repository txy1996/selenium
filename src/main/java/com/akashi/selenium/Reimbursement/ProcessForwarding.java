package com.akashi.selenium.Reimbursement;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    /**
     * 
     * @throws InterruptedException 
     * @Title: processOperation 
     * @Description: TODO()
     */
    public void processOperation(WebDriver driver, String processName) throws InterruptedException {
        //跳转iframe
        
        SeleniumUtil seleniumUtil = new SeleniumUtil();
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "webiframe");
        driver.switchTo().frame("webiframe");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".fa-tasks");
        //new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("a_number3")));
        driver.findElement(By.cssSelector(".fa-tasks")).click();
        System.out.println("-----------点击工作箱------------");
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_NAME, "workframe");
        driver.switchTo().frame("workframe");
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".working .glyphicon");
        driver.findElement(By.cssSelector(".working .glyphicon")).click();
        System.out.println("-----------点击工作箱搜索------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"自定义搜索");
        driver.findElement(By.linkText("自定义搜索")).click();
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[4]/div/div[2]/div/input");
        driver.findElement(By.xpath("//div[4]/div/div[2]/div/input")).click();
        driver.findElement(By.xpath("//div[4]/div/div[2]/div/input")).sendKeys(processName);
        
        System.out.println("-----------点击事项标题------------");
        
        
        load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".querybtn");
        driver.findElement(By.cssSelector(".querybtn")).click();
        System.out.println("-----------点击查询------------");
        Thread.sleep(2000);
        String text="";
        By elementGroup = new By.ByCssSelector(".wftasks .name");
        
        By elementUnclassified = new By.ByCssSelector("#box_data .name");
        
        boolean flag =true; 
        if(seleniumUtil.checkExistsElement(driver, elementGroup)) {
            load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".wftasks .name");
            text=  driver.findElement(By.cssSelector(".wftasks .name")).getText();
            System.out.println("-----------分组------------"+text);
            
        }else if (seleniumUtil.checkExistsElement(driver, elementUnclassified)) {
            load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,"#box_data .name");
            text=  driver.findElement(By.cssSelector("#box_data .name")).getText();
            flag=false;
            System.out.println("-----------未分组------------"+text);
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
            Set<String> allWindow= driver.getWindowHandles();
            //切換窗口
            for(String Window: allWindow) {
                if(!Window.equals(handle)) {
                    driver.switchTo().window(Window);
                    continue;   
                }
            }
            
            Thread.sleep(4000);
            By unreadMessages = new By.ByCssSelector(".close");
            if(seleniumUtil.checkExistsElement(driver, unreadMessages)) {
                System.out.println("-----------@未阅消息提醒------------");
                load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".close");
                driver.findElement(By.cssSelector(".close")).click();
            }
            //点击批转
            load.Wait(driver,60,ElementLocateMode.FIND_ELEMENT_ID,"form_transmitNext");
            driver.findElement(By.id("form_transmitNext")).click();
            

            
            
            
            
            
            
            
            
            
            //确定办理
            By  Confirmation = new By.ByXPath("//button[contains(.,'确定办理')]");
            Thread.sleep(4000);
            if(seleniumUtil.checkExistsElement(driver, Confirmation)) {
            load.Wait(driver,40,ElementLocateMode.FIND_ELEMENT_XPATH,"//button[contains(.,'确定办理')]");
            driver.findElement(By.xpath("//button[contains(.,'确定办理')]")).click();
            System.out.println("-----------确定办理------------");
            }
            
            //如果没有勾选人员会弹出提示信息,然后进行人员选择,再点击办理
            By  element = new By.ByXPath("//span[contains(.,'确定')]");
            if(seleniumUtil.checkExistsElement(driver, element)) {
                load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//span[contains(.,'确定')]");
                driver.findElement(By.xpath("//span[contains(.,'确定')]")).click();
                
                System.out.println("-----------选中人员1------------");
                load.Wait(driver,60,ElementLocateMode.FIND_ELEMENT_ID,"Transmit_userTree_2_check");
                driver.findElement(By.id("Transmit_userTree_2_check")).click();
                
                System.out.println("-----------选中人员2------------");
                load.Wait(driver,60,ElementLocateMode.FIND_ELEMENT_ID,"Transmit_userTree_5_check");
                driver.findElement(By.id("Transmit_userTree_5_check")).click();
                
                System.out.println("-----------选中人员3------------");
                
                load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//button[contains(.,'确定办理')]");
                driver.findElement(By.xpath("//button[contains(.,'确定办理')]")).click();
                System.out.println("-----------确定办理------------");
            }
            
            Thread.sleep(2000);
            //System.out.println("-----------跳转窗口------------"+driver.getWindowHandle());
            driver.switchTo().window(handle);
            System.out.println("-----------跳转窗口------------"+handle);

            //刷新页面
            driver.navigate().refresh();
            Thread.sleep(4000);
            
            
        }
        
    }
}
