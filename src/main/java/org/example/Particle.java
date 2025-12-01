package org.example;

import java.awt.*;

class Particle {
    private int x, y;
    private int radius = 5;
    private int vx, vy = 0;
    private Color color;

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
        g.fillOval(x,y,radius,radius);
    }

    // Dodatkowe metody do obsługi odbijania od brzegów (gettery/settery)
    public int getX() { return x; }
    public int getY() { return y; }
    public int getRadius() { return radius; }
    public void setVX(int vx) { this.vx = vx; }
    public void setVY(int vy) { this.vy = vy; }
    public int getVX() {return vx;}
    public int getVY() {return vy;}
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}