package com.akashi.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    public Login() {
        
    }
    public void setOrguid(WebDriver driver,String orguid) {
        WebElement orguidWeb = driver.findElement(By.id("signin-orguid"));
        orguidWeb.sendKeys(orguid);
        
    }
    public void setUsername(WebDriver driver,String userName) {
        WebElement userNameWeb = driver.findElement(By.id("signin-name"));
        userNameWeb.sendKeys(userName);
    }
    
    public void setpassWord(WebDriver driver,String passWord) {
        WebElement passWordWeb = driver.findElement(By.id("signin-pass"));
        passWordWeb.sendKeys(passWord);
    }
    
    public void clickLogin(WebDriver driver) {
        WebElement loginbtn=driver.findElement(By.id("signin-submit"));
        loginbtn.click();
    }
    
    public void clickCancel(WebDriver driver) {
        WebElement loginbtn=driver.findElement(By.xpath("//input[@value='取 消']"));
        loginbtn.click();//点击登录按钮
    }
    public void clickEvent(WebDriver driver,String element) {
        WebElement loginbtn=driver.findElement(By.id(element));
        loginbtn.click();
    }
}
