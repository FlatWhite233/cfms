/*
 * Created by JFormDesigner on Sat Jun 19 10:44:36 CST 2021
 */

package com.example.gui.student;

import com.example.dao.StudentMapperImpl;
import com.example.gui.Initialization;
import com.example.pojo.Clazz;
import com.example.pojo.ClazzFee;
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
public class StudentInit extends JFrame {
    private Student student;
    private java.util.List<ClazzFee> clazzFeeList;

    public StudentInit(Student student) {
        initComponents();
        setVisible(true);
        this.student = student;
    }

    private void submit(MouseEvent e) {
        Submit submit = new Submit(student);
    }


    private void getbalance(MouseEvent e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzId", student.getClazzId());

        StudentMapperImpl studentMapper = new StudentMapperImpl();
        Clazz balance = studentMapper.getBalance(map);
        JOptionPane.showMessageDialog(null,"当前班费余额：" + balance.getClazzFee(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void back(MouseEvent e) {
        Initialization initialization = new Initialization();
        this.dispose();
    }

    private void query(MouseEvent e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzId", student.getClazzId());

        StudentMapperImpl studentMapper = new StudentMapperImpl();
        List<ClazzFee> clazzFees = studentMapper.listThisClazzFee(map);
        this.clazzFeeList = clazzFees;
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (ClazzFee clazzFee : clazzFees) {
            stringArrayList.add(clazzFee.listClazzFeeInfo());
        }
        this.list1.setListData(stringArrayList.toArray());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        button3 = new JButton();
        button4 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- button1 ----
        button1.setText("\u67e5\u8be2\u73ed\u8d39\u53d8\u66f4");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                query(e);
            }
        });

        //---- label1 ----
        label1.setText("\u73ed\u8d39ID");

        //---- label2 ----
        label2.setText("\u73ed\u7ea7ID");

        //---- label3 ----
        label3.setText("\u5b66\u751fID");

        //---- label4 ----
        label4.setText("\u53d8\u66f4\u65f6\u95f4");

        //---- label5 ----
        label5.setText("\u73ed\u8d39\u7528\u9014");

        //---- label6 ----
        label6.setText("\u53d8\u66f4\u91d1\u989d");

        //---- label7 ----
        label7.setText("\u72b6\u6001");

        //---- button3 ----
        button3.setText("\u67e5\u8be2\u73ed\u8d39\u4f59\u989d");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getbalance(e);
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

        //---- button2 ----
        button2.setText("\u63d0\u4ea4\u73ed\u8d39\u53d8\u66f4");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                submit(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label7))
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(button4))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button3)))
                            .addGap(0, 30, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(22, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2)
                        .addComponent(label3)
                        .addComponent(label4)
                        .addComponent(label5)
                        .addComponent(label6)
                        .addComponent(label7))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button3)
                        .addComponent(button2))
                    .addGap(31, 31, 31)
                    .addComponent(button4)
                    .addGap(19, 19, 19))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton button3;
    private JButton button4;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
