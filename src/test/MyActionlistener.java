package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionlistener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        IO.print("按钮被点击了");
    }



}
