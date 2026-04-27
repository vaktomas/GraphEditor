package cz.uhk.graphed.model;

import java.awt.*;

public class Rectangle extends AbstractGraphicObject {
    protected int w; // šířka
    protected int h; // výška

    public Rectangle() {}

    public Rectangle(Point position, Color color, int w, int h) {
        super(position, color);
        this.w = w;
        this.h = h;
    }

    public int getW() { return w; }
    public void setW(int w) { this.w = w; }
    public int getH() { return h; }
    public void setH(int h) { this.h = h; }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.drawRect(position.x, position.y, w, h);
    }

    @Override
    public boolean contains(Point p) {
        return p.x >= position.x &&         //vpravo
                p.x <= position.x + w &&    //vlevo
                p.y >= position.y &&        //pod horním okrajem
                p.y <= position.y + h;      //nad dolním okrajem
    }
}