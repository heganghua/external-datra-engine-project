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

public class Horse implements Animal {
    JScrollPane sp;
    JFrame jf = new JFrame("抽象工厂模式测试");

    public Horse() {
        Container contentPane = jf.getContentPane();
        // 仪表盘
        JPanel jl = new JPanel();
        jl.setLayout(new GridLayout(1, 1));
        jl.setBorder(BorderFactory.createTitledBorder("动物：马"));
        sp = new JScrollPane(jl);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel ll = new JLabel(new ImageIcon("./img/horse.jpg"));
        jl.add(ll);
        jf.pack();
        jf.setVisible(false);
        // 用户点击窗口关闭
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void show() {
        // 设置可见为true
        jf.setVisible(true);
    }
}
