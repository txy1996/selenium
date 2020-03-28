package com.zkdb.selenium.util;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 
 * @ClassName: InitDriver 
 * @Description: TODO(初始化Driver) 
 * @author tangxiaoyu 
 * @date 2020年3月18日 下午2:10:12 
 *
 */
public enum InitDriver {

    INSTANCE;
    //初始化
    public WebDriver getDriver() {
        String url=SeleniumUtil.getPropValue("url");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().window().maximize();
        return driver;
    }
    
    
    
}
