package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test3 {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setSize(603, 680);
        jframe.setTitle("拼图游戏");
        jframe.setAlwaysOnTop(true);
        jframe.setLayout(null);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(3);
        //创建一个按钮
        JButton jbutton = new JButton("登录");
        jbutton.setBounds(0, 0, 100, 50);
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                System.out.println("点击了登录");
            }
        });
        jframe.getContentPane().add(jbutton);
        jframe.setVisible(true);
    }
}
