package com.example.dao;

import com.example.pojo.Admin;
import com.example.pojo.Clazz;
import com.example.pojo.Student;
import com.example.utils.Md5Utils;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDaoTest {
    @Test
    public void adminLogin(){
        String adminAccount = "root";
        String adminPasswd = "root";

        Map<String, Object> map = new HashMap<>();
        map.put("adminAccount", adminAccount);
        map.put("adminPasswd", adminPasswd);
        System.out.println(map);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        try {
            Admin admin  = mapper.adminLogin(map);
            System.out.println(map.get("adminPasswd"));
            if (admin.getAdminPasswd().equals(Md5Utils.toMd5(map.get("adminPasswd").toString()))){
                System.out.println("success!");
            }
            else System.out.println("密码错误！");
        }catch (Exception e){
            System.out.println("该账户不存在！");
        }
        sqlSession.close();
    }

    @Test
    public void listClazz(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Clazz> clazzes = mapper.listClazz();
        for (Clazz clazz : clazzes) {
            System.out.println(clazz);
        }
        sqlSession.close();
    }

    @Test
    public void insertClazz(){
        String clazzName = "testclazz";
        float clazzFee = 2000;

        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzName", clazzName);
        map.put("clazzFee", clazzFee);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.insertClazz(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateClazz(){
        int clazzId = 3;
        String clazzName = "testclazz";
        float clazzFee = 3000;

        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzId", clazzId);
        map.put("clazzName", clazzName);
        map.put("clazzFee", clazzFee);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.updateClazz(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void listStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        List<Student> students = mapper.listStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void insetStudent(){
        int clazzId = 1;
        String stuName = "teststu";
        int stuIsManager = 0;

        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzId", clazzId);
        map.put("stuName", stuName);
        map.put("stuIsManager", stuIsManager);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.insertStudent(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateStudent(){
        int stuId = 7;
        String stuName = "666";

        HashMap<String, Object> map = new HashMap<>();
        map.put("stuId", stuId);
        map.put("stuName", stuName);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.updateStudent(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteStudent(){
        int stuId = 7;

        HashMap<String, Object> map = new HashMap<>();
        map.put("stuId", stuId);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        try {
            int i = mapper.deleteStudent(map);
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void setClazzManager(){
        int stuId = 7;
        int stuIsManager = 1;

        HashMap<String, Object> map = new HashMap<>();
        map.put("stuId", stuId);
        map.put("stuIsManager", stuIsManager);

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        int i = mapper.setClazzManager(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
