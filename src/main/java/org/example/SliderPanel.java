package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.function.DoubleConsumer;

public class SliderPanel extends JPanel {
    private MySlider slider;
    private JLabel valueLabel;

    SliderPanel(int min, int max, int startVal, String name,double scale, DoubleConsumer onValueChange){
        MyLabel label = new MyLabel(name);
        this.slider = new MySlider(min, max);
        slider.setValue(startVal);
        this.valueLabel = new JLabel(String.valueOf(startVal));
        valueLabel.setForeground(Color.CYAN);
        this.setBackground(new Color(0, 0, 55));
        this.add(label);
        this.add(slider);
        this.add(valueLabel);

        slider.addChangeListener(e -> {
            int currentValue = slider.getValue();
            if(scale == 1.0){
                valueLabel.setText(String.valueOf(currentValue));
                onValueChange.accept(currentValue);
            }else {
                valueLabel.setText(String.valueOf(currentValue / 10.0));
                onValueChange.accept((double) currentValue / 10);
            }
        });

    }

    public void setNewVal(double val){
        slider.setValue((int) (val*10));
        valueLabel.setText(String.format("%.1f", val));
    }

}
