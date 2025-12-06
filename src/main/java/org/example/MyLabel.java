package org.example;

import javax.swing.*;
import java.awt.*;


public class MyLabel extends JLabel {
    MyLabel(String text){
        this.setText(text);
        this.setForeground(Color.CYAN);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setFont(new Font("Courier New", Font.BOLD, 15));
        this.setVisible(true);

    }
}
