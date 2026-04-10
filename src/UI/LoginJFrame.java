package UI;


import test.MyJFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static UI.UserManage.users;

public class LoginJFrame extends JFrame implements MouseListener {
   // static ArrayList<User> users = new ArrayList<>();



    JButton login = new JButton();
    JButton register = new JButton();

    JTextField username = new JTextField();

    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    //正确的验证码
    JLabel rightCode = new JLabel();
    JLabel eye;

    public LoginJFrame() {
        //初始化界面
        initJFrame();

        //在这个界面中添加内容
        initView();


        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initView() {
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("image\\login\\用户名.png"));
        usernameText.setBounds(100, 200, 128, 47);
        this.getContentPane().add(usernameText);


        //2.添加用户名输入框
        username.setBounds(205, 210, 200, 27);
        this.getContentPane().add(username);


        //3.添加密码输入文本
        JLabel passwordText = new JLabel(new ImageIcon("image\\login\\密码.png"));
        passwordText.setBounds(100, 280, 128, 47);
        this.getContentPane().add(passwordText);


        //4.添加密码输入框
        password = new JPasswordField();
        password.setBounds(205, 290, 200, 27);
        this.getContentPane().add(password);


        //5.添加验证码输入框
        JLabel codeText = new JLabel(new ImageIcon("image\\login\\验证码.png"));
        codeText.setBounds(100, 350, 128, 47);
        this.getContentPane().add(codeText);

        //6.添加验证码输入框
        code = new JTextField();
        code.setBounds(205, 360, 100, 27);
        this.getContentPane().add(code);


        //7.添加正确验证码
        //验证码提示
        rightCode.setBounds(330, 360, 100, 27);
        this.getContentPane().add(rightCode);
        rightCode.setText(Code.getCode());
        rightCode.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rightCode.setText(Code.getCode());
            }
        });


        //8.添加登录按钮
        login.setBounds(100, 385, 200, 150);
        login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
        //去除按钮的边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        //给登录按钮绑定鼠标事件
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //9.添加注册按钮
        register.setBounds(320, 437, 128, 47);
        register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);

        //10.添加密码显示
        eye = new JLabel(new ImageIcon("image/login/显示密码.png"));
        eye.setBounds(410, 290, 30, 30);
        this.getContentPane().add(eye);
        eye.addMouseListener(this);

        //11.添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\login\\background.png"));
        background.setBounds(25,20,508,560);
        this.getContentPane().add(background);




    }
    public void initJFrame() {
        this.setSize(583, 650);//设置宽高
        this.setTitle("拼图游戏 V1.0登录");//设置标题
        this.setDefaultCloseOperation(3);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);//取消内部默认布局
    }











    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == login) {
            String usernameInput = username.getText();
            String passwordInput = new String(password.getPassword());
            String codeInput = code.getText();
            String rightCodeText = rightCode.getText();

            //创建一个User对象
            User userInfo = new User(usernameInput, passwordInput);

            if (codeInput.length() == 0) {
                show("验证码不能为空");

            }
            //校验用户名和密码是否为空
            else if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                //调用showJDialog方法并展示弹框
                show("用户名或者密码为空");


            } else if (!codeInput.equalsIgnoreCase(rightCodeText)) {
                show("验证码输入错误");
            } else if (contains(userInfo)) {
                this.setVisible(false);
                new GameJFrame(usernameInput);
            } else {
                show("用户名或密码错误");
            }
        }
    }
    public boolean contains(User userInput){
        for (int i = 0; i < users.size(); i++) {
            User rightUser =users.get(i);
            if(userInput.getUsername().equals(rightUser.getUsername()) && userInput.getPassword().equals(rightUser.getPassword())){
                //有相同的代表存在，返回true，后面的不需要再比了
                return true;
            }
        }
        //循环结束之后还没有找到就表示不存在
        return false;
    }
    public void show(String content) {
        JOptionPane.showMessageDialog(this, content);

        /*//创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);*/
    }

    @Override
    public void mousePressed(MouseEvent e) {
     if(e.getSource()==login){
         login.setIcon(new ImageIcon("image\\login\\登录按下.png"));
     }
     else if(e.getSource()==register){
         register.setIcon(new ImageIcon("image\\login\\注册按下.png"));
     }
     if(e.getSource()==eye){
         eye.setIcon(new ImageIcon("image/login/显示密码按下.png"));
         password.setEchoChar((char) 0);
     }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     if(e.getSource()==login){
         login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
     }
     else if(e.getSource()==register){
         register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
         new RegisterJFrame();
         this.dispose();
     }
     if(e.getSource()==eye){
         eye.setIcon(new ImageIcon("image/login/显示密码.png"));}
         password.setEchoChar('•');
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
