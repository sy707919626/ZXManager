package com.bfby.zxjl.Bean;

import java.io.Serializable;

public class userInfoBean implements Serializable {

    /**
     * status : 1
     * User_Name : 零担专线公司管理员
     * User_LoginName : 15088607779
     * User_Email : null
     * User_Phone : 15088607779
     * User_Star : 0
     * User_Sign : 0
     * User_IDCard : 430703198711095055
     * User_Card_A : /Upload/190909165421901.png
     * User_Card_B : /Upload/190909165424745.jpg
     * User_Head : null
     * CompanyName : 零担专线公司
     * companyId : 7e0dc412-7d7b-43f0-8e89-6b6941db1f8f
     */

    private int status;
    private String User_Name;
    private String User_LoginName;
    private String User_Email;
    private String User_Phone;
    private int User_Star;
    private int User_Sign;
    private String User_IDCard;
    private String User_Card_A;
    private String User_Card_B;
    private String User_Head;
    private String CompanyName;
    private String companyId;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public String getUser_LoginName() {
        return User_LoginName;
    }

    public void setUser_LoginName(String User_LoginName) {
        this.User_LoginName = User_LoginName;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String User_Email) {
        this.User_Email = User_Email;
    }

    public String getUser_Phone() {
        return User_Phone;
    }

    public void setUser_Phone(String User_Phone) {
        this.User_Phone = User_Phone;
    }

    public int getUser_Star() {
        return User_Star;
    }

    public void setUser_Star(int User_Star) {
        this.User_Star = User_Star;
    }

    public int getUser_Sign() {
        return User_Sign;
    }

    public void setUser_Sign(int User_Sign) {
        this.User_Sign = User_Sign;
    }

    public String getUser_IDCard() {
        return User_IDCard;
    }

    public void setUser_IDCard(String User_IDCard) {
        this.User_IDCard = User_IDCard;
    }

    public String getUser_Card_A() {
        return User_Card_A;
    }

    public void setUser_Card_A(String User_Card_A) {
        this.User_Card_A = User_Card_A;
    }

    public String getUser_Card_B() {
        return User_Card_B;
    }

    public void setUser_Card_B(String User_Card_B) {
        this.User_Card_B = User_Card_B;
    }

    public String getUser_Head() {
        return User_Head;
    }

    public void setUser_Head(String User_Head) {
        this.User_Head = User_Head;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
