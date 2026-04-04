package UI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , ActionListener {
    //记录空白图片的位置
    int x=0;
    int y=0;
    //初始化数据
    int[][] data =new int[4][4];
    int[][] win={{1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}

    };
    //记录步数
    int count=0;
    //创建条目对象
    JMenuItem replayItem=new JMenuItem("重新开始");
    JMenuItem reLoginItem=new JMenuItem("重新登录");
    JMenuItem closeItem=new JMenuItem("关闭游戏");

    JMenuItem accountItem=new JMenuItem("客服");
    //记录路径
    String path="image\\animal\\animal9\\";
    public GameJFrame(){
        //初始化界面
        initJFrame();
        //初始化菜单栏
        JMenuBar menuBar = initJMenuBar();
        //打乱数据
        initData(data);
        //初始化图片
        initImage(data);
        this.setVisible(true);

    }

    private void initData(int [][]data) {
        int []tempArr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,};
        Random r=new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index=r.nextInt(tempArr.length);
            int temp=tempArr[i];
            tempArr[i]=tempArr[index];
            tempArr[index]=temp;
        }

        for(int i=0;i<tempArr.length;i++){
            if(tempArr[i]==0){
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4]=tempArr[i];

        }
    }

    private void initImage(int[][]data) {
        this.getContentPane().removeAll();
        if(victory(win,data)){
            JLabel winer=new JLabel(new ImageIcon("image\\win.png"));
            winer.setBounds(203,283,197,73);
            this.getContentPane().add(winer);
        }
        JLabel steps=new JLabel("移动步数："+count);
        steps.setBounds(30,30,100,20);
        this.getContentPane().add(steps);
        //路径分为绝对路径和相对路径
        //绝对路径：D:\\javaexercise\\puzzlegame\\image\\background.png（从盘符开始）
        //推荐 相对路径：image\\background.png 在当前文件夹中寻找
        //先加载的图片在上方，后加载的图片在下方
        for (int i= 0; i< 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建ImageIcon对象ctrl+n可以查找
                int num=data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path+num+".jpg"));
                //指定图片位置
                jLabel.setBounds(j* 105+83, i*105+134, 105, 105);
                //创建边框
                //0： lowered：凹角 raised：凸角
                //1： lowered raised 凹下去
                jLabel.setBorder(new BevelBorder(0));
                this.getContentPane().add(jLabel);
            }
        }
        //设置背景图
        ImageIcon icon=new ImageIcon("image\\background.png");
        JLabel background=new JLabel(icon);
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);
        this.getContentPane().repaint();
    }

    //初始化菜单栏
    private JMenuBar initJMenuBar() {
        //初始化菜单栏
        JMenuBar menuBar = new JMenuBar();
        //创建菜单的对象
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");
        //将条目添加到菜单中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);
        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        //将菜单添加到菜单栏中
        menuBar.add(functionJMenu);
        menuBar.add(aboutJMenu);
        //给整个界面设置菜单栏
        this.setJMenuBar(menuBar);
        return menuBar;
    }

    //初始化界面
    private void initJFrame() {
        //设置界面
        this.setSize(603,680);//游戏主界面
        this.setTitle("拼图游戏1.0");
        //将界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.addKeyListener(this);
        //设置关闭模式 0~3
        //0：默认模式，点击窗口关闭不做任何处理
        //1：关闭窗口不退出程序
        //2：点击窗口关闭，程序也退出，必须对每个程序都创建一个
        //3：点击窗口关闭，程序也退出，只要关掉其中一个窗口，程序就退出了
        this.setDefaultCloseOperation(3);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(victory(win,data)){
            return;
        }
        if(code==84){
            this.getContentPane().removeAll();
            JLabel all=new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            ImageIcon icon=new ImageIcon("image\\background.png");
            JLabel background=new JLabel(icon);
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //上：38 下：40 左：37 右：39
        //w：87 s：83 a：65 d：68
        //KeyCode不区分大小写 getKeyCode区分大小写
        int code=e.getKeyCode();
        if(victory(win,data)){
            IO.println("恭喜你，游戏胜利！");
            return;
        }
        if(code==38||code==87){
            if (x>0) {
                IO.println("向上");
                //把空白位置图片往上移
                data[x][y]=data[x-1][y];
                data[x-1][y]=0;
                x--;
                count++;
                initImage(data);
            }
            else {
                IO.println("无法移动~");
            }
        }else if(code==40||code==83){
            if (x<3) {
                IO.println("向下");
                //把空白位置图片往下移
                data[x][y]=data[x+1][y];
                data[x+1][y]=0;
                x++;
                count++;
                initImage(data);
            }
            else {
                IO.println("无法移动~");
            }
        }else if(code==37||code==65){
                if (y>0) {
                    IO.println("向左");
                    //把空白位置图片往左移
                    data[x][y]=data[x][y-1];
                    data[x][y-1]=0;
                    y--;
                    count++;
                    initImage(data);
                }
                else {
                    IO.println("无法移动~");
                }
        }
        else if(code==39||code==68){
            if (y<3) {
                IO.println("向右");
                //把空白位置图片往右移
                data[x][y]=data[x][y+1];
                data[x][y+1]=0;
                y++;
                count++;
                initImage(data);
            }
            else {
                IO.println("无法移动~");
            }
        }
        else if(code==84){
            initImage(data);
        }
        else if(code==88){
            data=new int [][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            x=3;
            y=3;
            initImage(data);
        }
    }
    public boolean victory(int [][]win,int[][]data){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win[i][j])
                    return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        if(obj==replayItem){

            initData(data);
            count=0;
            initImage(data);
        }else if(obj==reLoginItem){
            this.setVisible(false);
            new LoginJFrame();
        }else if(obj==closeItem){
             System.exit(0);
        }else {
             JLabel jLabel=new JLabel(new ImageIcon("image\\about.jpg"));
             //创建一个弹框
             JDialog jd=new JDialog();
             jd.getContentPane().setLayout(null);
             jLabel.setBounds(45,20,420,420);
             jd.getContentPane().add(jLabel);
             jd.setSize(520,520);
             //让弹框置顶
             jd.setAlwaysOnTop(true);
             //让弹框居中
             jd.setLocationRelativeTo(null);
             //弹框不关闭无法进行其他操作
             jd.setModal(true);
             jd.setVisible(true);
        }
    }
}
