package com.bfby.zxjl.Bean;

import java.io.Serializable;

public class LoginBean implements Serializable {

    /**
     * UserName : 廖志华
     * RoleID : 00000000-0000-0000-0000-000000000000
     * UserID : 005f052f-7020-4d48-9652-6975dd2de3fe
     * IsSuperManage : false
     * CompanyID : 7e0dc412-7d7b-43f0-8e89-6b6941db1f8f
     */

    private String UserName;
    private String RoleID;
    private String UserID;
    private boolean IsSuperManage;
    private String CompanyID;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public boolean isIsSuperManage() {
        return IsSuperManage;
    }

    public void setIsSuperManage(boolean IsSuperManage) {
        this.IsSuperManage = IsSuperManage;
    }

    public String getCompanyID() {
        return CompanyID;
    }

    public void setCompanyID(String CompanyID) {
        this.CompanyID = CompanyID;
    }
}
