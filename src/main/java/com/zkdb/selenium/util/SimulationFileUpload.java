package com.zkdb.selenium.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
/**
 * 
 * @ClassName: SimulationFileUpload 
 * @Description: TODO(模拟文件上传) 
 * @author tangxiaoyu 
 * @date 2020年3月18日 下午3:20:18 
 *
 */
public class SimulationFileUpload {

    public void fileUpload(String fileUrl) {
      //指定文件路径
        StringSelection FileUrl =new StringSelection(fileUrl);
        
        
        //把文件复制到剪切板上
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(FileUrl, null);
        //键盘模拟,上传文件
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
               
            // 按下 CTRL+V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
               
            // 释放 CTRL+V
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
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
