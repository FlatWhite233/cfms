/*
 * Created by JFormDesigner on Fri Jun 18 18:09:10 CST 2021
 */

package com.example.gui.admin;

import com.example.dao.AdminMapperImpl;
import com.example.pojo.Student;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author Flat-White
 */
public class StudentManage extends JFrame {
    private List<Student> studentList;
    private int stuId;

    public StudentManage() {
        initComponents();
        setVisible(true);
    }

    private void query(MouseEvent e) {
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        List<Student> students = adminMapper.listStudent();
        this.studentList = students;
        ArrayList<String> studentArrayList = new ArrayList<>();

        for (Student student : students) {
            studentArrayList.add(student.listStudentInfo());
        }
        this.list1.setListData(studentArrayList.toArray());
    }

    private void add(MouseEvent e) {
        AddStudent addStudent = new AddStudent();
    }

    private void delete(MouseEvent e) {
        try {
            Student student = studentList.get(list1.getSelectedIndex());
            this.stuId = student.getStuId();
            System.out.println(stuId);
            int i = JOptionPane.showConfirmDialog(null, "确认删除该学生", "Confirm", JOptionPane.YES_NO_OPTION);
            if(i == 0){
                HashMap<String, Object> map = new HashMap<>();
                map.put("stuId", stuId);

                AdminMapperImpl adminMapper = new AdminMapperImpl();
                try {
                    int r = adminMapper.deleteStudent(map);
                    if(r > 0){
                        System.out.println("success");
                        JOptionPane.showMessageDialog(null, "删除成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (Exception exception){
                    System.out.println("不可删除该学生!");
                    JOptionPane.showMessageDialog(null, "不可删除该学生!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "请先选择学生", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void back(MouseEvent e) {
        SelectModule selectModule = new SelectModule();
        this.dispose();
    }

    private void set(MouseEvent e) {
        try {
            Student student = studentList.get(list1.getSelectedIndex());
            this.stuId = student.getStuId();
            System.out.println(stuId);
            SetManager setManager = new SetManager(stuId);
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "请先选择学生", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void update(MouseEvent e) {
        try{
            Student student = studentList.get(list1.getSelectedIndex());
            this.stuId = student.getStuId();
            System.out.println(stuId);
            UpdateStudent updateStudent = new UpdateStudent(stuId);
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "请先选择学生", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button5 = new JButton();
        label4 = new JLabel();
        button6 = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u7ba1\u7406");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- button1 ----
        button1.setText("\u67e5\u8be2\u5b66\u751f");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                query(e);
            }
        });

        //---- button2 ----
        button2.setText("\u65b0\u589e\u5b66\u751f");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add(e);
            }
        });

        //---- button3 ----
        button3.setText("\u4fee\u6539\u5b66\u751f");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                update(e);
            }
        });

        //---- button4 ----
        button4.setText("\u8fd4\u56de");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back(e);
            }
        });

        //---- label1 ----
        label1.setText("\u5b66\u53f7");

        //---- label2 ----
        label2.setText("\u59d3\u540d");

        //---- label3 ----
        label3.setText("\u662f\u5426\u4e3a\u73ed\u7ea7\u7ba1\u7406\u5458");

        //---- button5 ----
        button5.setText("\u8bbe\u7f6e\u73ed\u7ea7\u7ba1\u7406\u5458");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                set(e);
            }
        });

        //---- label4 ----
        label4.setText("\u73ed\u7ea7ID");

        //---- button6 ----
        button6.setText("\u5220\u9664\u5b66\u751f");
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(button3)
                            .addComponent(button2)
                            .addComponent(button1))
                        .addComponent(button6))
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(label3))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(39, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label3)
                        .addComponent(label2)
                        .addComponent(label4))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(18, 18, 18)
                            .addComponent(button2)
                            .addGap(18, 18, 18)
                            .addComponent(button3)
                            .addGap(18, 18, 18)
                            .addComponent(button6)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button4)
                        .addComponent(button5))
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button5;
    private JLabel label4;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
