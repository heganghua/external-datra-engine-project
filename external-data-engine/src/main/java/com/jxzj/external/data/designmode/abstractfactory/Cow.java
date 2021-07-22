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
 * 具体产品： 牛类
 * 
 * @author heganghua
 * @date 2021/07/21
 */
public class Cow implements Animal {

    JScrollPane sp;
    JFrame jf = new JFrame("抽象工厂模式测试");

    public Cow() {
        Container contentPane = jf.getContentPane();
        JPanel pl = new JPanel();
        pl.setLayout(new GridLayout(1, 1));
        pl.setBorder(BorderFactory.createTitledBorder("动物： 牛"));
        sp = new JScrollPane(pl);
        contentPane.add(sp, BorderLayout.CENTER);
        JLabel jl = new JLabel(new ImageIcon("./img/cow.jpg"));
        pl.add(jl);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void show() {
        jf.setVisible(true);
    }

}
