package com.zkdb.selenium.constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.zkdb.selenium.util.SeleniumUtil;

public class InitDriverU {

    private InitDriverU() {}
    
    static enum InitDriver {

        INSTANCE;
        private InitDriverU initDriverU;
        private  WebDriver driver;
        private InitDriver() {

            initDriverU =new InitDriverU();
            driver= new ChromeDriver();
            String url=SeleniumUtil.getPropValue("urlU");
            driver.get(url);
            driver.manage().window().maximize();

        }
        //初始化
        public WebDriver getDriver() {

            return driver;
        }
    }
    
    public static WebDriver getDriver() {
        return InitDriver.INSTANCE.getDriver();
    }
}
