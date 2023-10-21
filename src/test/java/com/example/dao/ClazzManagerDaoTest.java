package com.example.dao;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzFee;
import com.example.pojo.Student;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class ClazzManagerDaoTest {
    @Test
    public void getClazzManager(){
        String stuName = "张一";
        HashMap<String, Object> map = new HashMap<>();
        map.put("stuName", stuName);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        Student clazzManager = mapper.getClazzManager(map);
        System.out.println(clazzManager);
    }

    @Test
    public void getBalance(){
        int clazzId = 1;
        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzId", clazzId);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        Clazz balance = mapper.getBalance(map);
        System.out.println(balance);
    }

    @Test
    public void listClazzFee(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        List<ClazzFee> clazzFees = mapper.listClazzFee();
        for (ClazzFee clazzFee : clazzFees) {
            System.out.println(clazzFee);
        }
        sqlSession.close();
    }

    @Test
    public void updateClazzFeeSatuts(){
        int clazzfeeId = 1;
        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzfeeId", clazzfeeId);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        int i = mapper.updateClazzFeeSatuts(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateClazzFee(){
        int clazzfeeId = 1;
        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzfeeId", clazzfeeId);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        int i = mapper.updateClazzFee(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
