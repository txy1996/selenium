package com.akashi.selenium.Reimbursement;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    
    public String reimbursementPositioningExpenses(WebDriver driver) {
        
        SeleniumUtil util = new SeleniumUtil();
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "webiframe");
        driver.switchTo().frame("webiframe");

        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"财务事项申请");
        driver.findElement(By.linkText("财务事项申请")).click();
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"费用报销");
        driver.findElement(By.linkText("费用报销")).click();
        
        String handle= driver.getWindowHandle();
        Set<String> allWindow= driver.getWindowHandles();
        //切換窗口
        for(String Window: allWindow) {
            if(!Window.equals(handle)) {
                driver.switchTo().window(Window);
                continue;   
            }
        }
        
        
        
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
        System.out.println("-----------点击费用报销支出类型------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,"#group_head_1504769941216 > div > div.row > div > div > span.input-group-addon");
        driver.findElement(By.cssSelector("#group_head_1504769941216 > div > div.row > div > div > span.input-group-addon")).click();
        System.out.println("-----------点击费用报销支出类型------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,"其他费用");
        driver.findElement(By.linkText("其他费用")).click();
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"a_org_code3");
        driver.findElement(By.id("a_org_code3")).click();
        System.out.println("-----------点击费用科目------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,"#group_body_1504769941216 > div > div:nth-child(1) > div:nth-child(4) > div > span.input-group-addon");
        driver.findElement(By.cssSelector("#group_body_1504769941216 > div > div:nth-child(1) > div:nth-child(4) > div > span.input-group-addon")).click();
        
        System.out.println("-----------点击费用报销支出类型------------");
        

        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,"tr:nth-child(6) > td:nth-child(3)");
        driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(3)")).click();
        System.out.println("-----------点击通讯费------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn:nth-child(1)");
        driver.findElement(By.cssSelector(".modal-footer > .btn:nth-child(1)")).click();
        System.out.println("-----------点击确定------------");

        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"sheet_title");
        driver.findElement(By.id("sheet_title"))
        .sendKeys("少女祈祷中…");
        System.out.println("-----------支出事由------------");
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"a_number2");
        driver.findElement(By.id("a_number2"))
        .sendKeys("2");
        System.out.println("-----------原始单据附件数------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"a_text1");
        driver.findElement(By.id("a_text1"))
        .sendKeys("瞿塘嘈嘈十二滩，此中道路古来难。长恨人心不如水，等闲平地起波澜。");
        System.out.println("-----------原始单据附件数------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".activitetab > .detail-count");
        driver.findElement(By.cssSelector(".activitetab > .detail-count")).click();
        
        System.out.println("-----------新增费用明细从表------------");
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell:nth-child(6)");
        driver.findElement(By.cssSelector(".cell:nth-child(6)")).click();
        
        System.out.println("-----------点击日期------------");
        
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell .glyphicon");
        driver.findElement(By.cssSelector(".cell .glyphicon")).click();
        
        
        //跳转窗体
        driver.switchTo().frame(0);
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".mh-today > .mh-solar");
        driver.findElement(By.cssSelector(".mh-today > .mh-solar")).click();
        
        System.out.println("-----------选择日期------------");
        
        driver.switchTo().defaultContent();
        
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".cell:nth-child(7)");
        driver.findElement(By.cssSelector(".cell:nth-child(7)")).click();
        System.out.println("-----------child(7)------------");
        
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
        

        
        System.out.println("-----------准备上传------------"+System.currentTimeMillis());
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary");
        driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
        System.currentTimeMillis();
        System.out.println("-----------开始上传------------"+System.currentTimeMillis());
        
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("form_newWfInstance")));
        System.out.println("-----------文件上传完毕------------"+System.currentTimeMillis());
        
        //点击发起
        driver.findElement(By.id("form_newWfInstance")).click();
        //获取流程名称
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_XPATH,"//div/div[2]/div/div/div[2]/input");
        String processName= driver.findElement(By.xpath("//div/div[2]/div/div/div[2]/input")).getAttribute("value");
        
        System.out.println("-----------元素------------"+processName);

        

        System.out.println("-----------确认发起------------");
        
        
        //点击发起
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary");
        driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
        System.out.println("-----------发起成功------------");

        
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
