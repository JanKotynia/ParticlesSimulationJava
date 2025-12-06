package org.example;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        ImageIcon imageIcon = new ImageIcon("src/main/assets/logo.png");
        this.setIconImage(imageIcon.getImage());
        this.setTitle("Simulation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setExtendedState(MyFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.getContentPane().setBackground(new Color(0,0,35));
        this.setVisible(true);
    }
}
