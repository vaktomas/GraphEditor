package cz.uhk.graphed.model;

import java.awt.*;

public abstract class AbstractGrapicObject {
    protected Point position;
    protected Color color;

    public AbstractGrapicObject(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public AbstractGrapicObject() {
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        setPosition(new Point(x,y));
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);


    public abstract boolean contains(Point p);


    public boolean contains(int x, int y) {
        return contains(new Point(x,y));
    }
}
