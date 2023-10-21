/*
 * Created by JFormDesigner on Fri Jun 18 16:54:39 CST 2021
 */

package com.example.gui.admin;

import com.example.dao.AdminMapperImpl;
import com.example.pojo.Clazz;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Flat-White
 */
public class ClazzManage extends JFrame {
    private List<Clazz> clazzList;
    private int clazzId = -1;

    public ClazzManage() {
        initComponents();
        setVisible(true);
    }

    private void query(MouseEvent e) {
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        List<Clazz> clazzes = adminMapper.listClazz();
        this.clazzList = clazzes;
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (Clazz clazz : clazzes) {
            stringArrayList.add(clazz.listClazzInfo());
        }
        this.list1.setListData(stringArrayList.toArray());
    }

    private void back(MouseEvent e) {
        SelectModule selectModule = new SelectModule();
        this.dispose();
    }

    private void add(MouseEvent e) {
        AddClazz addClazz = new AddClazz();
    }

    private void update(MouseEvent e) {
        try {
            Clazz clazz = clazzList.get(list1.getSelectedIndex());
            this.clazzId = clazz.getClazzId();
            System.out.println(clazzId);
            UpdateClazz updateClazz = new UpdateClazz(clazzId);
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "请先选择班级", "Error", JOptionPane.ERROR_MESSAGE);
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

        //======== this ========
        setTitle("\u73ed\u7ea7\u7ba1\u7406");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- button1 ----
        button1.setText("\u67e5\u8be2\u73ed\u7ea7");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                query(e);
            }
        });

        //---- button2 ----
        button2.setText("\u65b0\u589e\u73ed\u7ea7");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add(e);
            }
        });

        //---- button3 ----
        button3.setText("\u4fee\u6539\u73ed\u7ea7");
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
        label1.setText("\u73ed\u7ea7ID");

        //---- label2 ----
        label2.setText("\u73ed\u7ea7\u540d\u79f0");

        //---- label3 ----
        label3.setText("\u73ed\u8d39\u91d1\u989d");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button3)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addGap(40, 40, 40)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
                    .addGap(67, 67, 67))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(button4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(label2)
                        .addComponent(label3))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(button1)
                            .addGap(18, 18, 18)
                            .addComponent(button2)
                            .addGap(18, 18, 18)
                            .addComponent(button3)))
                    .addGap(18, 18, 18)
                    .addComponent(button4)
                    .addContainerGap(19, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
