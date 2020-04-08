package com.zkdb.selenium.constant;

/**
 * FileName: OperationMethod
 * Author:   tangxiaoyu
 * Date:     2020/4/8 9:35
 * Description: TODO(元素操作方式)
 *
 * @since 1.0.0
 */
public enum OperationMethod {

    CLICK("click"),
    DOUBLE_CLICK("doubleClick"),
    SEND_KEYS("sendKeys");

    String value;
    OperationMethod(String value){
        this.value=value;
    }
}