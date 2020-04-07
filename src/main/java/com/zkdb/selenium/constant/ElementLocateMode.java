package com.zkdb.selenium.constant;

/**
 * 
 * @ClassName: ElementLocateMode 
 * @Description: TODO(元素定位方式) 
 * @author tangxiaoyu 
 * @date 2020年3月23日 下午3:22:08 
 *
 */
public enum ElementLocateMode {
    /**
     * 元素id定位
     */
    FIND_ELEMENT_ID("ID"),
    /**
     * 元素名名称定位
     */
    FIND_ELEMENT_NAME("NAME"),
    /**
     * class名称定位
     */
    FIND_ELEMENT_CLASSNAME("CLASSNAME"),
    /**
     * 标签定位
     */
    FIND_ELEMENT_TAGNAME("TAGNAME"),
    /**
     * 文本定位
     */
    FIND_ELEMENT_LINKTEXT("LINKTEXT"),
    /**
     *
     */
    FIND_ELEMENT_PARTIALLINKTEXT("PARTIALLINKTEXT"),
    /**
     * xpath路径定位
     */
    FIND_ELEMENT_XPATH("XPATH"),
    /**
     * css选择器定位
     */
    FIND_ELEMENT_CSSSELECTOR("CSSSELECTOR");
    
    String mode;
    
    ElementLocateMode(String mode){
        this.mode=mode;
    }
    
}
