package com.example.dao;

import com.example.pojo.ClazzFee;
import com.example.pojo.Student;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class StudentDaoTest {
    @Test
    public void getStudent(){
        String stuName = "张一";
        HashMap<String, Object> map = new HashMap<>();
        map.put("stuName", stuName);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.getStudent(map);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void listThisClazzFee(){
        int clazzId = 1;
        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzId", clazzId);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<ClazzFee> clazzFees = mapper.listThisClazzFee(map);
        System.out.println(clazzFees);
        sqlSession.close();
    }

    @Test
    public void insertClazzfee(){
        int stuId = 1;
        int clazzId = 1;
        String clazzfeeUse = "test";
        float clazzfeeChange = 200;

        HashMap<String, Object> map = new HashMap<>();
        map.put("stuId", stuId);
        map.put("clazzId", clazzId);
        map.put("clazzfeeUse", clazzfeeUse);
        map.put("clazzfeeChange", clazzfeeChange);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.insertClazzfee(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
