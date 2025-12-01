package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MyPanel extends JPanel implements ActionListener {
    final int PANEL_W = 900;
    final int PANEL_H = 700;
    Timer timer;
    private ArrayList<Particle> particles = new ArrayList<>();
    private boolean start = false;
    private int velX = 20;
    private int velY = 20;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_W,PANEL_H));
        this.setBackground(new Color(0,0,35));

        timer = new Timer(50,this);
        timer.start();
    }

    public void setStart(){
    if (!start){
    drawMany(50, Color.BLUE);
    drawMany(50, Color.RED);
    drawMany(50, Color.GREEN);
    }
    else {
        particles.clear();
        repaint();
    }
    start = !start;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Particle particle : particles){
        particle.draw(g);
        }

    }

    public void drawMany(int number, Color color){
        Random rand = new Random();
        for (int i = 0; i < number; i++) {
            int x = rand.nextInt(900);
            int y = rand.nextInt(700);
            particles.add(new Particle(x,y,color));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random rand = new Random();
        if (!particles.isEmpty()) {
            for (Particle particle : particles) {
                particle.setX(particle.getX() + particle.getVX());
                particle.setY(particle.getY() + particle.getVY());

                if (particle.getX() > 900) particle.setX(0);
                if (particle.getY() > 700) particle.setY(0);

                if (particle.getX() < 0) particle.setX(900);
                if (particle.getY() < 0) particle.setY(700);

//                int vx = rand.nextInt(velX) - 10;
//                int vy = rand.nextInt(velY) - 10;
//                particle.setVX(velX);
//                particle.setVY(velY);
            }

            repaint();
        }
    }

    public void setVelX(int vel){velX = vel;}
    public void setVelY(int vel){velY = vel;}
}
