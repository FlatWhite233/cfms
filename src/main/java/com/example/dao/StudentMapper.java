package com.example.dao;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzFee;
import com.example.pojo.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

    Student getStudent(Map<String, Object> map);

    List<ClazzFee> listThisClazzFee(Map<String, Object> map);

    Clazz getBalance(Map<String, Object> map);

    /**
     * 上交班费/支出班费
     * @param map stuId clazzId clazzfeeUse clazzfeeChange
     * @return result
     */
    int insertClazzfee(HashMap<String, Object> map);
}
