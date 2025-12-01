package org.example;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        ImageIcon imageIcon = new ImageIcon("src/main/assets/logo.png");
        this.setIconImage(imageIcon.getImage());
        this.setTitle("Simulation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(1920,1080);
        this.getContentPane().setBackground(new Color(0,0,35));
        this.setVisible(true);
    }
}
