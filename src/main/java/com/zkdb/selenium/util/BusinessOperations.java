package com.zkdb.selenium.util;

/**
 * FileName: BusinessOperations
 * Author:   tangxiaoyu
 * Date:     2020/4/8 10:43
 * Description: TODO(这里用一句话描述这个类的作用)
 *
 * @since 1.0.0
 */
public interface BusinessOperations {

    /**
     * @Title:
     * @Description: TODO(登录并定位模块位置)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:33
     */

    public void login();
     /**
       * @Title:
       * @Description: TODO(定位模块位置)
       * @param: 
       * @return:
       * @Date: 2020/4/8 11:00
      */
     
    public void LocateModule();
    /**
     * @Title:
     * @Description: TODO(新增业务数据)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:29
     */

    public void addBusinessData();


    /**
     * @Title:
     * @Description: TODO(填写表单数据)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:34
     */

    public void writeFormData();

    /**
     * @Title:
     * @Description: TODO(保存表单数据)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:35
     */

    public void saveFormDate();

    /**
     * 数据输出
     */
    public void dataOutput();


    /**
     * @Title:
     * @Description: TODO(发起流程)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:36
     */

    public void initiationrocess();


    /**
     * @Title:
     * @Description: TODO(关闭表单)
     * @param:
     * @return:
     * @Date: 2020/4/8 10:37
     */

    public void closeForm();
    
     /**
       * @Title:
       * @Description: TODO(流程批转)
       * @param: 
       * @return:
       * @Date: 2020/4/8 10:54
      */
     
    public void processForwarding();

}