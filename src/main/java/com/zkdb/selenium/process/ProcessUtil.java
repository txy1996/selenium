package com.zkdb.selenium.process;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zkdb.selenium.constant.ElementLocateMode;
import com.zkdb.selenium.reimbursement.ProcessForwarding;
import com.zkdb.selenium.util.SeleniumUtil;
import com.zkdb.selenium.util.WaitiElementsLoad;

/**
 * 
 * @author Akashi 流程处理工具类
 */
public class ProcessUtil {

	SeleniumUtil util = new SeleniumUtil();
	WaitiElementsLoad load = new WaitiElementsLoad();
	Logger logger = Logger.getLogger(ProcessForwarding.class);

	/**
	 * 工作箱流程处理
	 */
	public String workboxProcess(WebDriver driver, String processName) {
		//跳转webiframe 验证是否第一次登陆设置在岗状态
		util.verifyOnDuty(driver);
		load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, ".fa-tasks");
		// new WebDriverWait(driver,
		// 30).until(ExpectedConditions.elementToBeClickable(By.id("a_number3")));
		driver.findElement(By.cssSelector(".fa-tasks")).click();
		logger.info("-----------点击工作箱------------");

		load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_NAME, "workframe");
		driver.switchTo().frame("workframe");

		load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, ".working .glyphicon");
		driver.findElement(By.cssSelector(".working .glyphicon")).click();
		logger.info("-----------点击工作箱搜索------------");

		load.Wait(driver, 10, ElementLocateMode.FIND_ELEMENT_LINKTEXT, "自定义搜索");
		driver.findElement(By.linkText("自定义搜索")).click();

		load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_XPATH, "//div[4]/div/div[2]/div/input");
		driver.findElement(By.xpath("//div[4]/div/div[2]/div/input")).click();
		driver.findElement(By.xpath("//div[4]/div/div[2]/div/input")).sendKeys(processName);

		logger.info("-----------点击事项标题------------");

		load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, ".querybtn");
		driver.findElement(By.cssSelector(".querybtn")).click();
		logger.info("-----------点击查询------------");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text = "";
		By elementGroup = new By.ByCssSelector(".wftasks .name");

		By elementUnclassified = new By.ByCssSelector("#box_data .name");

		boolean flag = true;
		if (util.checkExistsElement(driver, elementGroup)) {
			load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, ".wftasks .name");
			text = driver.findElement(By.cssSelector(".wftasks .name")).getText();
			logger.info("-----------分组------------" + text);

		} else if (util.checkExistsElement(driver, elementUnclassified)) {
			load.Wait(driver, 30, ElementLocateMode.FIND_ELEMENT_CSSSELECTOR, "#box_data .name");
			text = driver.findElement(By.cssSelector("#box_data .name")).getText();
			flag = false;
			logger.info("-----------未分组------------" + text);
		}
		String handle = driver.getWindowHandle();
		// 判断是否存在
		if (processName.equals(text)) {
			if (flag) {
				driver.findElement(By.cssSelector(".wftasks .name")).click();
			} else {
				driver.findElement(By.cssSelector("#box_data .name")).click();
			}
			util.switchWindow(driver);
            try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            By unreadMessages = new By.ByCssSelector(".close");
            if(util.checkExistsElement(driver, unreadMessages)) {
                logger.info("-----------@未阅消息提醒------------");
                load.Wait(driver,30,ElementLocateMode.FIND_ELEMENT_CSSSELECTOR,".close");
                driver.findElement(By.cssSelector(".close")).click();
            }
		}
		return handle;
	}
	/**
	 * 批准确认办理
	 * @param driver
	 */
	public void processForwarding(WebDriver driver) {
        //点击批转
        load.Wait(driver,60,ElementLocateMode.FIND_ELEMENT_ID,"form_transmitNext");
        driver.findElement(By.id("form_transmitNext")).click();
        //确定办理
        By  confirmation = new By.ByXPath("//button[contains(.,'确定办理')]");
        try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(util.checkExistsElement(driver, confirmation)) {
        load.Wait(driver,40,ElementLocateMode.FIND_ELEMENT_XPATH,"//button[contains(.,'确定办理')]");
        driver.findElement(By.xpath("//button[contains(.,'确定办理')]")).click();
        logger.info("-----------确定办理------------");
        }
	}
}
