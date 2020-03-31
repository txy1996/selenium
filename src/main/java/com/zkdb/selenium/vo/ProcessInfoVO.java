package com.zkdb.selenium.vo;

/**
 * 
 * @ClassName: ProcessInfoVO 
 * @Description: TODO(流程信息类) 
 * @author tangxiaoyu 
 * @date 2020年3月31日 下午4:22:11 
 *
 */
public class ProcessInfoVO {

    /**
     * 上个流程环节id
     */
    private String activityLastId;
    /**
     * 现在流程环节id
     */
    private String activityNewId;
    
    /**
     * 下个流程环节id
     */
    private String activityNextId;
    /**
     * 当前流程环节名称
     */
    private String activityName;
    
    /**
     *流程任务接收人
     */
    private String activityHandler;
    
    /**
     * 流入规则
     */
    private String activityInflowRule;
    
    /**
     * 流出规则
     */
    private String activityOutflowRule;

    public String getActivityLastId() {
        return activityLastId;
    }

    public void setActivityLastId(String activityLastId) {
        this.activityLastId = activityLastId;
    }

    public String getActivityNewId() {
        return activityNewId;
    }

    public void setActivityNewId(String activityNewId) {
        this.activityNewId = activityNewId;
    }

    public String getActivityNextId() {
        return activityNextId;
    }

    public void setActivityNextId(String activityNextId) {
        this.activityNextId = activityNextId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityHandler() {
        return activityHandler;
    }

    public void setActivityHandler(String activityHandler) {
        this.activityHandler = activityHandler;
    }

    public String getActivityInflowRule() {
        return activityInflowRule;
    }

    public void setActivityInflowRule(String activityInflowRule) {
        this.activityInflowRule = activityInflowRule;
    }

    public String getActivityOutflowRule() {
        return activityOutflowRule;
    }

    public void setActivityOutflowRule(String activityOutflowRule) {
        this.activityOutflowRule = activityOutflowRule;
    }

    public ProcessInfoVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProcessInfoVO(String activityLastId, String activityNewId, String activityNextId, String activityName,
            String activityHandler, String activityInflowRule, String activityOutflowRule) {
        super();
        this.activityLastId = activityLastId;
        this.activityNewId = activityNewId;
        this.activityNextId = activityNextId;
        this.activityName = activityName;
        this.activityHandler = activityHandler;
        this.activityInflowRule = activityInflowRule;
        this.activityOutflowRule = activityOutflowRule;
    }

    @Override
    public String toString() {
        return "ProcessInfoVO [activityLastId=" + activityLastId + ", activityNewId=" + activityNewId
                + ", activityNextId=" + activityNextId + ", activityName=" + activityName + ", activityHandler="
                + activityHandler + ", activityInflowRule=" + activityInflowRule + ", activityOutflowRule="
                + activityOutflowRule + "]";
    }
    
    
}
