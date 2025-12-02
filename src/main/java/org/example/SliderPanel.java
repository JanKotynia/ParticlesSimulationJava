package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.function.DoubleConsumer;

public class SliderPanel extends JPanel {
    SliderPanel(int min, int max, String name, DoubleConsumer onValueChange){
        MyLabel label = new MyLabel(name);
        MySlider slider = new MySlider(min, max);
        JLabel valueLabel = new JLabel(String.valueOf(slider.getValue()));
        valueLabel.setForeground(Color.CYAN);
        this.setBackground(new Color(0, 0, 55));
        this.add(label);
        this.add(slider);
        this.add(valueLabel);

        slider.addChangeListener(e -> {
            int currentValue = slider.getValue();
            valueLabel.setText(String.valueOf((double) currentValue/10));
            onValueChange.accept(currentValue);
        });
    }

}
