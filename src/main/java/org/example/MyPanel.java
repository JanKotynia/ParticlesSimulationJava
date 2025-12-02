package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MyPanel extends JPanel implements ActionListener {
    final int PANEL_W = 1000;
    final int PANEL_H = 700;
    Timer timer;
    private final ArrayList<Particle> particles = new ArrayList<>();
    private boolean start = false;

    private double[] colorCombinations= new double[9];
    //I assign every color combination to a specific index number
    //GtoG 0 GtoR 1 GtoB 2 RtoG 3 RtoR 4 RtoB 5 BtoG 6 BtoR 7 BtoB 8

    //GREEN
    public static final int G_TO_G = 0;
    public static final int G_TO_R = 1;
    public static final int G_TO_B = 2;
    //RED
    public static final int R_TO_G = 3;
    public static final int R_TO_R = 4;
    public static final int R_TO_B = 5;
    //BLUE
    public static final int B_TO_G = 6;
    public static final int B_TO_R = 7;
    public static final int B_TO_B = 8;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_W,PANEL_H));
        this.setBackground(new Color(0,0,35));

        timer = new Timer(50,this);
        timer.start();
    }

    public void setStart(){
    if (!start){
    drawMany(100, Color.RED);
    drawMany(100, Color.GREEN);
    drawMany(100, Color.BLUE);
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
        if (!particles.isEmpty()) {
            Map<Color, ArrayList<Particle>> groupedParticles = particles.stream()
                    .collect(Collectors.groupingBy(
                            Particle::getColor,
                            Collectors.toCollection(ArrayList::new)
                    ));
            ArrayList<Particle> g = groupedParticles.getOrDefault(Color.GREEN, new ArrayList<>());
            ArrayList<Particle> b = groupedParticles.getOrDefault(Color.BLUE, new ArrayList<>());
            ArrayList<Particle> r = groupedParticles.getOrDefault(Color.RED, new ArrayList<>());


            force(g,g,colorCombinations[G_TO_G]/10);
            force(g,r,colorCombinations[G_TO_R]/10);
            force(g,b,colorCombinations[G_TO_B]/10);

            force(r,g,colorCombinations[R_TO_G]/10);
            force(r,r,colorCombinations[R_TO_R]/10);
            force(r,b,colorCombinations[R_TO_B]/10);

            force(b,g,colorCombinations[B_TO_G]/10);
            force(b,r,colorCombinations[B_TO_R]/10);
            force(b,b,colorCombinations[B_TO_B]/10);

            repaint();
        }
    }

    public void force(ArrayList<Particle> p1, ArrayList<Particle> p2, double amonut){
        for (Particle particle : p1) {
            double fx = 0;
            double fy = 0;
            for (Particle particle2 : p2) {
                int dx = particle.getX() - particle2.getX();
                int dy = particle.getY() - particle2.getY();
                double d = Math.sqrt(dx + dx + dy * dy);
                if (d > 0 && d < 100) {
                    double F = amonut * 1 / d;
                    fx += (F * dx);
                    fy += (F * dy);
                }
            }
            particle.setVX((particle.getVX() + fx) * 0.8);
            particle.setVY((particle.getVY() + fy) * 0.8);
            particle.move();
            particle.move();

            if (particle.getX() >= PANEL_W || particle.getX() <= 0) {particle.setVX(particle.getVX() * -1);}
            if (particle.getY() >= PANEL_H || particle.getY() <= 0) {particle.setVY(particle.getVY() * -1);}



        }
    }


    public void setColorCombinations(double v, int index) {
        colorCombinations[index] = v;
    }
}
