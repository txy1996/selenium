package com.zkdb.selenium.reimbursement;

/**
 * 
 * @ClassName: RequiredField 
 * @Description: TODO(表单必填字段) 
 * @author tangxiaoyu 
 * @date 2020年3月24日 下午2:03:28 
 *
 */
public class RequiredField {
    /**
     * 数据集id
     */
    private String dataId;
    /**
     * 数据集字段
     */
    private String field;
    /**
     * 数据集字段名称
     */
    private String fieldName;
    
    /**
     * 填写属性(只读,必填,可填,不可见)
     */
    private String attributes;
    /**
     * 长度
     */
    private String length;
    
    /**
     * 小数位数
     */
    private String decimalPlaces;
    
    /**
     * 字段值
     */
    private String fieldValue;
    /**
     * 字典值
     */
    private String fieldDicValue;
    public String getFieldDicValue() {
        return fieldDicValue;
    }
    public void setFieldDicValue(String fieldDicValue) {
        this.fieldDicValue = fieldDicValue;
    }
    public String getDataId() {
        return dataId;
    }
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getAttributes() {
        return attributes;
    }
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public String getDecimalPlaces() {
        return decimalPlaces;
    }
    public void setDecimalPlaces(String decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }
    public String getFieldValue() {
        return fieldValue;
    }
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public RequiredField() {
        super();
        // TODO Auto-generated constructor stub
    }
    public RequiredField(String dataId, String field, String fieldName, String attributes, String length,
            String decimalPlaces, String fieldValue, String fieldDicValue) {
        super();
        this.dataId = dataId;
        this.field = field;
        this.fieldName = fieldName;
        this.attributes = attributes;
        this.length = length;
        this.decimalPlaces = decimalPlaces;
        this.fieldValue = fieldValue;
        this.fieldDicValue = fieldDicValue;
    }
    @Override
    public String toString() {
        return "RequiredField [dataId=" + dataId + ", field=" + field + ", fieldName=" + fieldName + ", attributes="
                + attributes + ", length=" + length + ", decimalPlaces=" + decimalPlaces + ", fieldValue=" + fieldValue
                + ", fieldDicValue=" + fieldDicValue + "]";
    }
    
    
    
    
}
