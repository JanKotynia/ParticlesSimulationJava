package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.function.DoubleConsumer;

public class SettingPanel extends JPanel {
    SettingPanel(MyPanel mainPanel) {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(0, 0, 35));
        this.setPreferredSize(new Dimension(250, 0));

        this.add(Box.createVerticalStrut(20));

        MyLabel titleLabel = new MyLabel("BEHAVIOUR REGULATION");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(titleLabel);

        this.add(Box.createVerticalStrut(10));

        JButton startButton = new JButton("SIMULATION START");
        startButton.setBackground(new Color(35, 35, 35));
        startButton.setForeground(Color.CYAN);
        startButton.setForeground(Color.WHITE);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e -> mainPanel.setStart());
        this.add(startButton);


        addSlider(-10,10,"GREEN TO GREEN", val -> mainPanel.setColorCombinations(val, MyPanel.G_TO_G));
        addSlider(-10,10,"GREEN TO RED", val -> mainPanel.setColorCombinations(val, MyPanel.G_TO_R));
        addSlider(-10,10,"GREEN TO BLUE", val -> mainPanel.setColorCombinations(val, MyPanel.G_TO_B));

        addSlider(-10,10,"RED TO GREEN", val -> mainPanel.setColorCombinations(val, MyPanel.R_TO_G));
        addSlider(-10,10,"RED TO RED", val -> mainPanel.setColorCombinations(val, MyPanel.R_TO_R));
        addSlider(-10,10,"RED TO BLUE", val -> mainPanel.setColorCombinations(val, MyPanel.R_TO_B));

        addSlider(-10,10,"BLUE TO GREEN", val -> mainPanel.setColorCombinations(val, MyPanel.B_TO_G));
        addSlider(-10,10,"BLUE TO RED", val -> mainPanel.setColorCombinations(val, MyPanel.B_TO_R));
        addSlider(-10,10,"BLUE TO BLUE", val -> mainPanel.setColorCombinations(val, MyPanel.B_TO_B));
    }

    private void addSlider(int min, int max, String name, DoubleConsumer onValueChange){
        SliderPanel sliderPanel = new SliderPanel(min,max,name, onValueChange);
        sliderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(sliderPanel);

    }
}