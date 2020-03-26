package com.akashi.selenium.Reimbursement;

/**
 * 
 * @ClassName: ElementLocateMode 
 * @Description: TODO(元素定位方式) 
 * @author tangxiaoyu 
 * @date 2020年3月23日 下午3:22:08 
 *
 */
public enum ElementLocateMode {
    FIND_ELEMENT_ID("ID"),
    FIND_ELEMENT_NAME("NAME"),
    FIND_ELEMENT_CLASSNAME("CLASSNAME"),
    FIND_ELEMENT_TAGNAME("TAGNAME"),
    FIND_ELEMENT_LINKTEXT("LINKTEXT"),
    FIND_ELEMENT_PARTIALLINKTEXT("PARTIALLINKTEXT"),
    FIND_ELEMENT_XPATH("XPATH"),
    FIND_ELEMENT_CSSSELECTOR("CSSSELECTOR");
    
    String mode;
    
    ElementLocateMode(String mode){
        this.mode=mode;
    }
    
}
