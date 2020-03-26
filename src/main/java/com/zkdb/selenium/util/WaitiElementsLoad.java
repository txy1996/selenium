package com.zkdb.selenium.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @ClassName: WaitiElementsLoad 
 * @Description: TODO(元素等待-显示等待) 
 * @author tangxiaoyu 
 * @date 2020年3月18日 下午3:11:11 
 *
 */
public class WaitiElementsLoad {
    
    
    //显示等待方法
    
    public void Wait(WebDriver driver,int time,ElementLocateMode locateMode,String position ) {
      //显示等待
        Logger logger= Logger.getLogger(WaitiElementsLoad.class);
        logger.info("等待");
        WebDriverWait wait= new WebDriverWait(driver, time);
        switch (locateMode) {
            case FIND_ELEMENT_ID:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(position)));
                break;
            case FIND_ELEMENT_NAME:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(position)));
                break;
                
            case FIND_ELEMENT_CLASSNAME:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(position)));
                break;
            case FIND_ELEMENT_TAGNAME:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(position)));
                break;
            case FIND_ELEMENT_LINKTEXT:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(position)));
                break;
            case FIND_ELEMENT_PARTIALLINKTEXT:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(position)));
                break;
            case FIND_ELEMENT_XPATH:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(position)));
                break;
                
            case FIND_ELEMENT_CSSSELECTOR:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(position)));
                break;
            default:
                break;
        }
        
    }
}
