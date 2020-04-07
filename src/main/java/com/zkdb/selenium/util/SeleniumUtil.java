package com.zkdb.selenium.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.zkdb.selenium.constant.InitDriverU;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zkdb.selenium.constant.AttributesEnum;
import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.constant.InitDriver;
import com.zkdb.selenium.reimbursement.RequiredField;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @ClassName: SeleniumUtil
 * @Description: TODO(selenium工具类)
 * @author tangxiaoyu
 * @date 2020年3月23日 下午3:57:05
 *
 */
public class SeleniumUtil {

    private static final String DEFAULT_PROPERTIES = "/url.properties";
    static Logger logger = Logger.getLogger(SeleniumUtil.class);
    WaitiElementsLoad load = new WaitiElementsLoad();
    static WebDriver driver = InitDriver.getDriver();

    /**
     * 
     * @Title: checkExistsElement
     * @Description: TODO(判断元素是否存在)
     * @param element
     * @return boolean
     */
    public boolean checkExistsElement(By element) {

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
    public void keyboardNumberInput(String number) {
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
            String numString = String.valueOf(number);

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
                    case ' ':
                        robot.keyPress(KeyEvent.VK_BACK_SPACE);
                        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                        break;
                    case ':':
                        robot.keyPress(KeyEvent.VK_SEMICOLON);
                        robot.keyRelease(KeyEvent.VK_SEMICOLON);
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
     * @return
     */
    public ArrayList<RequiredField> getFormRequiredField() {
        //
        // RequiredField requiredField;

        ArrayList<RequiredField> requiredFields = new ArrayList<>();
        // 获取所有input 标签
        List<WebElement> elements = driver
                .findElements(By.xpath("//div[contains(@class,'input-group')]//*[contains(@class,'form-control')]"));
        // 获取主表的数据集id
        String id = driver.findElement(By.cssSelector("#data_panel")).getAttribute("data-dataid");
        for (WebElement webElement : elements) {

            // 获取data-required 属性等于 1 获取必填字段
            if ("1".equals(webElement.getAttribute("data-required")) && webElement.isDisplayed()
                    && webElement.isEnabled()) {

                coreDataInput(webElement, requiredFields, id, AttributesEnum.Required.getValue());

                // 只读
            }
            else if ("1".equals(webElement.getAttribute("data-readonly")) && webElement.isDisplayed()) {

                coreDataInput(webElement, requiredFields, id, AttributesEnum.Readonly.getValue());
                // 可填
            }
            else if (!"1".equals(webElement.getAttribute("data-readonly"))
                    && !"1".equals(webElement.getAttribute("data-required")) && webElement.isDisplayed()) {
                coreDataInput(webElement, requiredFields, id, AttributesEnum.Fillable.getValue());
                // 不可见
            }
            else if (("1".equals(webElement.getAttribute("data-readonly"))
                    || !"1".equals(webElement.getAttribute("data-required"))) && !webElement.isDisplayed()
                    && webElement.getAttribute("data-field") != null) {
                coreDataInput(webElement, requiredFields, id, AttributesEnum.Invisible.getValue());
            }

        }

        // 查找从表编号,并返回各个从表
        List<WebElement> elementsCBdate = driver.findElements(By.xpath("//table[@class='detailData']"));

        for (WebElement webElement : elementsCBdate) {
            // logger.info(webElement.getAttribute("data-dataid"));

            ArrayList<HashMap<String, String>> valueArrayList = new ArrayList<HashMap<String, String>>();

            // 查找从表数据行 tr class 属性中包含detail-row 的元素
            List<WebElement> elementTR = driver.findElements(By.xpath("//table[@class='detailData' and @data-dataid='"
                    + webElement.getAttribute("data-dataid") + "']//tr[contains(@class,'detail-row')]"));

            for (WebElement webElement2 : elementTR) {
                // 查找从表具体数据
                List<WebElement> elementsTDData = webElement2.findElements(By.tagName("td"));
                HashMap<String, String> vHashMap = new HashMap<String, String>();
                for (WebElement webElement3 : elementsTDData) {

                    // 去除不符合条件的数据
                    if (webElement3.getAttribute("data-field") != null
                            && !"checked".equals(webElement3.getAttribute("data-field"))) {
                        // 输出字段名称和数据
                        // logger.info(webElement3.getAttribute("data-field") +
                        // "-----data-field-----"
                        // + webElement3.getAttribute("title") +
                        // "-----title-----");
                        vHashMap.put(webElement3.getAttribute("data-field"), webElement3.getAttribute("title"));
                    }

                }
                valueArrayList.add(vHashMap);
            }
            // 查找字段名称属性 td class 属性中包含 ui-resizable
            List<WebElement> elementsCB = webElement.findElements(
                    By.xpath("//table[@class='detailData']/thead/tr//td[contains(@class,'ui-resizable')]"));

            int num = 1;
            for (HashMap<String, String> hashMap : valueArrayList) {

                for (WebElement webElement1 : elementsCB) {
                    if (webElement1.getAttribute("data-field") != ""
                            && webElement1.getAttribute("data-field") != null) {
                        // 获取从表必填字段
                        if ("1".equals(webElement1.getAttribute("data-required"))) {

                            secondaryDataInput(webElement, webElement1, requiredFields,
                                    AttributesEnum.Required.getValue(), String.valueOf(num),
                                    hashMap.get(webElement1.getAttribute("data-field")));
                            // 只读
                        }
                        else if ("1".equals(webElement1.getAttribute("data-readonly"))) {

                            secondaryDataInput(webElement, webElement1, requiredFields,
                                    AttributesEnum.Readonly.getValue(), String.valueOf(num),
                                    hashMap.get(webElement1.getAttribute("data-field")));

                            // 可填
                        }
                        else if (!"1".equals(webElement.getAttribute("data-readonly"))
                                && !"1".equals(webElement.getAttribute("data-required"))) {
                            secondaryDataInput(webElement, webElement1, requiredFields,
                                    AttributesEnum.Fillable.getValue(), String.valueOf(num),
                                    hashMap.get(webElement1.getAttribute("data-field")));
                            // 不可见
                        }
                        else if ("1".equals(webElement.getAttribute("data-readonly")) && !webElement.isDisplayed()) {
                            secondaryDataInput(webElement, webElement1, requiredFields,
                                    AttributesEnum.Invisible.getValue(), String.valueOf(num),
                                    hashMap.get(webElement1.getAttribute("data-field")));
                        }
                    }

                }
                num++;
            }
        }

        return requiredFields;
    }

    /**
     * 
     * @Title: coreDataInput
     * @Description: TODO(主表数据填充)
     * @param webElement
     * @param requiredFields
     * @param id
     */
    public static void coreDataInput(WebElement webElement, ArrayList<RequiredField> requiredFields, String id,
            String attributes) {
        String dateId;
        String field;
        String fieldName;
        String length = null;
        String decimalPlaces = null;
        String fieldValue = null;
        String fieldDicValue = null;

        dateId = id;
        // 获取满足 条件的 input 标签的 id属性值
        field = webElement.getAttribute("id");
        if (!field.equals("") && field != null) {
            // 获取字段中文名称
            fieldName = driver.findElement(By.id("lab_" + field)).getAttribute("innerText");
            // 字段长度
            length = webElement.getAttribute("maxlength");

            // 几位小数
            decimalPlaces = webElement.getAttribute("data-decimalplaces");
            // logger.info(decimalPlaces+"小数位数"+field);
            // 字段值
            fieldValue = webElement.getAttribute("value");
            // 字典值
            fieldDicValue = webElement.getAttribute("selvalue");
            requiredFields.add(new RequiredField(dateId, null, field, fieldName, attributes, length, decimalPlaces,
                    fieldValue, fieldDicValue));
        }

    }

    /**
     * 
     * @Title: secondaryDataInput
     * @Description: TODO(从表数据填充)
     * @param webElement
     * @param webElement1
     * @param requiredFields
     */
    public static void secondaryDataInput(WebElement webElement, WebElement webElement1,
            ArrayList<RequiredField> requiredFields, String attributes, String num, String value) {
        String dateId;
        String field;
        String fieldName;

        dateId = webElement.getAttribute("data-dataid");
        field = webElement1.getAttribute("data-field");
        fieldName = webElement1.findElement(By.className("text")).getAttribute("innerText");

        requiredFields.add(new RequiredField(dateId, num, field, fieldName, attributes, null, null, value, null));
    }

    /**
     * 
     * @Title: switchWindow
     * @Description: TODO(切换窗口,切换至新打开的窗口)
     */
    public void switchWindow() {
        // 获取当前窗口
        String currentWindow = driver.getWindowHandle();
        // 获取所有窗口
        Set<String> windows = driver.getWindowHandles();
        // 切換窗口
        for (String window : windows) {
            // 窗口不等于当前窗口
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                continue;
            }
        }
    }

    /**
     * 
     * @Title: runExceptionScreenshot
     * @Description: TODO(运行异常截图)
     */
    public static void runExceptionScreenshot() {

        // SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-ddHH:mm:ss)");
        // String path = format.format(System.currentTimeMillis());
        String path = String.valueOf(System.currentTimeMillis());
        String curPath = System.getProperty("user.dir");
        path = path + ".png";
        String scrrrnPath = curPath + "\\img\\" + path;
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(scrrrnPath));
        }
        catch (IOException io) {
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
     * @param strings
     */
    public void shortcutMenu(WaitiElementsLoad load, String[] strings) {

        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "webiframe");
        driver.switchTo().frame("webiframe");
        logger.info("跳转到webiframe");

        for (String string : strings) {
            load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, string);
            driver.findElement(By.linkText(string)).click();
            logger.info("点击" + string);
        }

    }

    /**
     * 
     * @Title: element
     * @Description: TODO(元素获取封装)
     * @param locateMode
     * @param value
     * @return
     */
    public WebElement geElement(ElementLocateMode locateMode, String value) {
        WebElement element = null;
        switch (locateMode) {
            case FIND_ELEMENT_ID:
                element = driver.findElement(By.id(value));
                break;
            case FIND_ELEMENT_NAME:
                element = driver.findElement(By.name(value));
                break;

            case FIND_ELEMENT_CLASSNAME:
                element = driver.findElement(By.className(value));
                break;
            case FIND_ELEMENT_TAGNAME:
                element = driver.findElement(By.tagName(value));
                break;
            case FIND_ELEMENT_LINKTEXT:
                element = driver.findElement(By.linkText(value));
                break;
            case FIND_ELEMENT_PARTIALLINKTEXT:
                element = driver.findElement(By.partialLinkText(value));
                break;
            case FIND_ELEMENT_XPATH:
                element = driver.findElement(By.xpath(value));
                break;

            case FIND_ELEMENT_CSSSELECTOR:
                element = driver.findElement(By.cssSelector(value));
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
            // *.properties配置文件，要使用UTF-8编码，否则会现中文乱码问题
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            props.load(bf);
            return props.getProperty(key);
        }
        catch (IOException e) {
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
    public static <E> List<E> getExcelDate(String excelFileName, E object) {

        List<E> userDate = ExcelReader.readExcel(excelFileName, object);
        if (userDate == null) {
            return null;
        }
        return userDate;
    }

    /**
     * 
     * @Title: optProcessRecipients
     * @Description: TODO(选择流程接收人)
     */
    public static void optProcessRecipients(String userId, String activityName, String activityID) {
        // li
        List<WebElement> elements = driver.findElements(By.xpath(
                "//div[contains(@class,'modalWorkFlow')]//ul[@id='Transmit_userTree' and contains(@class,'ztree')]/li"));

        for (WebElement webElement : elements) {
            // span
            List<WebElement> spanElements = webElement.findElements(By.xpath("//span[@data-nodetype='activity']"));
            for (WebElement webElement2 : spanElements) {
                if (activityName.equals(webElement2.getAttribute("data-activity_name"))
                        && activityID.equals(webElement2.getAttribute("data-activity_id"))) {
                    logger.info("ces ");

                    List<WebElement> webElements = webElement.findElements(By.xpath("//span[@data-nodetype='user']"));

                    for (WebElement webElement1 : webElements) {
                        if (userId.equals(webElement1.getAttribute("data-user_userid"))) {
                            System.out.println(webElement1.getAttribute("data-user_userid"));
                            System.out.println(webElement1.getAttribute("id"));
                            String spanId = webElement1.getAttribute("id");
                            logger.info(spanId.replace("_span", "_check"));
                            WebElement checkElement = driver.findElement(By.id(spanId.replace("_span", "_check")));
                            logger.info(checkElement.getAttribute("class"));
                            String classValue = checkElement.getAttribute("class");
                            // 判断是否选中,如果没有选择,点击勾选
                            if ("button chk checkbox_false_full".equals(classValue)) {
                                checkElement.click();
                            }

                        }
                    }

                }
            }
        }
    }

    /**
     * 
     * @Title: getElementXPath
     * @Description: TODO(从表xPath统一定位)
     * @param dataId 数据集id
     * @param serialNumber 行号
     * @param field 字段名称(英文名称)
     * @return xPath
     */
    public String getElementXPath(String dataId, String serialNumber, String field) {

        String xPath = "//table[@data-dataid='" + dataId + "']//tr[" + serialNumber
                + "]//td[ contains(@class,'cell') and @data-field='" + field + "']";

        return xPath;
    }

    /**
     * 
     * @Title: getEncapsulationFormData
     * @Description: TODO(传入测试用例文件地址,获取测试用例的数据)
     * @param url 地址
     * @return
     */
    public Map<String, String[]> getEncapsulationFormData(String url) {

        ArrayList<RequiredField> requiredFields = (ArrayList<RequiredField>) SeleniumUtil.getExcelDate(url,
                new RequiredField());
        if (requiredFields == null) {
            return null;
        }
        Map<String, String[]> valueMap = new HashMap<String, String[]>();

        for (RequiredField requiredField : requiredFields) {
            // 主表数据处理 key=(字段名称) value=(显示值,字段值(实际值))
            if (requiredField.getSerialNumber().equals("") || requiredField.getSerialNumber() == null) {
                valueMap.put(requiredField.getField(),
                        new String[] { requiredField.getFieldValue(), requiredField.getFieldDicValue() });
                // 从表数据封装 key=(数据集id+行号+字段值名称) value=(显示值,字段值(实际值))
            }
            else if (!requiredField.getSerialNumber().equals("") && requiredField.getSerialNumber() != null) {
                valueMap.put(requiredField.getDataId() + requiredField.getSerialNumber() + requiredField.getField(),
                        new String[] { requiredField.getFieldValue(), requiredField.getFieldDicValue() });
            }

        }

        return valueMap;
    }

    /**
     * 
     * @Title: verifyOnDuty
     * @Description: TODO(检验在岗状态)
     */
    public void verifyOnDuty() {
        //
        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "webiframe");
        driver.switchTo().frame("webiframe");
        logger.info("跳转到webiframe ");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        By elementOnDuty = new By.ByXPath(
                "//div[@class='modal-content']//div[@class='userstatus-content']/span[contains(text(),'选择工作状态')]");
        if (checkExistsElement(elementOnDuty)) {
            logger.info("第一次登陆");
            By elementV = new By.ByXPath("/html/body//div//div/div/ul/li[contains(@class,'select') and @status='1']");
            By elementVC = new By.ByXPath("");
            if (checkExistsElement(elementV)) {
                load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH,
                        "/html/body//div/div/div//div/div/button[contains(text(),'确定在岗状态')]");
                driver.findElement(By.xpath("/html/body//div/div/div//div/div/button[contains(text(),'确定在岗状态')]"))
                        .click();
            }
            else if (checkExistsElement(elementVC)) {
                load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH,
                        "/html/body//div//div/div/ul/li[@status='1']");
                driver.findElement(By.xpath("/html/body//div//div/div/ul/li[@status='1']")).click();
                load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH,
                        "/html/body//div/div/div//div/div/button[contains(text(),'确定在岗状态')]");
                driver.findElement(By.xpath("/html/body//div/div/div//div/div/button[contains(text(),'确定在岗状态')]"))
                        .click();
            }

        }
    }

    /**
     *
     * @Title: isElementExist
     * @Description: TODO(判断一个元素是否存在)
     * @param by
     * @return
     */
    public boolean isElementExist(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     *
     * @Title: elementsExists
     * @Description: TODO(判断元素列表是否存在)
     * @param by
     * @return
     */
    public boolean elementsExists(By by) {
        return (driver.findElements(by).size() > 0) ? true : false;
    }

    /**
     *
     * @Title: FindByElements
     * @Description: TODO(获取元素列表中指定的元素)
     * @param by
     * @param index
     * @return
     */
    public WebElement FindByElements(By by, int index) {
        WebElement element = null;
        if (this.elementsExists(by)) {
            element = driver.findElements(by).get(index);
        }
        return element;
    }

    /**
     * @Title:
     * @Description: TODO(返回)
     * @param:
     * @return:
     * @Date: 2020/4/7 14:50
     */

    public void BrowserBack() {
        driver.navigate().back();
    }

    /**
     * @Title:
     * @Description: TODO(前进)
     * @param:
     * @return:
     * @Date: 2020/4/7 14:50
     */

    public void BrowserForward() {
        driver.navigate().forward();
    }

    /**
     * @Title:
     * @Description: TODO( 滚动到最上方)
     * @param:
     * @return:
     * @Date: 2020/4/7 14:50
     */

    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollTo(0,0);");
    }

    /**
     * @Title:
     * @Description: TODO(滚动到页面底部)
     * @param:
     * @return:
     * @Date: 2020/4/7 14:49
     */

    public void scrollToBottom(String id) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,10000);");
    }

    /**
     * @Title:
     * @Description: TODO(滚动到某个元素)
     * @param:
     * @return:
     * @Date: 2020/4/7 14:49
     */
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebElement getElement(int time, ElementLocateMode locateMode, String path) {
        // 显示等待

        WebElement element = null;
        logger.info("等待");
        WebDriverWait wait = new WebDriverWait(driver, time);
        switch (locateMode) {
            case FIND_ELEMENT_ID:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(path)));
                element = driver.findElement(By.id(path));
                break;
            case FIND_ELEMENT_NAME:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(path)));
                element = driver.findElement(By.name(path));
                break;

            case FIND_ELEMENT_CLASSNAME:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(path)));
                element = driver.findElement(By.className(path));
                break;
            case FIND_ELEMENT_TAGNAME:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName(path)));
                element = driver.findElement(By.tagName(path));
                break;
            case FIND_ELEMENT_LINKTEXT:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(path)));
                element = driver.findElement(By.linkText(path));
                break;
            case FIND_ELEMENT_PARTIALLINKTEXT:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(path)));
                element = driver.findElement(By.partialLinkText(path));
                break;
            case FIND_ELEMENT_XPATH:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(path)));
                element = driver.findElement(By.xpath(path));
                break;

            case FIND_ELEMENT_CSSSELECTOR:
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(path)));
                element = driver.findElement(By.cssSelector(path));
                break;
            default:
                break;
        }
        return element;
    }

}
