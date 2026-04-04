package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    JButton jbutton1 = new JButton("登录");
    JButton jbutton2 = new JButton("注册");
     MyJFrame(){
        this.setSize(603,680);//游戏主界面
        this.setTitle("拼图游戏1.0");
        //将界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        jbutton1.setBounds(0, 0, 100, 50);
        jbutton1.addActionListener(this);
        jbutton2.setBounds(100, 0, 100, 50);
        jbutton2.addActionListener(this);
        this.getContentPane().add(jbutton1);
        this.getContentPane().add(jbutton2);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //对按钮进行判断
        Object ob=e.getSource();
        if(ob==jbutton1){
            jbutton1.setSize(200,200);
        }else if(ob==jbutton2){
            Random r=new Random();
            IO.println("不要点我啦~");
            jbutton2.setLocation(r.nextInt(500),r.nextInt(500));

        }
    }
}
