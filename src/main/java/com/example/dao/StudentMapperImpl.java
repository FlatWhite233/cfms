package com.example.dao;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzFee;
import com.example.pojo.Student;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapperImpl implements StudentMapper{
    @Override
    public Student getStudent(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.getStudent(map);
        sqlSession.close();
        return student;
    }

    @Override
    public List<ClazzFee> listThisClazzFee(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<ClazzFee> clazzFees = mapper.listThisClazzFee(map);
        sqlSession.close();
        return clazzFees;
    }

    @Override
    public Clazz getBalance(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ClazzManagerMapper mapper = sqlSession.getMapper(ClazzManagerMapper.class);
        Clazz balance = mapper.getBalance(map);
        return balance;
    }

    @Override
    public int insertClazzfee(HashMap<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.insertClazzfee(map);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
