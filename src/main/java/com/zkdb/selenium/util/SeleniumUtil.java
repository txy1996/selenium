package com.zkdb.selenium.util;

import static org.hamcrest.CoreMatchers.nullValue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zkdb.selenium.reimbursement.RequiredField;
import com.zkdb.selenium.vo.UserAccountVO;

/**
 * 
 * @ClassName: SeleniumUtil 
 * @Description: TODO(selenium工具类) 
 * @author tangxiaoyu 
 * @date 2020年3月23日 下午3:57:05 
 *
 */
public class SeleniumUtil {

    private static final String DEFAULT_PROPERTIES="/url.properties";
    static Logger logger =Logger.getLogger(SeleniumUtil.class);
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
    
    /**
     * 
     * @Title: getFormRequiredField 
     * @Description: TODO(获取表单必填字段) 
     * @param driver
     * @return
     */
    public ArrayList<RequiredField> getFormRequiredField(WebDriver driver) {
        //
//        RequiredField requiredField;
        
        ArrayList<RequiredField> requiredFields = new ArrayList<>();
        //获取所有input 标签
        List<WebElement> elements =driver.findElements(By.xpath("//div[contains(@class,'input-group')]//*[contains(@class,'form-control')]"));
        //获取主表的数据集id 
        String id= driver.findElement(By.cssSelector("#data_panel")).getAttribute("data-dataid");
        for (WebElement webElement : elements) {
           
            //获取data-required 属性等于 1 获取必填字段
            if ("1".equals(webElement.getAttribute("data-required"))&&webElement.isDisplayed()
                    &&webElement.isEnabled()) {
                
                coreDataInput(driver,webElement,requiredFields,id,AttributesEnum.Required.getValue());
                
                //只读
            }else if ("1".equals(webElement.getAttribute("data-readonly"))&&webElement.isDisplayed()) {
                
                coreDataInput(driver,webElement,requiredFields,id,AttributesEnum.Readonly.getValue());
                //可填
            }else if(!"1".equals(webElement.getAttribute("data-readonly"))
                    &&!"1".equals(webElement.getAttribute("data-required"))
                    &&webElement.isDisplayed()){
                coreDataInput(driver,webElement,requiredFields,id,AttributesEnum.Fillable.getValue());
                //不可见
            }else if (("1".equals(webElement.getAttribute("data-readonly"))
                    ||!"1".equals(webElement.getAttribute("data-required")))
                    &&!webElement.isDisplayed()&&webElement.getAttribute("data-field")!=null) {
                coreDataInput(driver,webElement,requiredFields,id,AttributesEnum.Invisible.getValue());
            }
            
            
            
        }
        

        List<WebElement> elementsCBdate=driver.findElements(By.className("detailData"));
        
        for (WebElement webElement : elementsCBdate) {
            List<WebElement> elementsCB =webElement.findElements(By.className("ui-resizable"));
            for (WebElement webElement1 : elementsCB) {
                //获取从表必填字段
                if ("1".equals(webElement1.getAttribute("data-required"))) {
                    
                   secondaryDataInput(driver,webElement,webElement1,requiredFields,AttributesEnum.Required.getValue());
                   //只读
                }else if ("1".equals(webElement1.getAttribute("data-readonly"))) {
                    
                    secondaryDataInput(driver,webElement,webElement1,requiredFields,AttributesEnum.Readonly.getValue());
                    
                    //可填
                }else if(!"1".equals(webElement.getAttribute("data-readonly"))
                        &&!"1".equals(webElement.getAttribute("data-required"))
                        ) {
                    secondaryDataInput(driver,webElement,webElement1,requiredFields,AttributesEnum.Fillable.getValue());
                    //不可见
                }else if ("1".equals(webElement.getAttribute("data-readonly"))&&!webElement.isDisplayed()) {
                    secondaryDataInput(driver,webElement,webElement1,requiredFields,AttributesEnum.Invisible.getValue());
                }
                
            }
        }

        return requiredFields;
    }
    
    
    /**
     * 
     * @Title: coreDataInput 
     * @Description: TODO(主表数据填充) 
     * @param driver
     * @param webElement
     * @param requiredFields
     * @param id
     */
    public static void coreDataInput(WebDriver driver,WebElement webElement,ArrayList<RequiredField> requiredFields,String id,String attributes) {
        String dateId;
        String field;
        String fieldName;
        String length=null;
        String decimalPlaces=null;
        String fieldValue=null;
        String fieldDicValue=null;
        
        dateId=id;
        //获取满足 条件的 input 标签的 id属性值
        field=webElement.getAttribute("id");
        if(!field.equals("")&&field!=null) {
          //获取字段中文名称
            fieldName=driver.findElement(By.id("lab_"+field)).getAttribute("innerText");
            //字段长度
            length =webElement.getAttribute("maxlength");
            
            
            //几位小数
            decimalPlaces= webElement.getAttribute("data-decimalplaces");
            //logger.info(decimalPlaces+"小数位数"+field);
            //字段值
            fieldValue=webElement.getAttribute("value");
            //字典值
            fieldDicValue=webElement.getAttribute("selvalue");
            requiredFields.add(new  RequiredField(dateId,field,fieldName,attributes, length, decimalPlaces, fieldValue,fieldDicValue)); 
        }
        
    }
    
    /**
     * 
     * @Title: secondaryDataInput 
     * @Description: TODO(从表数据填充) 
     * @param driver
     * @param webElement
     * @param webElement1
     * @param requiredFields
     */
    public static void secondaryDataInput(WebDriver driver,WebElement webElement,WebElement webElement1,ArrayList<RequiredField> requiredFields,String attributes) {
        String dateId;
        String field;
        String fieldName;
        
        dateId=webElement.getAttribute("data-dataid");
        field=webElement1.getAttribute("data-field");
        fieldName=webElement1.findElement(By.className("text")).getAttribute("innerText");
        
        requiredFields.add(new  RequiredField(dateId,field,fieldName, attributes, null, null, null,null));
    }
    /**
     * 
     * @Title: switchWindow 
     * @Description: TODO(切换窗口,切换至新打开的窗口) 
     * @param driver
     */
    public void switchWindow(WebDriver driver) {
        //获取当前窗口
        String currentWindow= driver.getWindowHandle();
        //获取所有窗口
        Set<String> windows= driver.getWindowHandles();
        //切換窗口
        for(String window: windows) {
            //窗口不等于当前窗口
            if(!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                continue;   
            }
        }
    }
    
    /**
     * 
     * @Title: runExceptionScreenshot 
     * @Description: TODO(运行异常截图) 
     * @param driver
     */
    public static void runExceptionScreenshot(WebDriver driver) {
        
        
//        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-ddHH:mm:ss)");
//        String path = format.format(System.currentTimeMillis());
        String path =String.valueOf(System.currentTimeMillis());
        String curPath = System.getProperty("user.dir");
        path =path+".png";
        String scrrrnPath = curPath+"\\img\\"+path;
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,new File(scrrrnPath));
        } catch (IOException io) {
            io.printStackTrace();
            logger.error("运行异常截图截图失败!");
            logger.error(scrrrnPath);
        }
    }
    
    /**
     * 
     * @Title: shortcutMenu 
     * @Description: TODO(快捷菜单) 
     * @param load 
     * @param driver
     * @param strings
     */
    public void shortcutMenu(WaitiElementsLoad load,WebDriver driver,String [] strings) {
        
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "webiframe");
        driver.switchTo().frame("webiframe");
        logger.info("跳转到webiframe");

        for (String string : strings) {
            load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_LINKTEXT,string);
            driver.findElement(By.linkText(string)).click();
            logger.info("点击"+string);
        }
 
    }
    
    /**
     * 
     * @Title: element 
     * @Description: TODO(元素获取封装) 
     * @param locateMode
     * @param driver
     * @param value
     * @return
     */
    public WebElement geElement(ElementLocateMode locateMode,String value) {
        WebElement element = null;
        WebDriver driver =InitDriver.INSTANCE.getDriver();
        switch (locateMode) {
            case FIND_ELEMENT_ID:
                element=driver.findElement(By.id(value));
                break;
            case FIND_ELEMENT_NAME:
                element=driver.findElement(By.name(value));
                break;
                
            case FIND_ELEMENT_CLASSNAME:
                element=driver.findElement(By.className(value));
                break;
            case FIND_ELEMENT_TAGNAME:
                element=driver.findElement(By.tagName(value));
                break;
            case FIND_ELEMENT_LINKTEXT:
                element=driver.findElement(By.linkText(value));
                break;
            case FIND_ELEMENT_PARTIALLINKTEXT:
                element=driver.findElement(By.partialLinkText(value));
                break;
            case FIND_ELEMENT_XPATH:
                element=driver.findElement(By.xpath(value));
                break;
                
            case FIND_ELEMENT_CSSSELECTOR:
                element=driver.findElement(By.cssSelector(value));
                break;
            default:
                break;
        }
        
        
        return element;
    }
    
    /**
     * 
     * @Title: getPropValue 
     * @Description: TODO(获取URL配置文件中的数据) 
     * @param key
     * @return
     */
     public static String getPropValue(String key) {
         
         try {
             Properties props = new Properties();
             InputStream inputStream = SeleniumUtil.class.getResourceAsStream(DEFAULT_PROPERTIES);
             //*.properties配置文件，要使用UTF-8编码，否则会现中文乱码问题
             BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
             props.load(bf);
             return props.getProperty(key);
         }catch (IOException e){
             e.printStackTrace();
         }
         return null;
     }
     /**
      * 
      * @param <E>
     * @Title: getExcelDate 
      * @Description: TODO(获取用户信息) 
      * @param excelFileName
      * @return
      */
     public static <E> List<E> getExcelDate(String excelFileName,E object) {
         
         
         List<E> userDate = ExcelReader.readExcel(excelFileName,object);
         return userDate;
     }
    
}
