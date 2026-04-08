package test;

import UI.LoginJFrame;
import UI.RegisterJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJFrame extends JFrame implements ActionListener {
     JLabel login;
     JLabel register;
     public MyJFrame(){
        this.setSize(583,650);//游戏主界面
        this.setTitle("拼图游戏1.0");
        //将界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        init();
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

    public void init(){
        login=new JLabel(new ImageIcon("image\\login\\登录按钮.png"));
        login.setBounds(85,170,400,250);
        this.getContentPane().add(login);
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LoginJFrame();
                dispose();
            }
        });

        register=new JLabel(new ImageIcon("image\\login\\注册按钮.png"));
        register.setBounds(85,300,400,250);
        this.getContentPane().add(register);
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new RegisterJFrame();
                dispose();
            }
        });

        JLabel background=new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(25,20,508,560);
        this.getContentPane().add(background);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
