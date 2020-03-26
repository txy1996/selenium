package com.zkdb.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitDriverU {

    private InitDriverU() {}
    
    static enum InitDriver {

        INSTANCE;
        private InitDriverU initDriverU;
        
        private InitDriver() {
            initDriverU =new InitDriverU();
        }
        //初始化
        public WebDriver getDriver() {
            
            WebDriver driver = new ChromeDriver();
            driver.get(SeleniumUtil.getPropValue("url"));
            driver.manage().window().maximize();
            return driver;
        }
    }
    
    public static WebDriver getDriver() {
        return InitDriver.INSTANCE.getDriver();
    }
}
