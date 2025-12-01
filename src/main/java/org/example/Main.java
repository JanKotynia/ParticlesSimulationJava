package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
    MyFrame myFrame = new MyFrame();
    JPanel panel = new JPanel();
    MyLabel label = new MyLabel("BEHAVIOUR REGULATION");
    MyLabel label2 = new MyLabel("SIMULATION START");
    MySlider slider = new MySlider(-10,10);
    MySlider slider2 = new MySlider(-10,10);
    JButton button = new JButton();
    button.add(label2);
    button.setBackground(new Color(30,35,35));
    panel.setBackground(new Color(0,0,35));
    panel.setPreferredSize(new Dimension(300,200));
    JLabel valueLabel = new JLabel(String.valueOf(slider.getValue()));
    JLabel valueLabel2 = new JLabel(String.valueOf(slider.getValue()));
    valueLabel.setForeground(Color.CYAN);
    valueLabel2.setForeground(Color.CYAN);


    panel.add(button);
    panel.add(label);
    panel.add(slider);
    panel.add(valueLabel);
    panel.add(slider2);
    panel.add(valueLabel2);

    myFrame.add(panel,BorderLayout.WEST);

    MyPanel mainPanel = new MyPanel();

    JPanel centerWrapper = new JPanel(new GridBagLayout());
    centerWrapper.setBackground(new Color(0,0,0));

    centerWrapper.add(mainPanel);

    myFrame.setLayout(new BorderLayout());

    myFrame.add(panel, BorderLayout.WEST);
    myFrame.add(centerWrapper, BorderLayout.CENTER);

    slider.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            int currentValue = slider.getValue();
            valueLabel.setText(String.valueOf(currentValue));
            mainPanel.setVelX(currentValue);
        }
    });

    slider2.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            int currentValue = slider2.getValue();
            valueLabel2.setText(String.valueOf(currentValue));
            mainPanel.setVelY(currentValue);
        }
    });


    button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             mainPanel.setStart();
         }
    });
    }
}