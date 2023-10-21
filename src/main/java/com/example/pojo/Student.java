package com.example.pojo;

import org.apache.commons.lang3.StringUtils;

public class Student {
    private int stuId;
    private int clazzId;
    private String stuName;
    private int stuIsManager;

    public Student() {
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuIsManager() {
        return stuIsManager;
    }

    public void setStuIsManager(int stuIsManager) {
        this.stuIsManager = stuIsManager;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", clazzId=" + clazzId +
                ", stuName='" + stuName + '\'' +
                ", stuIsManager=" + stuIsManager +
                '}';
    }

    public String listStudentInfo(){
        return StringUtils.center(String.valueOf(stuId), 10) +
                StringUtils.center(String.valueOf(clazzId), 10)  +
                StringUtils.center(String.valueOf(stuName), 20)  +
                StringUtils.center(String.valueOf(stuIsManager), 5) ;
    }
}
