package org.example;

import javax.swing.*;
import java.awt.*;

public class MySlider extends JSlider {
    MySlider(int min, int max){
        this.setMinimum(min);
        this.setMaximum(max);
        this.setPaintLabels(true);
        this.setBackground(new Color(30,35,35));

    }

}
