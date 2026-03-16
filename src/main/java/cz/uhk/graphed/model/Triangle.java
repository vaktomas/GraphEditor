package cz.uhk.graphed.model;

import java.awt.*;

public class Triangle extends AbstractGrapicObject {
    protected int a;

    public Triangle() {}

    public Triangle(Point position, Color color, int a) {
        super(position, color);
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);

        int[] xPoints = {
                position.x,
                position.x + a / 2,
                position.x + a
        };

        int[] yPoints = {
                position.y + a,
                position.y,
                position.y + a
        };

        g2.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }
}