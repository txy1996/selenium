package com.zkdb.selenium.util;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.constant.InitDriver;
import com.zkdb.selenium.process.ProcessUtil;
import com.zkdb.selenium.reimbursement.ReimbursementRun;
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
import java.util.Map;

/**
 * 表单和流程基础方法
 * @author Akashi
 */
public abstract class FormAndFlowBase {

    public WebDriver driver;
    public SeleniumUtil util = new SeleniumUtil();
    public  WaitiElementsLoad load = new WaitiElementsLoad();
    public  Logger logger = Logger.getLogger(FormAndFlowBase.class);
    public  Actions actions;
    public  boolean flag = true;
    public Map<String, String[]> valueMap;
    public String outDataExcelPath;
    public String handle;
    public ArrayList<UserAccountVO> userDate;
    public Login login;
    public String processName;

    public void login(String userIdDateExcelPath,String DataExcelPath) {
        Logger logger = Logger.getLogger(ReimbursementRun.class);
        // 读取配置文件 (预设账号)
        driver = InitDriver.getDriver();
        outDataExcelPath=DataExcelPath;

        valueMap=util.getEncapsulationFormData(outDataExcelPath);
        if(valueMap==null) {
            flag=false;
            logger.info("文件不存在,转换输入模式");
        }
        UserAccountVO user = new UserAccountVO();
        userDate = (ArrayList<UserAccountVO>)SeleniumUtil.getExcelDate(userIdDateExcelPath, user);

        // 调用登录
        login = new Login();
        // 使用账号登录
        login.loginAccount(userDate.get(0).getOrguid(), userDate.get(0).getUserName(), userDate.get(0).getPassWord());
        logger.info("登陆账号:" + userDate.get(0).getUserName());
    }

    /**
     * @Title:
     * @Description: TODO(新增业务数据)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:29
     */
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
     * @Description: TODO(定位模块位置)
     * @param:
     * @return:
     * @Date: 2020/4/8 11:00
     */
    public void locateModule(String oneTitle,String twoTitle,String threeTitle) {

        util.verifyOnDuty();
        util.getElement( ElementLocateMode.FIND_ELEMENT_XPATH, "//div[@id='topbar1']//div[@data-title='"+oneTitle+"']")
                .click();
        logger.info(oneTitle);

        util.getElement( ElementLocateMode.FIND_ELEMENT_LINKTEXT, twoTitle).click();
        logger.info(twoTitle);

        util.getElement(ElementLocateMode.FIND_ELEMENT_LINKTEXT, threeTitle).click();
        logger.info(threeTitle);
    }


    /**
     * @Title:
     * @Description: TODO(保存表单数据)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:35
     */
    public void saveFormDate() {

        util.getElement(10, ElementLocateMode.FIND_ELEMENT_ID,"form_save").click();
        logger.info("点击保存");
    }

    /**
     * 数据输出
     */
    public void dataOutput() {
        ArrayList<RequiredField> requiredFields=util.getFormRequiredField();
        //写入表单信息
        ExcelWriter.inputDataExcel(requiredFields,outDataExcelPath);
    }

    /**
     * @Title:
     * @Description: TODO(发起流程)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:36
     */
    public void initiationrocess() throws InterruptedException {
        //点击发起按钮
        WebElement newWfInstanceEle=util.getElement(10,ElementLocateMode.FIND_ELEMENT_ID,"form_newWfInstance");
        newWfInstanceEle.click();
        logger.info("点击发起");
        //获取流程事项名称
        WebElement processNameEle=util.getElement(10,ElementLocateMode.FIND_ELEMENT_XPATH,"//div[contains(@class,'modalWorkFlow')]//div[contains(@class,'modal-body')]//div/label[contains(text(), '事项名称')]/../input");
        processName=processNameEle.getAttribute("value");

        //确认办理
        WebElement primaryEle =util.getElement(10,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".modal-footer > .btn-primary");
        primaryEle.click();
        logger.info("-----------发起成功------------");

        ProcessUtil.taskRecipientIsSelf(handle);

    }

    /**
     * @Title:
     * @Description: TODO(关闭表单)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:37
     */
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

    public void processForwarding() throws InterruptedException {
        //删除第一次登陆的账号,为循环做准备
        userDate.remove(0);
        for (UserAccountVO userAccountVO : userDate) {
            //登陆任务接收人账号
            login.loginAccount( userAccountVO.getOrguid(), userAccountVO.getUserName(), userAccountVO.getPassWord());
            handle = driver.getWindowHandle();
            ProcessUtil.workboxProcess(processName);
            ProcessUtil.processForwarding();
            ProcessUtil.taskRecipientIsSelf(handle);
        }

    }
    /**
     * @Title:
     * @Description: TODO(填写表单数据)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:34
     */
    public abstract void writeFormData();

    public void run(String userIdDateExcelPath,String DataExcelPath,String oneTitle,String twoTitle,String threeTitle) {

        try {
            login(userIdDateExcelPath,DataExcelPath);
            locateModule(oneTitle,twoTitle,threeTitle);
            addBusinessData();
            writeFormData();
            saveFormDate();
            dataOutput();
            initiationrocess();
            processForwarding();
        }
        catch (Exception e){

            logger.info(e.toString());
            //错误截图
            //SeleniumUtil.runExceptionScreenshot(driver);
        }
        finally {
            WebDriver driver=InitDriver.getDriver();
            driver.quit();
        }


    }
}
