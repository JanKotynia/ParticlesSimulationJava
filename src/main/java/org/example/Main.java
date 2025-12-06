package org.example;

import javax.swing.*;
import java.awt.*;

//connecting everything in main
public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MyFrame myFrame = new MyFrame();
            myFrame.setLayout(new BorderLayout());

            MyPanel mainPanel = new MyPanel();

            SettingPanel settingsPanel = new SettingPanel(mainPanel);

            JPanel centerWrapper = new JPanel(new GridBagLayout());
            centerWrapper.setBackground(Color.BLACK);
            centerWrapper.add(mainPanel);

            myFrame.add(settingsPanel, BorderLayout.WEST);
            myFrame.add(centerWrapper, BorderLayout.CENTER);


            myFrame.setSize(1920,1080);
            myFrame.setVisible(true);

            mainPanel.setOnUpdateUICallback(settingsPanel::refreshSliders);
        });
    }
}