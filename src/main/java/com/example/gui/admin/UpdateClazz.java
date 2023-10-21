/*
 * Created by JFormDesigner on Fri Jun 18 17:28:03 CST 2021
 */

package com.example.gui.admin;

import com.example.dao.AdminMapperImpl;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Flat-White
 */
public class UpdateClazz extends JFrame {
    private int clazzId;
    private String clazzName;
    private float clazzFee;

    public UpdateClazz(int clazzId) {
        initComponents();
        setVisible(true);
        this.clazzId = clazzId;
    }


    private void getClazzName(KeyEvent e) {
        textField1 = (JTextField) e.getSource();
        this.clazzName = textField1.getText();
    }


    private void getClazzFee(KeyEvent e) {
        textField2 = (JTextField) e.getSource();
        this.clazzFee = Float.parseFloat(textField2.getText());
    }


    private void ok(MouseEvent e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("clazzId", clazzId);
        map.put("clazzName", clazzName);
        map.put("clazzFee", clazzFee);

        AdminMapperImpl adminMapper = new AdminMapperImpl();
        try {
            int i = adminMapper.updateClazz(map);
            if (i > 0){
                System.out.println("Success");
                JOptionPane.showMessageDialog(null, "修改成功！", "Info", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private void cancel(MouseEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();
        textField2 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u76f8\u5173\u4fe1\u606f");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));

        //---- label2 ----
        label2.setText("\u73ed\u7ea7\u540d\u79f0");

        //---- textField1 ----
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                getClazzName(e);
            }
        });

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ok(e);
            }
        });

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancel(e);
            }
        });

        //---- label3 ----
        label3.setText("\u73ed\u8d39\u91d1\u989d");

        //---- textField2 ----
        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                getClazzFee(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(label1)
                    .addContainerGap(72, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(23, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(18, 18, 18)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(65, 65, 65)
                            .addComponent(button2)))
                    .addGap(17, 17, 17))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(label1)
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(39, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JLabel label3;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
