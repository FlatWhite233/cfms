package com.example.pojo;

public class Clazz {
    private int clazzId;
    private String clazzName;
    private float clazzFee;

    public Clazz() {
    }

    public Clazz(int clazzId, String clazzName, float clazzFee) {
        this.clazzId = clazzId;
        this.clazzName = clazzName;
        this.clazzFee = clazzFee;
    }

    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public float getClazzFee() {
        return clazzFee;
    }

    public void setClazzFee(float clazzFee) {
        this.clazzFee = clazzFee;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "clazzId=" + clazzId +
                ", clazzName='" + clazzName + '\'' +
                ", clazzFee=" + clazzFee +
                '}';
    }

    public String listClazzInfo(){
        return clazzId + "       " + clazzName + "       " + clazzFee;
    }
}
