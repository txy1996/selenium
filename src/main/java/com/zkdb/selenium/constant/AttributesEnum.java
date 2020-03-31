package com.zkdb.selenium.constant;

/**
 * 
 * @ClassName: AttributesEnum 
 * @Description: TODO(字段属性) 
 * @author tangxiaoyu 
 * @date 2020年3月26日 上午9:35:40 
 *
 */
public enum AttributesEnum {
    Readonly("只读"),
    Required("必填"),
    Fillable("可填"),
    Invisible("不可见");
   
    String value;
    
    AttributesEnum( String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
    
}
