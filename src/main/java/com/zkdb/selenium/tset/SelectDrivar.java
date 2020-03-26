package com.zkdb.selenium.tset;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDrivar {

    public WebDriver driverName(String browser) {
        
        if(browser.equalsIgnoreCase("chrome")) {

            WebDriver driver = new ChromeDriver();
            return driver;
        }else if (browser.equalsIgnoreCase("firefox")) {
           
            WebDriver driver = new FirefoxDriver();
            return driver;
        }
        return null;
        
    }
    
    public static void testWait2(WebDriver driver)
    {
        driver.get("E:\\StashFolder\\huoli_28@hotmail.com\\Stash\\Tank-MoneyProject\\浦东软件园培训中心\\我的教材\\Selenium Webdriver\\set_timeout.html");    
        
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".red_box")));
        WebElement element = driver.findElement(By.cssSelector(".red_box"));      
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border = \"5px solid yellow\"",element);  
    }
}
