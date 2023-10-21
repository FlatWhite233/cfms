package com.example.dao;

import com.example.pojo.Admin;
import com.example.pojo.Clazz;
import com.example.pojo.Student;
import com.example.utils.Md5Utils;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class AdminMapperImpl implements AdminMapper{
    @Override
    public Admin adminLogin(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        try{
            Admin admin  = mapper.adminLogin(map);
            sqlSession.close();
            if (admin.getAdminPasswd().equals(Md5Utils.toMd5(map.get("adminPasswd").toString()))){
                return admin;
            }
            else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Clazz> listClazz() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Clazz> clazzes = mapper.listClazz();
        sqlSession.close();
        return clazzes;
    }

    @Override
    public int insertClazz(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.insertClazz(map);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int updateClazz(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.updateClazz(map);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public List<Student> listStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Student> students = mapper.listStudent();
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.insertStudent(map);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int updateStudent(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.updateStudent(map);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public int deleteStudent(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        try {
            int i = mapper.deleteStudent(map);
            sqlSession.commit();
            sqlSession.close();
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int setClazzManager(Map<String, Object> map) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.setClazzManager(map);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
