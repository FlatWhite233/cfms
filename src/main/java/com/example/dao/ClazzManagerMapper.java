package com.example.dao;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzFee;
import com.example.pojo.Student;

import java.util.List;
import java.util.Map;

public interface ClazzManagerMapper {
    Student getClazzManager(Map<String, Object> map);

    Clazz getBalance(Map<String, Object> map);

    List<ClazzFee> listClazzFee();

    int updateClazzFeeSatuts(Map<String, Object> map);

    int updateClazzFee(Map<String, Object> map);
}
