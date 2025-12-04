package org.example;

import java.awt.*;

class Particle {
    private double x, y;
    private double vx = 0.0, vy = 0.0;
    private final Color color;
    final private int radius = 1;

    public Particle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void move() {
        x += vx;
        y += vy;

//        if(vx != 0 && vy!=0)
//            System.out.println("VX: " + vx + " VY: " + vy);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) (x - radius), (int) (y - radius), radius * 2, radius * 2);
    }

    // Dodatkowe metody do obsługi odbijania od brzegów (gettery/settery)
    public double getX() { return x; }
    public double getY() { return y; }
    public void setVX(double vx) { this.vx = vx; }
    public void setVY(double vy) { this.vy = vy; }
    public double getVX() {return vx;}
    public double getVY() {return vy;}
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public Color getColor() {return this.color;}
    public int getRadius() {return this.radius;}
}