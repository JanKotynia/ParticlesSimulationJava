package org.example;

import javax.swing.*;
import java.awt.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleConsumer;

public class SettingPanel extends JPanel {

    private Map<String, SliderPanel> sliderPanelMap = new HashMap();
    private MyPanel myPanel;

    SettingPanel(MyPanel mainPanel) {
        this.myPanel = mainPanel;
        int minParticleVal =-10;
        int maxParticleVal =10;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(0, 0, 35));
        this.setPreferredSize(new Dimension(250, 0));

        this.add(Box.createVerticalStrut(5));

        MyLabel titleLabel = new MyLabel("BEHAVIOUR REGULATION");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(titleLabel);

        this.add(Box.createVerticalStrut(10));


        MyButton startButton = new MyButton("SIMULATION START");

        MyButton randomSettingsButton = new MyButton("RANDOM SETTINGS");

        startButton.addActionListener(e -> mainPanel.setStart());
        this.add(startButton);

        addSlider(0,1000,myPanel.getGreenAmount(),"GREEN AMOUNT",1.0, val -> mainPanel.setGreenAmount((int) val));
        addSlider(0,1000,myPanel.getRedAmount(),"RED AMOUNT", 1.0,val -> mainPanel.setRedAmount((int) val));
        addSlider(0,1000,myPanel.getBlueAmount(),"BLUE AMOUNT", 1.0,val -> mainPanel.setBlueAmount((int) val));

        this.add(Box.createVerticalStrut(5));
        randomSettingsButton.addActionListener(e -> mainPanel.setRandomForce());
        this.add(randomSettingsButton);


        addSlider(minParticleVal,maxParticleVal,0,"GREEN TO GREEN", 10.0,val -> mainPanel.setColorCombinations(val, MyPanel.G_TO_G));
        addSlider(minParticleVal,maxParticleVal,0,"GREEN TO RED", 10.0,val -> mainPanel.setColorCombinations(val, MyPanel.G_TO_R));
        addSlider(minParticleVal,maxParticleVal,0,"GREEN TO BLUE", 10.0,val -> mainPanel.setColorCombinations(val, MyPanel.G_TO_B));

        addSlider(minParticleVal,maxParticleVal,0,"RED TO GREEN", 10.0,val -> mainPanel.setColorCombinations(val, MyPanel.R_TO_G));
        addSlider(minParticleVal,maxParticleVal,0,"RED TO RED", 10.0,val -> mainPanel.setColorCombinations(val, MyPanel.R_TO_R));
        addSlider(minParticleVal,maxParticleVal,0,"RED TO BLUE", 10.0,val -> mainPanel.setColorCombinations(val, MyPanel.R_TO_B));

        addSlider(minParticleVal,maxParticleVal,0,"BLUE TO GREEN", 10.0,val -> mainPanel.setColorCombinations(val, MyPanel.B_TO_G));
        addSlider(minParticleVal,maxParticleVal,0,"BLUE TO RED", 10.0,val -> mainPanel.setColorCombinations(val, MyPanel.B_TO_R));
        addSlider(minParticleVal,maxParticleVal,0,"BLUE TO BLUE", 10.0,val -> mainPanel.setColorCombinations(val, MyPanel.B_TO_B));
    }

    private void addSlider(int min, int max, int startVal, String name, double scale, DoubleConsumer onValueChange){
        SliderPanel sliderPanel = new SliderPanel(min,max,startVal, name, scale, onValueChange);
        sliderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        sliderPanelMap.put(name,sliderPanel);
        this.add(sliderPanel);

    }

    public void refreshSliders() {
        if (sliderPanelMap.containsKey("GREEN TO GREEN")){
            sliderPanelMap.get("GREEN TO GREEN").setNewVal(myPanel.getColorCombinations()[0]);
        }

        if (sliderPanelMap.containsKey("GREEN TO RED")){
            sliderPanelMap.get("GREEN TO RED").setNewVal(myPanel.getColorCombinations()[1]);
        }

        if (sliderPanelMap.containsKey("GREEN TO BLUE")){
            sliderPanelMap.get("GREEN TO BLUE").setNewVal(myPanel.getColorCombinations()[2]);
        }

        if (sliderPanelMap.containsKey("RED TO GREEN")){
            sliderPanelMap.get("RED TO GREEN").setNewVal(myPanel.getColorCombinations()[3]);
        }

        if (sliderPanelMap.containsKey("RED TO RED")){
            sliderPanelMap.get("RED TO RED").setNewVal(myPanel.getColorCombinations()[4]);
        }

        if (sliderPanelMap.containsKey("BLUE TO GREEN")){
            sliderPanelMap.get("BLUE TO GREEN").setNewVal(myPanel.getColorCombinations()[5]);
        }

        if (sliderPanelMap.containsKey("BLUE TO RED")){
            sliderPanelMap.get("BLUE TO RED").setNewVal(myPanel.getColorCombinations()[6]);
        }

        if (sliderPanelMap.containsKey("BLUE TO BLUE")){
            sliderPanelMap.get("BLUE TO BLUE").setNewVal(myPanel.getColorCombinations()[7]);
        }
    }
}