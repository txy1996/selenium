package com.akashi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverBase {

    private WebDriver driver;
    //构造方法,只要用driver ,就需要调用SelectDriver
    public DriverBase(String browser) {
        SelectDrivar selectDriver = new SelectDrivar();
        //赋值给全局变量driver
        this.driver = selectDriver.driverName(browser);
    }
    
    public WebElement findElement(By by) {
        WebElement element =driver.findElement(by);
        return element;
    }
    
    public void windowsMaxmize() {
        driver.manage().window().maximize();
    }
}
