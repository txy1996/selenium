package com.zkdb.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zkdb.selenium.constant.ElementLocateMode;

/**
 * 
 * @ClassName: Login 
 * @Description: TODO(系统登录用) 
 * @author tangxiaoyu 
 * @date 2020年3月18日 下午2:02:31 
 *
 */
public class Login {
    
    WaitiElementsLoad load = new WaitiElementsLoad();
    
public Login() {
        
    }
    //设置企业号
    public void setOrguid(WebDriver driver,String orguid) {
        WebElement orguidWeb = driver.findElement(By.id("signin-orguid"));
        orguidWeb.sendKeys(orguid);
        
    }
    //设置用户名
    public void setUsername(WebDriver driver,String userName) {
        WebElement userNameWeb = driver.findElement(By.id("signin-name"));
        userNameWeb.sendKeys(userName);
    }
    //设置密码
    public void setpassWord(WebDriver driver,String passWord) {
        WebElement passWordWeb = driver.findElement(By.id("signin-pass"));
        passWordWeb.sendKeys(passWord);
    }
    //点击提交
    public void clickLogin(WebDriver driver) {
        WebElement loginbtn=driver.findElement(By.id("signin-submit"));
        loginbtn.click();
    }
    //点击取消
    public void clickCancel(WebDriver driver) {
        WebElement loginbtn=driver.findElement(By.xpath("//input[@value='取 消']"));
        loginbtn.click();//点击登录按钮
    }
    public void clickEvent(WebDriver driver,String element) {
        WebElement loginbtn=driver.findElement(By.id(element));
        loginbtn.click();
    }
    /**
     * 
     * @Title: loginDevelopmentAccount 
     * @Description: TODO(登陆开发者账号) 
     * @param driver
     * @param account 
     * @param passWord
     */
    public void loginDevelopmentAccount(WebDriver driver,String account,String passWord) {
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "signin-name");
        setUsername(driver, account);
        setpassWord(driver, passWord);
        clickLogin(driver);
    }
    /**
     * 
     * @Title: loginTestAccount 
     * @Description: TODO(登陆测试账号) 
     * @param driver 
     * @param orguid
     * @param userName
     * @param passWord
     */
    public void loginTestAccount(WebDriver driver,String orguid,String userName,String passWord) {
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "signin-orguid");
        setOrguid(driver, orguid);
        setUsername(driver, userName);
        setpassWord(driver, passWord);
        clickLogin(driver);
        
    }
    
    /**
     * @Title: loginAccount 
     * @Description: TODO(登陆账号) 
     * @param driver
     * @param orguid
     * @param userName
     * @param passWord
     */
    public void loginAccount(WebDriver driver,String orguid,String userName,String passWord) {
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "resetorguid");
        driver.findElement(By.id("resetorguid")).click();
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "signin-orguid");
        setOrguid(driver, orguid);
        setUsername(driver, userName);
        setpassWord(driver, passWord);
        clickLogin(driver);
    }
    
}
