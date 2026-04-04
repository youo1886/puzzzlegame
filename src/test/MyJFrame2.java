package test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
      public MyJFrame2(){
        this.setSize(603,680);
        this.setTitle("拼图游戏1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);


        JButton jbutton=new JButton("登录");
        jbutton.addMouseListener(this);
        jbutton.setBounds(0,0,100,50);
        this.getContentPane().add(jbutton);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        IO.println("点击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        IO.println("按下");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        IO.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        IO.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        IO.println("划出");
    }
}

