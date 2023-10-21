package com.example.dao;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzFee;
import com.example.pojo.Student;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ClazzManagerMapperImpl implements ClazzManagerMapper{

    @Override
    public Student getClazzManager(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        Student clazzManager = mapper.getClazzManager(map);
        System.out.println(clazzManager);
        return clazzManager;
    }

    @Override
    public Clazz getBalance(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        Clazz balance = mapper.getBalance(map);
        return balance;
    }

    @Override
    public List<ClazzFee> listClazzFee() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        List<ClazzFee> clazzFees = mapper.listClazzFee();
        sqlSession.close();
        return clazzFees;
    }

    @Override
    public int updateClazzFeeSatuts(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        int i = mapper.updateClazzFeeSatuts(map);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int updateClazzFee(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        int i = mapper.updateClazzFee(map);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
