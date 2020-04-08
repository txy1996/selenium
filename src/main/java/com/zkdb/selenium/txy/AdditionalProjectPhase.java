package com.zkdb.selenium.txy;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.util.FormAndFlowBase;
import com.zkdb.selenium.util.SimulationFileUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * FileName: AdditionalProjectPhase Author: tangxiaoyu Date: 2020/4/8 10:27 Description: TODO(追加设计阶段)
 *
 * @since 1.0.0
 */
public class AdditionalProjectPhase extends FormAndFlowBase  {

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

}