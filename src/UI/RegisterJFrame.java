package UI;


import test.MyJFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegisterJFrame extends JFrame implements MouseListener {
       JLabel register;
       JTextField usernameText;
       JTextField passwordText;
       JTextField confirmText;
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
           register.setLocation(245,460);
           this.getContentPane().add(register);

           this.getContentPane().setLayout(null);
           this.setLocationRelativeTo(null);
           JLabel username=new JLabel(new ImageIcon("image\\register\\注册用户名.png"));
           username.setBounds(142,248,100,30);
           this.getContentPane().add(username);
           usernameText=new JTextField();
           usernameText.setBounds(242,248,150,30);
           this.getContentPane().add(usernameText);

           JLabel password=new JLabel(new ImageIcon("image\\register\\注册密码.png"));
           password.setBounds(140,318,100,30);
           this.getContentPane().add(password);
           passwordText=new JTextField();
           passwordText.setBounds(242,318,150,30);
           this.getContentPane().add(passwordText);

           JLabel confirm=new JLabel(new ImageIcon("image\\register\\再次输入密码.png"));
           confirm.setBounds(140,388,100,30);
           this.getContentPane().add(confirm);
           confirmText=new JTextField();
           confirmText.setBounds(242,388,150,30);
           this.getContentPane().add(confirmText);

           JLabel background=new JLabel(new ImageIcon("image\\background.png"));
           background.setBounds(40,40,508,560);
           this.getContentPane().add(background);

           this.getContentPane().addMouseListener(this);
           register.addMouseListener(this);
           this.getContentPane().repaint();
           this.setVisible(true);
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
            String username=usernameText.getText();
            User user=new User(username,passwordText.getText());
                if(contains(user)){
                    JOptionPane.showMessageDialog(this,"用户已存在");
                    return ;
            }
            if(check(usernameText.getText(),passwordText.getText(),confirmText.getText())){
                User newUser = new User(usernameText.getText(), passwordText.getText());
                UserManage.userAdd(newUser);
                JOptionPane.showMessageDialog(this,"注册成功");
                this.dispose();
                new LoginJFrame();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    /**
     * 验证用户注册信息的合法性
     * 检查用户名和密码是否为空，以及两次输入的密码是否一致
     *
     * @param username 用户名
     * @param password 密码
     * @param confirm 确认密码
     * @return 验证通过返回true，否则返回false
     */
    public boolean check(String username,String password,String confirm){
        if(username.equals("")||password.equals("")||confirm.equals("")){
            JOptionPane.showMessageDialog(this,"用户名或密码不能为空");
            return false;
        }
        else if(!username.matches("[a-zA-Z0-9]+")){
            JOptionPane.showMessageDialog(this,"用户名只能包含字母和数字");
            return false;
        }
        else if(password.length()<6){
            JOptionPane.showMessageDialog(this,"密码长度不能小于6");
            return false;
        }
        else if(!password.equals(confirm)){
            JOptionPane.showMessageDialog(this,"密码不一致");
            return false;
        }
        return true;
    }
    public boolean contains(User user){
        for(User u: UserManage.getUsers()){
            if(u.getUsername().equals(user.getUsername())){
                return true;
            }
        }
        return false;
    }
}
