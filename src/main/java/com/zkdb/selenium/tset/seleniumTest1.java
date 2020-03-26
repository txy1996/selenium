package com.zkdb.selenium.tset;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zkdb.selenium.util.InitDriver;

public class seleniumTest1 {
    
    public final static String FIND_ELEMENT_ID="ID";
    public final static String FIND_ELEMENT_NAME="NAME";
    public final static String FIND_ELEMENT_CLASSNAME="CLASSNAME";
    public final static String FIND_ELEMENT_TAGNAME="TAGNAME";
    public final static String FIND_ELEMENT_LINKTEXT="LINKTEXT";
    public final static String FIND_ELEMENT_PARTIALLINKTEXT="PARTIALLINKTEXT";
    public final static String FIND_ELEMENT_XPATH="XPATH";
    public final static String FIND_ELEMENT_CSSSELECTOR="CSSSELECTOR";

    
//    public WebDriver driver;
//    //初始化
//    public void InitDriver() {
//        driver = new ChromeDriver();
//        driver.get("http://epplus.cn/d/signin_test.jsp");
//        driver.manage().window().maximize();
//
//    }
    WebDriver driver = InitDriver.INSTANCE.getDriver();
    //关闭浏览器
    public void CloseBrowser() {
        driver.quit();
    }
    
    //显示等待方法
    public void Wait(int time,String target,String position ) {
      //显示等待
        System.out.println("-----------等待------------");
        WebDriverWait wait= new WebDriverWait(driver, time);
        switch (target) {
            case FIND_ELEMENT_ID:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(position)));
                break;
            case FIND_ELEMENT_NAME:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(position)));
                break;
                
            case FIND_ELEMENT_CLASSNAME:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(position)));
                break;
            case FIND_ELEMENT_TAGNAME:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(position)));
                break;
            case FIND_ELEMENT_LINKTEXT:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(position)));
                break;
            case FIND_ELEMENT_PARTIALLINKTEXT:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(position)));
                break;
            case FIND_ELEMENT_XPATH:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(position)));
                break;
                
            case FIND_ELEMENT_CSSSELECTOR:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(position)));
                break;
            default:
                break;
        }
        
    }
    //登录
    public void Login() {
        Login login = new Login();
        login.setUsername(driver, "15882891378");
        login.setpassWord(driver, "888888");
        login.clickLogin(driver);
        System.out.println("-----------登录开发者账号------------");
        //等待两秒
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        login.setOrguid(driver, "BEP");
        login.setUsername(driver, "1005118");
        login.setpassWord(driver, "11111111");
        login.clickLogin(driver);
        
        System.out.println("-----------登录测试账号------------"); 
    }
    //跳转窗口,填写表单
    public void LoanManagementTest() {
        Wait(60,FIND_ELEMENT_ID,"webiframe");
        driver.switchTo().frame("webiframe");
        
        System.out.println("-----------跳转窗口webiframe------------");
        Wait(10,FIND_ELEMENT_CSSSELECTOR,"#topbar1 > .item:nth-child(6) > .text");
        driver.findElement(By.cssSelector("#topbar1 > .item:nth-child(6) > .text")).click();
        
        System.out.println("-----------点击财务板块------------");
        Wait(10,FIND_ELEMENT_CSSSELECTOR,".submenus:nth-child(1) > .text");
        driver.findElement(By.cssSelector(".submenus:nth-child(1) > .text")).click();
        
        System.out.println("-----------点击借款管理组------------");
        Wait(10,FIND_ELEMENT_CSSSELECTOR,".active .module:nth-child(1) a");
        driver.findElement(By.cssSelector(".active .module:nth-child(1) a")).click();
        
        System.out.println("-----------点击借款管理模块------------");
        Wait(10,FIND_ELEMENT_ID,"page_d45c31f0-a100-4e2b-a757-4df9c3b1b253");
        driver.switchTo().frame("page_d45c31f0-a100-4e2b-a757-4df9c3b1b253");
        
        System.out.println("-----------跳转窗口page_d45c31f0-a100-4e2b-a757-4df9c3b1b253------------");
        Wait(10,FIND_ELEMENT_ID,"btnAdd");
        driver.findElement(By.id("btnAdd")).click();
       
        System.out.println("-----------点击借款管理模块添加按钮------------");
        Wait(10,FIND_ELEMENT_ID,"btnAdd");
        String handle= driver.getWindowHandle();
        Set<String> allWindow= driver.getWindowHandles();
        //切換窗口
        for(String Window: allWindow) {
            if(!Window.equals(handle)) {
                driver.switchTo().window(Window);
                continue;   
            }
        }
        
//      //等待两秒
//        try {
//            Thread.sleep(2000);
//        }
//        catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        Wait(20,FIND_ELEMENT_CSSSELECTOR,"#group_head_1504845438799 > div > div.row > div:nth-child(2)" + 
                " > div > span.input-group-addon");
        
        String jsString ="document.querySelector('#group_head_1504845438799 > div > div.row "
                + "> div:nth-child(2) > div > span.input-group-addon').style.display='table-cell'";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //修改页面css元素
        js.executeScript(jsString);
        //点击元素
       
        
        
        driver.findElement(By.cssSelector("#group_head_1504845438799 > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > span:nth-child(2)")).click();
        
        Wait(10,FIND_ELEMENT_LINKTEXT,"个人借款");
        driver.findElement(By.linkText("个人借款")).click();
        Wait(10,FIND_ELEMENT_ID,"sheet_money");

        driver.findElement(By.id("sheet_money")).sendKeys("1001");
        Wait(10,FIND_ELEMENT_ID,"a_date7");

        driver.findElement(By.id("a_date7")).click();
        
        driver.switchTo().frame(0);
        Wait(10,FIND_ELEMENT_CSSSELECTOR,".mh-last:nth-child(21) > .mh-lunar");
        driver.findElement(By.cssSelector(".mh-last:nth-child(21) > .mh-lunar")).click();
        
        driver.switchTo().defaultContent();
        Wait(10,FIND_ELEMENT_ID,"proj_id");
        driver.findElement(By.id("proj_id")).click();
        
        Wait(10,FIND_ELEMENT_ID,"sheet_title");
        driver.findElement(By.id("sheet_title")).sendKeys("Ex - ploooosion !");
        Wait(10,FIND_ELEMENT_ID,"a_content3");
        driver.findElement(By.id("a_content3")).sendKeys("机动战士高达00");
        Wait(10,FIND_ELEMENT_ID,"a_content4");
        driver.findElement(By.id("a_content4")).sendKeys("6222 8900 3322 1114 443");
        Wait(10,FIND_ELEMENT_ID,"a_content2");
        driver.findElement(By.id("a_content2")).sendKeys("招商银行成都分行");
        Wait(10,FIND_ELEMENT_ID,"sheet_remalk");
        driver.findElement(By.id("sheet_remalk")).sendKeys("人生的意义都不同，你需要的是发现属于自己的人生观、价值观。");
        Wait(10,FIND_ELEMENT_CSSSELECTOR,".detailbtn > .text");
        driver.findElement(By.cssSelector(".detailbtn > .text")).click();
        
        //指定文件路径
        StringSelection FileUrl =new StringSelection("C:\\Users\\A1588\\Desktop\\部件测试文档.docx");
        
        
        //把文件复制到剪切板上
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(FileUrl, null);
        //键盘模拟,上传文件
        Robot robot;
        try {
            robot = new Robot();
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         // 按下回车
            robot.keyPress(KeyEvent.VK_ENTER);
               
            // 释放回车
            robot.keyRelease(KeyEvent.VK_ENTER);
               
            // 按下 CTRL+V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
               
            // 释放 CTRL+V
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                      
            // 点击回车 Enter 
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        catch (AWTException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
     


        System.out.println("-----------准备上传------------"+System.currentTimeMillis());
        Wait(10,FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary");
        driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
        System.currentTimeMillis();
        System.out.println("-----------开始上传------------"+System.currentTimeMillis());
        
        //Wait(10,FIND_ELEMENT_ID,"form_save");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("form_save")));
        System.out.println("-----------文件上传完毕------------"+System.currentTimeMillis());
        driver.findElement(By.id("form_save")).click();
        
        
    }
}
