/*
 * Created by JFormDesigner on Fri Jun 18 11:03:00 CST 2021
 */

package com.example.gui;

import com.example.dao.ClazzManagerMapperImpl;
import com.example.dao.StudentMapperImpl;
import com.example.gui.clazzmanager.ClazzFeeManage;
import com.example.gui.student.StudentInit;
import com.example.pojo.Student;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Flat-White
 */
public class Initialization extends JFrame {
    private Student student;

    public Initialization() {
        initComponents();
//        窗口大小不可变
        this.setResizable(false);
//        关闭后结束进程
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void admin(MouseEvent e) {
        Login login = new Login();
        this.dispose();
    }

    private void clazzmanager(MouseEvent e) {
        String stuName = JOptionPane.showInputDialog(null, "请输入姓名");
        if(stuName != null){
            HashMap<String, Object> map = new HashMap<>();
            map.put("stuName", stuName);
            ClazzManagerMapperImpl clazzManagerMapper = new ClazzManagerMapperImpl();
            Student clazzManager = clazzManagerMapper.getClazzManager(map);
            this.student = clazzManager;
            if(this.student != null){
                JOptionPane.showMessageDialog(null, "登陆成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(student);
                ClazzFeeManage clazzFeeManage = new ClazzFeeManage(student);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(null, "不是班级管理员", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    }

    private void student(MouseEvent e) {
        String stuName = JOptionPane.showInputDialog(null, "请输入姓名");
        if(stuName != null){
            HashMap<String, Object> map = new HashMap<>();
            map.put("stuName", stuName);
            StudentMapperImpl studentMapper = new StudentMapperImpl();
            Student student = studentMapper.getStudent(map);
            this.student = student;
            if(this.student != null){
                JOptionPane.showMessageDialog(null, "登陆成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(this.student);
                StudentInit studentInit = new StudentInit(this.student);
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(null, "该学生不存在", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("\u73ed\u8d39\u7ba1\u7406\u7cfb\u7edf");
        Container contentPane = getContentPane();

        //---- label2 ----
        label2.setText("\u73ed\u8d39\u7ba1\u7406\u7cfb\u7edf");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 10f));

        //---- button1 ----
        button1.setText("\u7ba1\u7406\u5458");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                admin(e);
            }
        });

        //---- button2 ----
        button2.setText("\u73ed\u7ea7\u7ba1\u7406\u5458");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clazzmanager(e);
            }
        });

        //---- button3 ----
        button3.setText("\u5b66\u751f");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                student(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(136, Short.MAX_VALUE)
                    .addComponent(label2)
                    .addGap(130, 130, 130))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(79, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
