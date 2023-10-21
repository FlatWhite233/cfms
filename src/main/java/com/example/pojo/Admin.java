package com.example.pojo;

public class Admin {
    private int adminId;
    private String adminName;
    private String adminAccount;
    private String adminPasswd;

    public Admin() {
    }

    public Admin(int adminId, String adminName, String adminAccount, String adminPasswd) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminAccount = adminAccount;
        this.adminPasswd = adminPasswd;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPasswd() {
        return adminPasswd;
    }

    public void setAdminPasswd(String adminPasswd) {
        this.adminPasswd = adminPasswd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminAccount='" + adminAccount + '\'' +
                ", adminPasswd='" + adminPasswd + '\'' +
                '}';
    }
}
