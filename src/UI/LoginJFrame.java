package UI;


import test.MyJFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {
    static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("zhangsan", "123"));
        users.add(new User("lisi", "1234"));
    }

    JButton login = new JButton();
    JButton register = new JButton();

    JTextField username = new JTextField();

    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    //正确的验证码
    JLabel rightCode = new JLabel();


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
        register.addMouseListener(this);/*new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                register.setIcon(new ImageIcon("image\\login\\注册按下.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
            }
        });*/
        this.getContentPane().add(register);


        //10.添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\login\\background.png"));
        background.setBounds(25,20,508,560);
        this.getContentPane().add(background);

        //11.设置界面宽高

    }

    /*public void init() {
        JLabel login = new JLabel(new ImageIcon("image\\login\\登录按钮.png"));
        login.setBounds(200, 420, 200, 150);
        this.getContentPane().add(login);
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = usernameText.getText();
                char[] passwordChars = passwordText.getPassword();
                String password = new String(passwordChars);
                String code = codeText.getText();
                check(username, password, code);
            }
        });

        JLabel username = new JLabel(new ImageIcon("image\\login\\用户名.png"));
        username.setBounds(100, 200, 128, 47);
        this.getContentPane().add(username);
        usernameText = new JTextField();
        usernameText.setBounds(205, 210, 200, 27);
        this.getContentPane().add(usernameText);

        JLabel password = new JLabel(new ImageIcon("image\\login\\密码.png"));
        password.setBounds(100, 280, 128, 47);
        this.getContentPane().add(password);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(205, 290, 200, 27);
        this.getContentPane().add(passwordText);
        JLabel eye = new JLabel(new ImageIcon("image\\login\\显示密码.png"));
        eye.setBounds(410, 290, 30, 27);
        eye.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                eye.setIcon(new ImageIcon("image\\login\\显示密码按下.png"));
                passwordText.setEchoChar((char) 0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                eye.setIcon(new ImageIcon("image\\login\\显示密码.png"));
                passwordText.setEchoChar('•');
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }


        });
        this.getContentPane().add(eye);

        JLabel code = new JLabel(new ImageIcon("image\\login\\验证码.png"));
        code.setBounds(100, 350, 128, 47);
        this.getContentPane().add(code);
        codeText = new JTextField();
        codeText.setBounds(205, 360, 100, 27);
        this.getContentPane().add(codeText);

        JLabel code1 = new JLabel();
        code1.setBounds(330, 360, 100, 27);
        this.getContentPane().add(code1);
        code1.setText(Code.getCode());
        code1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                code1.setText(Code.getCode());
            }
        });


        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        this.setVisible(true);

    }

    public void check(String username, char[] password, String code) {
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(this, "用户名或密码不能为空");
        }
        else if (!username.matches("[a-zA-Z0-9]+")) {
            JOptionPane.showMessageDialog(this, "用户名只能包含字母和数字");
        }
        //检查密码
        else {
            JOptionPane.showMessageDialog(this, "密码错误");
        }
        for (User user : users) {
            //查找用户名是否已经存在
            if (!username.equals(user.getUsername())) {
                JOptionPane.showMessageDialog(this, "用户名不存在");
            }
            //检查密码
            if (!password.equals(user.getPassword())) {
                JOptionPane.showMessageDialog(this, "密码错误");
            } else {
                //检查验证码
                if (code.equals(rightCode)) {
                    JOptionPane.showMessageDialog(this, "登录成功");
                    this.dispose();
                    new GameJFrame();
                } else {
                    JOptionPane.showMessageDialog(this, "验证码错误");
                }
            }
        }
    }


     */
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

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
