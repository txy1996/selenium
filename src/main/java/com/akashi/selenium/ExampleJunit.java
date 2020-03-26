//package com.akashi.selenium;
//
//import java.util.List;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class ExampleJunit  {
//
//    static WebDriver driver;
//
//    @BeforeClass
//    public static void init() {
//        System.out.println("init...");
//        // 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
//        System.setProperty("webdriver.firefox.bin", "C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\Application\\\\chromedriver.exe");
//        // 创建一个 FireFox 的浏览器实例
//        driver = new ChromeDriver();
//    }
//
//    @Test
//    public void test() {
//        // 让浏览器访问 zTree Demo
//        driver.get("http://epplus.cn/d/signin_test.jsp");
//        driver.manage().window().maximize();
//
//        Login login = new Login();
//
//        login.setOrguid(driver, "BEP");
//        login.setUsername(driver, "1005118");
//        login.clickLogin(driver);
//
//        try {
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//            System.out.println("登录成功，首页获取元素失败");
//        }
//
//        destory();
//
//
//    }
//
//    @AfterClass
//    public static void destory() {
//        System.out.println("destory...");
//        //关闭浏览器
//        driver.quit();
//    }
//
//
//
//}
//package com.akashi.selenium;
//
//import java.util.List;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class ExampleJunit  {
//
//    static WebDriver driver;
//
//    @BeforeClass
//    public static void init() {
//        System.out.println("init...");
//        // 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
//        System.setProperty("webdriver.firefox.bin", "C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\Application\\\\chromedriver.exe");
//        // 创建一个 FireFox 的浏览器实例
//        driver = new ChromeDriver();
//    }
//
//    @Test
//    public void test() {
//        // 让浏览器访问 zTree Demo
//        driver.get("http://epplus.cn/d/signin_test.jsp");
//        driver.manage().window().maximize();
//
//        Login login = new Login();
//
//        login.setOrguid(driver, "BEP");
//        login.setUsername(driver, "1005118");
//        login.clickLogin(driver);
//
//        try {
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//            System.out.println("登录成功，首页获取元素失败");
//        }
//
//        destory();
//
//
//    }
//
//    @AfterClass
//    public static void destory() {
//        System.out.println("destory...");
//        //关闭浏览器
//        driver.quit();
//    }
//
//
//
//}
//package com.akashi.selenium;
//
//import java.util.List;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class ExampleJunit  {
//
//    static WebDriver driver;
//
//    @BeforeClass
//    public static void init() {
//        System.out.println("init...");
//        // 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
//        System.setProperty("webdriver.firefox.bin", "C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\Application\\\\chromedriver.exe");
//        // 创建一个 FireFox 的浏览器实例
//        driver = new ChromeDriver();
//    }
//
//    @Test
//    public void test() {
//        // 让浏览器访问 zTree Demo
//        driver.get("http://epplus.cn/d/signin_test.jsp");
//        driver.manage().window().maximize();
//
//        Login login = new Login();
//
//        login.setOrguid(driver, "BEP");
//        login.setUsername(driver, "1005118");
//        login.clickLogin(driver);
//
//        try {
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//            System.out.println("登录成功，首页获取元素失败");
//        }
//
//        destory();
//
//
//    }
//
//    @AfterClass
//    public static void destory() {
//        System.out.println("destory...");
//        //关闭浏览器
//        driver.quit();
//    }
//
//
//
//}
//package com.akashi.selenium;
//
//import java.util.List;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class ExampleJunit  {
//
//    static WebDriver driver;
//
//    @BeforeClass
//    public static void init() {
//        System.out.println("init...");
//        // 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
//        System.setProperty("webdriver.firefox.bin", "C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\Application\\\\chromedriver.exe");
//        // 创建一个 FireFox 的浏览器实例
//        driver = new ChromeDriver();
//    }
//
//    @Test
//    public void test() {
//        // 让浏览器访问 zTree Demo
//        driver.get("http://epplus.cn/d/signin_test.jsp");
//        driver.manage().window().maximize();
//
//        Login login = new Login();
//
//        login.setOrguid(driver, "BEP");
//        login.setUsername(driver, "1005118");
//        login.clickLogin(driver);
//
//        try {
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException e) {
//            // TODO: handle exception
//            e.printStackTrace();
//            System.out.println("登录成功，首页获取元素失败");
//        }
//
//        destory();
//
//
//    }
//
//    @AfterClass
//    public static void destory() {
//        System.out.println("destory...");
//        //关闭浏览器
//        driver.quit();
//    }
//
//
//
//}
