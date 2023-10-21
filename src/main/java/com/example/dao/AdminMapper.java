package com.example.dao;

import com.example.pojo.Admin;
import com.example.pojo.Clazz;
import com.example.pojo.Student;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    Admin adminLogin(Map<String, Object> map);

    List<Clazz> listClazz();

    int insertClazz(Map<String, Object> map);

    int updateClazz(Map<String, Object> map);

    List<Student> listStudent();

    int insertStudent(Map<String, Object> map);

    int updateStudent(Map<String, Object> map);

    int deleteStudent(Map<String, Object> map);

    int setClazzManager(Map<String, Object> map);
}
