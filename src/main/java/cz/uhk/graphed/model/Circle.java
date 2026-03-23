package cz.uhk.graphed.model;

import java.awt.*;

public class Circle extends AbstractGrapicObject {
    protected int r;

    public Circle() {}

    public Circle(Point position, Color color, int r) {
        super(position, color);
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(color);
        g2.drawOval(position.x, position.y, r * 2, r * 2);
    }

    @Override
    public boolean contains(Point p) {
        int centerX = position.x + r;           //stred x
        int centerY = position.y + r;           //stred y

        int dx = p.x - centerX;
        int dy = p.y - centerY;

        return dx * dx + dy * dy <= r * r;      //vzdalenost² = dx² + dy²
    }
}