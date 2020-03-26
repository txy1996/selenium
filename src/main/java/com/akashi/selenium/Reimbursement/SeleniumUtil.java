package com.akashi.selenium.Reimbursement;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @ClassName: SeleniumUtil 
 * @Description: TODO(工具类) 
 * @author tangxiaoyu 
 * @date 2020年3月23日 下午3:57:05 
 *
 */
public class SeleniumUtil {

    /**
     * 
     * @Title: checkExistsElement 
     * @Description: TODO(判断元素是否存在) 
     * @param driver
     * @param element
     * @return boolean
     */
    public boolean checkExistsElement(WebDriver driver,By element) {
        try {
            driver.findElement(element);
            return true;
        }
        catch (Exception e) {
            // TODO: handle exception
            return false;
        }
           
    }
    
    /**
     * 
     * @Title: keyboardNumberInput 
     * @Description: TODO(模拟数字输入) 
     * @param number
     */
    public void keyboardNumberInput(float number) {
        Robot robot;
        try {
            robot = new Robot();
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 按下回车
            robot.keyPress(KeyEvent.VK_ENTER);
            // 释放回车
            robot.keyRelease(KeyEvent.VK_ENTER);
          
            // 按下 CTRL+A
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
               
            // 释放 CTRL+A
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_A);
        String numString=String.valueOf(number);
        
        char[] nums = numString.toCharArray();
        
        
        for (char c : nums) {
            switch (c) {
                case '0':
                    robot.keyPress(KeyEvent.VK_0);
                    robot.keyRelease(KeyEvent.VK_0);
                    break;
                case '1':
                    robot.keyPress(KeyEvent.VK_1);
                    robot.keyRelease(KeyEvent.VK_1);
                    break;
                case '2':
                    robot.keyPress(KeyEvent.VK_2);
                    robot.keyRelease(KeyEvent.VK_2);
                    break;
                case '3':
                    robot.keyPress(KeyEvent.VK_3);
                    robot.keyRelease(KeyEvent.VK_3);
                    break;
                case '4':
                    robot.keyPress(KeyEvent.VK_4);
                    robot.keyRelease(KeyEvent.VK_4);
                    break;
                case '5':
                    robot.keyPress(KeyEvent.VK_5);
                    robot.keyRelease(KeyEvent.VK_5);
                    break;
                case '6':
                    robot.keyPress(KeyEvent.VK_6);
                    robot.keyRelease(KeyEvent.VK_6);
                    break;
                case '7':
                    robot.keyPress(KeyEvent.VK_7);
                    robot.keyRelease(KeyEvent.VK_7);
                    break;
                case '8':
                    robot.keyPress(KeyEvent.VK_8);
                    robot.keyRelease(KeyEvent.VK_8);
                    break;
                case '9':
                    robot.keyPress(KeyEvent.VK_9);
                    robot.keyRelease(KeyEvent.VK_9);
                    break;
                case '.':
                    robot.keyPress(KeyEvent.VK_DECIMAL);
                    robot.keyRelease(KeyEvent.VK_DECIMAL);
                    break;
                case '-':
                    robot.keyPress(KeyEvent.VK_SUBTRACT);
                    robot.keyRelease(KeyEvent.VK_SUBTRACT);
                    break;
                    
                default:
                    break;
            } 
        }
        
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                      
            // 点击回车 Enter 
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        catch (AWTException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
