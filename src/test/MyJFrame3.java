package test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3(){
        this.setSize(603,680);
        this.setTitle("拼图游戏1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);

        //给窗体添加键盘监听
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
         IO.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
         IO.println("释放");
         //输出的不是按键的ASCII，而是按键的编号
         IO.println(e.getKeyCode());
    }
}
