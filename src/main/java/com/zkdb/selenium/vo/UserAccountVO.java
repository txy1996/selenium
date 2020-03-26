package com.zkdb.selenium.vo;

/**
 * 
 * @ClassName: UserAccount 
 * @Description: TODO(用户账号类) 
 * @author tangxiaoyu 
 * @date 2020年3月25日 下午12:28:01 
 *
 */
public class UserAccountVO {
    
    private String orguid;
    
    private String userName;
    
    private String passWord;

    public String getOrguid() {
        return orguid;
    }

    public void setOrguid(String orguid) {
        this.orguid = orguid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "UserAccount [orguid=" + orguid + ", userName=" + userName + ", passWord=" + passWord + ", getOrguid()="
                + getOrguid() + ", getUserName()=" + getUserName() + ", getPassWord()=" + getPassWord()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }
    
    
}
