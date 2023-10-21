package com.example.pojo;


import com.example.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class ClazzFee {
    private int clazzfeeId;
    private int clazzId;
    private int stuId;
    private Date clazzfeeTime;
    private String clazzfeeUse;
    private float clazzfeeChange;
    private int clazzfeeStatus;

    public ClazzFee() {
    }

    public ClazzFee(int clazzfeeId, int clazzId, int stuId, Date clazzfeeTime, String clazzfeeUse, float clazzfeeChange, int clazzfeeStatus) {
        this.clazzfeeId = clazzfeeId;
        this.clazzId = clazzId;
        this.stuId = stuId;
        this.clazzfeeTime = clazzfeeTime;
        this.clazzfeeUse = clazzfeeUse;
        this.clazzfeeChange = clazzfeeChange;
        this.clazzfeeStatus = clazzfeeStatus;
    }

    public int getClazzfeeId() {
        return clazzfeeId;
    }

    public void setClazzfeeId(int clazzfeeId) {
        this.clazzfeeId = clazzfeeId;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public Date getClazzfeeTime() {
        return clazzfeeTime;
    }

    public void setClazzfeeTime(Date clazzfeeTime) {
        this.clazzfeeTime = clazzfeeTime;
    }

    public String getClazzfeeUse() {
        return clazzfeeUse;
    }

    public void setClazzfeeUse(String clazzfeeUse) {
        this.clazzfeeUse = clazzfeeUse;
    }

    public float getClazzfeeChange() {
        return clazzfeeChange;
    }

    public void setClazzfeeChange(float clazzfeeChange) {
        this.clazzfeeChange = clazzfeeChange;
    }

    public int getClazzfeeStatus() {
        return clazzfeeStatus;
    }

    public void setClazzfeeStatus(int clazzfeeStatus) {
        this.clazzfeeStatus = clazzfeeStatus;
    }

    @Override
    public String toString() {
        return "ClassFee{" +
                "clazzfeeId=" + clazzfeeId +
                ", clazzId=" + clazzId +
                ", stuId=" + stuId +
                ", clazzfeeTime=" + clazzfeeTime +
                ", clazzfeeUse='" + clazzfeeUse + '\'' +
                ", clazzfeeChange=" + clazzfeeChange +
                ", clazzfeeStatus=" + clazzfeeStatus +
                '}';
    }

    public String listClazzFeeInfo(){
        return StringUtils.center(String.valueOf(clazzfeeId), 10) +
                StringUtils.center(String.valueOf(clazzId), 10) +
                StringUtils.center(String.valueOf(stuId), 10) +
                StringUtils.center(DateUtils.dateToString(clazzfeeTime), 10) +
                StringUtils.center(String.valueOf(clazzfeeUse), 10) +
                StringUtils.center(String.valueOf(clazzfeeChange), 10) +
                StringUtils.center(String.valueOf(clazzfeeStatus), 5);
    }
}
