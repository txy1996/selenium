package com.zkdb.selenium.tset;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;



public class ExampleForFireFox {

    public static void main(String[] args)  {

        ExampleForFireFox exampleForFireFox = new ExampleForFireFox();
        SelectDrivar selectDrivar = new SelectDrivar();
        WebDriver driver =selectDrivar.driverName("chrome");
        try {
            exampleForFireFox.bepMessageSendingTest(driver);
            closeBrowser(driver);
        }
        catch (Exception e) {
            // TODO: handle exception
            throw e;
        }finally {
            closeBrowser(driver);
        }
        
        
    }
    
    public void bepMessageSendingTest(WebDriver driver) {
        
        driver.get("http://epplus.cn/d/signin_test.jsp");
        driver.manage().window().maximize();
        //定位对象时给 40s 的时间, 如果 40s 内还定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        //页面加载超时时间设置为 20s
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //异步脚本的超时时间设置成 3s
        driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
        Login login = new Login();
        login.setUsername(driver, "15882891378");
        login.setpassWord(driver, "888888");
        login.clickLogin(driver);
        System.out.println("-----------登录开发者账号------------");
        
        
        login.setOrguid(driver, "BEP");
        login.setUsername(driver, "1005118");
        login.setpassWord(driver, "11111111");
        login.clickLogin(driver);

        System.out.println("-----------登录测试账号------------"); 

        driver.switchTo().frame("webiframe");
        System.out.println("---------跳转到iframe(0)--------------");
        
        driver.findElement(By.xpath("//div[@id='sidebar1']/div[5]/i")).click();
        System.out.println("---------点击会话按钮--------------");
        
        driver.findElement(By.xpath("//*[@id=\"sidebar_imchat\"]/li[3]/a")).click();
        System.out.println("---------点击赵云--------------");
        
        driver.switchTo().frame(0);
        System.out.println("---------进入对话页面--------------");
        driver.findElement(By.id("chatmsgtext")).click();
        System.out.println("---------点击对话框--------------");
        
       
        driver.findElement(By.id("chatmsgtext")).sendKeys("测试数据Akashi-selenium<br>");
        System.out.println("----------输入消息------------");
        
        driver.findElement(By.id("sendbutton")).click();
        
        System.out.println("----------点击发送-------------");
        System.out.println("------发送成功----");
        
        System.out.println("------关闭浏览器----");
    }
    
    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }
    
    

}
