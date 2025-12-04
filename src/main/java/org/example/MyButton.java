package org.example;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    MyButton(String text){
        setText(text);
        setBackground(new Color(35, 35, 35));
        setForeground(Color.CYAN);
        setForeground(Color.WHITE);
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
