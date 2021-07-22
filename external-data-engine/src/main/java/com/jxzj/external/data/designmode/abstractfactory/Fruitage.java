package com.jxzj.external.data.designmode.abstractfactory;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 具体产品：水果类
 * 
 * @author heganghua
 * @date 2021/07/21
 */
public class Fruitage implements Plant {

    JScrollPane sp;
    JFrame jf = new JFrame("抽象工程模式测试");

    public Fruitage() {
        Container contentPane = jf.getContentPane();
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1));
        p1.setBorder(BorderFactory.createTitledBorder("植物：水果"));
        sp = new JScrollPane(p1);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel l1 = new JLabel(new ImageIcon("./img/fruita.jpg"));
        p1.add(l1);
        jf.pack();
        jf.setVisible(false);
        // 用户点击窗口关闭
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void show() {
        jf.setVisible(true);
    }
}
