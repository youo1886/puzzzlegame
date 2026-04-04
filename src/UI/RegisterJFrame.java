package UI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegisterJFrame extends JFrame implements MouseListener {
       JLabel register;
       public RegisterJFrame(){
           this.setSize(603,680);//注册界面
           this.setTitle("拼图 注册");
           this.setAlwaysOnTop(true);
           this.setLocationRelativeTo(null);
           this.setDefaultCloseOperation(3);
           initImage();

           this.setVisible(true);
       }
       //初始化注册界面
       public void initImage(){
           this.getContentPane().removeAll();
           register=new JLabel(new ImageIcon("image\\register\\注册按钮.png"));
           register.setSize(128,47);
           register.setLocation(231,450);
           this.getContentPane().add(register);

           this.getContentPane().setLayout(null);
           this.setLocationRelativeTo(null);
           JLabel username=new JLabel(new ImageIcon("image\\register\\注册用户名.png"));
           username.setBounds(142,248,100,30);
           this.getContentPane().add(username);
           JTextField usernameText=new JTextField();
           usernameText.setBounds(242,248,150,30);
           this.getContentPane().add(usernameText);

           JLabel password=new JLabel(new ImageIcon("image\\register\\注册密码.png"));
           password.setBounds(140,318,100,30);
           this.getContentPane().add(password);
           JTextField passwordText=new JTextField();
           passwordText.setBounds(242,318,150,30);
           this.getContentPane().add(passwordText);

           JLabel confirm=new JLabel(new ImageIcon("image\\register\\再次输入密码.png"));
           confirm.setBounds(140,388,100,30);
           this.getContentPane().add(confirm);
           JTextField confirmText=new JTextField();
           confirmText.setBounds(242,388,150,30);
           this.getContentPane().add(confirmText);

           JLabel background=new JLabel(new ImageIcon("image\\register\\background.png"));
           background.setBounds(40,40,508,560);
           this.getContentPane().add(background);
           this.setVisible(true);
           this.getContentPane().addMouseListener(this);
           register.addMouseListener(this);
           this.getContentPane().repaint();
       }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
         Object obj=e.getSource();
         if(obj==register){
             register.setIcon(new ImageIcon("image\\register\\注册按下.png"));

         }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj=e.getSource();
        if(obj==register){
            register.setIcon(new ImageIcon("image\\register\\注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
