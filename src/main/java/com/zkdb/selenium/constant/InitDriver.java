package com.zkdb.selenium.constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.zkdb.selenium.util.SeleniumUtil;

public class InitDriver {

    private InitDriver() {}

    /**
     *
     */
    static enum Driver {

        INSTANCE;
        private InitDriver initDriver;
        private  WebDriver driver;
        private Driver() {

            initDriver =new InitDriver();
            driver= new ChromeDriver();
            String url=SeleniumUtil.getPropValue("urlU");
            driver.get(url);
            //driver.manage().window().maximize();

        }
        //初始化
        public WebDriver getDriver() {

            return driver;
        }
    }
    
    public static WebDriver getDriver() {
        return Driver.INSTANCE.getDriver();
    }
}
