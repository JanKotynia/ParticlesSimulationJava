package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.function.DoubleConsumer;

public class SettingPanel extends JPanel {
    SettingPanel(MyPanel mainPanel) {
        int minParticleVal =-10;
        int maxParticleVal =10;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(0, 0, 35));
        this.setPreferredSize(new Dimension(250, 0));

        this.add(Box.createVerticalStrut(20));

        MyLabel titleLabel = new MyLabel("BEHAVIOUR REGULATION");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(titleLabel);

        this.add(Box.createVerticalStrut(10));


        MyButton startButton = new MyButton("SIMULATION START");

        MyButton randomSettingsButton = new MyButton("RANDOM SETTINGS");

        startButton.addActionListener(e -> mainPanel.setStart());
        this.add(startButton);

        this.add(Box.createVerticalStrut(5));

        randomSettingsButton.addActionListener(e -> mainPanel.setRandomForce());
        this.add(randomSettingsButton);


        addSlider(minParticleVal,maxParticleVal,"GREEN TO GREEN", val -> mainPanel.setColorCombinations(val, MyPanel.G_TO_G));
        addSlider(minParticleVal,maxParticleVal,"GREEN TO RED", val -> mainPanel.setColorCombinations(val, MyPanel.G_TO_R));
        addSlider(minParticleVal,maxParticleVal,"GREEN TO BLUE", val -> mainPanel.setColorCombinations(val, MyPanel.G_TO_B));

        addSlider(minParticleVal,maxParticleVal,"RED TO GREEN", val -> mainPanel.setColorCombinations(val, MyPanel.R_TO_G));
        addSlider(minParticleVal,maxParticleVal,"RED TO RED", val -> mainPanel.setColorCombinations(val, MyPanel.R_TO_R));
        addSlider(minParticleVal,maxParticleVal,"RED TO BLUE", val -> mainPanel.setColorCombinations(val, MyPanel.R_TO_B));

        addSlider(minParticleVal,maxParticleVal,"BLUE TO GREEN", val -> mainPanel.setColorCombinations(val, MyPanel.B_TO_G));
        addSlider(minParticleVal,maxParticleVal,"BLUE TO RED", val -> mainPanel.setColorCombinations(val, MyPanel.B_TO_R));
        addSlider(minParticleVal,maxParticleVal,"BLUE TO BLUE", val -> mainPanel.setColorCombinations(val, MyPanel.B_TO_B));
    }

    private void addSlider(int min, int max, String name, DoubleConsumer onValueChange){
        SliderPanel sliderPanel = new SliderPanel(min,max,name, onValueChange);
        sliderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(sliderPanel);

    }
}