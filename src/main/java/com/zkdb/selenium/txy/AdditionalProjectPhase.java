package com.zkdb.selenium.txy;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.constant.InitDriver;
import com.zkdb.selenium.process.ProcessUtil;
import com.zkdb.selenium.reimbursement.ReimbursementRun;
import com.zkdb.selenium.util.*;
import com.zkdb.selenium.vo.RequiredField;
import com.zkdb.selenium.vo.UserAccountVO;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * FileName: AdditionalProjectPhase Author: tangxiaoyu Date: 2020/4/8 10:27 Description: TODO(追加设计阶段)
 *
 * @since 1.0.0
 */
public class AdditionalProjectPhase implements BusinessOperations {

    // 初始化
    WebDriver driver;
    SeleniumUtil util = new SeleniumUtil();
    WaitiElementsLoad load = new WaitiElementsLoad();
    // 日志
    Logger logger = Logger.getLogger(AdditionalProjectPhase.class);
    Actions actions;
    boolean flag = true;
    Map<String, String[]> valueMap;
    String url;
    String handle;


    /**
     * @Title:
     * @Description: TODO(登录并定位模块位置)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:33
     */
    @Override
    public void login() {
        Logger logger = Logger.getLogger(ReimbursementRun.class);
        // 读取配置文件 (预设账号)
        driver = InitDriver.getDriver();
        String excelFileName = "D:\\项目立项\\UserAccountVO.xlsx";
        url = "D:\\项目立项\\追加项目阶段用例.xlsx";

        valueMap=util.getEncapsulationFormData(url);
        if(valueMap==null) {
            flag=false;
            logger.info("文件不存在,转换输入模式");
        }
        UserAccountVO user = new UserAccountVO();
        ArrayList<UserAccountVO> userDate = (ArrayList<UserAccountVO>)SeleniumUtil.getExcelDate(excelFileName, user);

        // 调用登录
        Login login = new Login();
        // 使用账号登录
        login.loginAccount(userDate.get(0).getOrguid(), userDate.get(0).getUserName(), userDate.get(0).getPassWord());
        logger.info("登陆账号:" + userDate.get(0).getUserName());
    }

    /**
     * @Title:
     * @Description: TODO(定位模块位置)
     * @param:
     * @return:
     * @Date: 2020/4/8 11:00
     */
    @Override
    public void LocateModule() {

        util.verifyOnDuty();
        util.getElement(10, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='topbar1']//div[@data-title='项目']")
            .click();
        logger.info("点击项目");

        util.getElement(10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "启动规划").click();
        logger.info("启动规划");

        util.getElement(10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "追加设计阶段").click();
        logger.info("追加设计阶段");
    }

    /**
     * @Title:
     * @Description: TODO(新增业务数据)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:29
     */
    @Override
    public void addBusinessData() {

        // 跳转
        driver.switchTo().frame(2);

        load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_ID, "btnAdd");
        driver.findElement(By.id("btnAdd")).click();
        logger.info("点击添加按钮");

        handle = driver.getWindowHandle();
        util.switchWindow();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @Title:
     * @Description: TODO(填写表单数据)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:34
     */
    @Override
    public void writeFormData() {
        //鼠标模拟
        actions =new Actions(driver);
        String projNameValueInput=util.getInputValue("中科大厦",valueMap,flag,"proj_id",0);
        WebElement projId= util.getElement(10,ElementLocateMode.FIND_ELEMENT_ID,"proj_id");
        actions.doubleClick(projId).perform();
        logger.info("双击项目名称");
        WebElement projNameInput=util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,
            "//div[@class='modal-header']/div/ul//div/input[@data-field='proj_name']");
        logger.info("设置项目名称值");

        projNameInput.sendKeys(projNameValueInput);

        WebElement search=util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,
            "//div[contains(@class,'modal-content')]/div[@class='modal-header']/div/ul//button[contains(text(),'搜索')]");
        search.click();
        logger.info("点击搜索");
        actions.doubleClick(util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,
            "//table[contains(@class,'table')]/tbody//tr//td[@data-field='proj_name' and contains(text(),'"+projNameValueInput+"')]/..")).perform();
        logger.info("双击选择项目名称");
        WebElement a_string2_Element=util.getElement(10,ElementLocateMode.FIND_ELEMENT_ID,"a_string2");
        actions.doubleClick(a_string2_Element).perform();
        String a_string2ValueInout=util.getInputValue("一期\\1-15#住宅楼",valueMap,flag,"a_string2",0);
        actions.doubleClick(util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,"//tbody//tr//td[@data-field='fullpath' and contains(.,'"+a_string2ValueInout+"')]")).perform();
        logger.info("选择项目子项");
        WebElement a_string1=util.getElement(10,ElementLocateMode.FIND_ELEMENT_ID,"a_string1");

        actions.doubleClick(a_string1).perform();
        logger.info("双击设计阶段");
        List<WebElement> elements=driver.findElements(By.xpath("/html/body/ul"));
        String a_string1FixedValue="方案设计,可行性研究";
        String a_string1ValueInout=util.getInputValue(a_string1FixedValue,valueMap,flag,"a_string1",0);
        String [] a_string1Array=a_string1ValueInout.split(",");
        for (String s : a_string1Array) {

        }
        logger.info("获取元素");
        for (WebElement webElement : elements) {
            logger.info(webElement.getCssValue("display"));
            if ("block".equals(webElement.getCssValue("display"))) {
                logger.info("将选择方案设计");
                for (String s : a_string1Array) {
                    util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,"//li//input[@value='"+s+"' and @type='checkbox']/..").click();
                    logger.info("选择"+s);
                }
                webElement.findElement(By.xpath("//li/a[contains(@class,'btn') and contains(text(),'确定')]")).click();
            }
        }

        WebElement contid=util.getElement(10,ElementLocateMode.FIND_ELEMENT_ID,"contid");
        actions.doubleClick(contid).perform();
        logger.info("双击阶段合同");

        WebElement sheet_titleSearch=util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,
            "//div[@class='modal-header']/div/ul//div/input[@data-field='sheet_title']");
        String contidValueInput=util.getInputValue("华为西部研发中心",valueMap,flag,"contid",0);
        sheet_titleSearch.sendKeys(contidValueInput);

        util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,
            "//div[contains(@class,'modal-content')]/div[@class='modal-header']/div/ul//button[contains(text(),'搜索')]").click();
        actions.doubleClick(util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,
            "//table[contains(@class,'table')]/tbody//tr//td[@data-field='sheet_title' and contains(text(),'"+contidValueInput+"')]/..")).perform();
        logger.info("选择阶段合同");

        WebElement sheet_remalkEle=util.getElement(10,ElementLocateMode.FIND_ELEMENT_ID,"sheet_remalk");
        String sheet_remalkValTextra=util.getInputValue("Oh, please don't let me die. Waiting for your touch.",valueMap,flag,"sheet_remalk",0);
        sheet_remalkEle.sendKeys(sheet_remalkValTextra);
        logger.info("追加原因");
        WebElement uploadEle=util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,
            "//div[@class='panel-heading']//div/span[contains(@class,'new_upload')]/span[contains(text(),'上传文件')]");
        uploadEle.click();

        //文件上传
        SimulationFileUpload fileUpload =new SimulationFileUpload();
        //上传文件路径
        String fileUrl ="D:\\项目立项\\UserAccountVO.xlsx";
        //
        fileUpload.fileUpload(fileUrl);
        logger.info("-----------准备上传------------"+System.currentTimeMillis());

        util.getElement(10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary").click();
        System.currentTimeMillis();
        logger.info("-----------开始上传------------"+System.currentTimeMillis());

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("form_newWfInstance")));
        logger.info("-----------文件上传完毕------------"+System.currentTimeMillis());




    }

    /**
     * @Title:
     * @Description: TODO(保存表单数据)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:35
     */
    @Override
    public void saveFormDate() {

        util.getElement(10,ElementLocateMode.FIND_ELEMENT_ID,"form_save").click();
        logger.info("点击保存");
    }

    /**
     * 数据输出
     */
    @Override
    public void dataOutput() {
        ArrayList<RequiredField> requiredFields=util.getFormRequiredField();
        //写入表单信息
        ExcelWriter.inputDataExcel(requiredFields,url);
    }

    /**
     * @Title:
     * @Description: TODO(发起流程)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:36
     */
    @Override
    public void initiationrocess() {
        //点击发起按钮
        WebElement newWfInstanceEle=util.getElement(10,ElementLocateMode.FIND_ELEMENT_ID,"form_newWfInstance");
        newWfInstanceEle.click();
        logger.info("点击发起");
        //获取流程事项名称
        WebElement processNameEle=util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modalWorkFlow')]//div[contains(@class,'modal-body')]//div/label[contains(text(), '事项名称')]/../input");
        processNameEle.click();

        //确认办理
        WebElement primaryEle =util.getElement(10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary");
        primaryEle.click();
        logger.info("-----------发起成功------------");

        ProcessUtil.taskRecipientIsSelf();
        driver.switchTo().window(handle);

        //跳转窗体
        load.Wait(driver,10,ElementLocateMode.FIND_ELEMENT_ID,"webiframe");
        driver.switchTo().frame("webiframe");
        driver.navigate().refresh();
    }

    /**
     * @Title:
     * @Description: TODO(关闭表单)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:37
     */
    @Override
    public void closeForm() {
        util.getElement(10,ElementLocateMode.FIND_ELEMENT_ID,"form_cancel").click();
        logger.info("点击关闭");
    }

    /**
     * @Title:
     * @Description: TODO(流程批转)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:54
     */
    @Override
    public void processForwarding() {

    }
}