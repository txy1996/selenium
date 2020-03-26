package com.akashi.selenium.tset;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.akashi.selenium.Login;

public class ActionSelenium {

    
    public WebDriver driver;
    //初始化
    public void InitDriver() {
        driver = new ChromeDriver();
        driver.get("http://epplus.cn/d/signin_test.jsp");
        driver.manage().window().maximize();
        //定位对象时给 40s 的时间, 如果 40s 内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //页面加载超时时间设置为 20s
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //异步脚本的超时时间设置成 3s
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
    }
    public void CloseBrowser() {
        driver.quit();
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
    
    public void LoanManagementTest() {
        driver.switchTo().frame("webiframe");
        System.out.println("-----------跳转窗口webiframe------------");
        driver.findElement(By.cssSelector("#topbar1 > .item:nth-child(6) > .text")).click();
        System.out.println("-----------点击财务板块------------");
        driver.findElement(By.cssSelector(".submenus:nth-child(1) > .text")).click();
        System.out.println("-----------点击借款管理组------------");
        driver.findElement(By.cssSelector(".active .module:nth-child(1) a")).click();
        System.out.println("-----------点击借款管理模块------------");
        driver.switchTo().frame("page_d45c31f0-a100-4e2b-a757-4df9c3b1b253");
        System.out.println("-----------跳转窗口page_d45c31f0-a100-4e2b-a757-4df9c3b1b253------------");
        driver.findElement(By.id("btnAdd")).click();
        System.out.println("-----------点击借款管理模块添加按钮------------");
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
//            Thread.sleep(20000);
//        }
//        catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        String jsString ="document.querySelector('#group_head_1504845438799 > div > div.row "
                + "> div:nth-child(2) > div > span.input-group-addon').style.display='table-cell'";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //修改页面css元素
        js.executeScript(jsString);
        //点击元素
        driver.findElement(By.cssSelector("#group_head_1504845438799 > div > div.row > div:nth-child(2)"
                + " > div > span.input-group-addon")).click();
        
        driver.findElement(By.linkText("个人借款")).click();
        
        //driver.findElement(By.id("sheet_money")).click();
        driver.findElement(By.id("sheet_money")).sendKeys("1001");
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        driver.findElement(By.id("a_date7")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".mh-last:nth-child(21) > .mh-lunar")).click();
        driver.switchTo().defaultContent();
        //driver.findElement(By.id("a_date7")).sendKeys("2020-03-19");
        //driver.findElement(By.id("proj_id")).sendKeys("Now,we are one！！");
        driver.findElement(By.id("proj_id")).click();
//        String jString1="document.querySelector('#group_body_1504845438799 > div "
//                + "> div:nth-child(1) > div:nth-child(6) > div > span:nth-child(2)')"
//                + ".style.display='table-cell'";
//        js.executeScript(jString1);
        
//        driver.findElement(By.cssSelector("#group_body_1504845438799 > div > div:nth-child(1) > div:nth-child(6) > div > span:nth-child(2)")).click();
//        driver.findElement(By.cssSelector("tr:nth-child(8) > td:nth-child(3)")).click();
//        driver.findElement(By.cssSelector(".btn-primary:nth-child(2)")).click();
//        driver.findElement(By.cssSelector("body > div.modal.in > div > div > div.modal-footer > span:nth-child(1)")).click();
        driver.findElement(By.id("sheet_title")).sendKeys("少罗嗦，你还不如虫子呢！");
        
        driver.findElement(By.id("a_content3")).sendKeys("机动战士高达00");
        driver.findElement(By.id("a_content4")).sendKeys("6222 8900 3322 1114 443");
        driver.findElement(By.id("a_content2")).sendKeys("招商银行成都分行");
        
        driver.findElement(By.id("sheet_remalk")).sendKeys("人生的意义都不同，你需要的是发现属于自己的人生观、价值观。");
        
        driver.findElement(By.cssSelector(".detailbtn > .text")).click();
        //指定文件路径
        StringSelection FileUrl =new StringSelection("C:\\Users\\A1588\\Desktop\\部件测试文档.docx");
        
        
        //把文件复制到剪切板上
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(FileUrl, null);
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
     


        //driver.findElement(By.id("file_1583983109486")).sendKeys("C:\\fakepath\\部件测试文档.docx");
        driver.findElement(By.cssSelector(".modal-footer > .btn-primary")).click();
        driver.findElement(By.id("form_save")).click();
        
    }
}
