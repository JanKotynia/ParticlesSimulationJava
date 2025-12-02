package org.example;

import java.awt.*;

class Particle {
    private int x, y;
    private double vx = 0.0, vy = 0.0;
    private final Color color;

    public Particle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void move() {
        x += vx;
        y += vy;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        int radius = 5;
        g.fillOval(x,y, radius, radius);
    }

    // Dodatkowe metody do obsługi odbijania od brzegów (gettery/settery)
    public int getX() { return x; }
    public int getY() { return y; }
    public void setVX(double vx) { this.vx = vx; }
    public void setVY(double vy) { this.vy = vy; }
    public double getVX() {return vx;}
    public double getVY() {return vy;}
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public Color getColor() {return this.color;}
}