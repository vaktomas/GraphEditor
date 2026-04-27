package cz.uhk.graphed.model;

import java.awt.*;

public class Triangle extends AbstractGraphicObject {
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

        //vyhlazovani
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );


        g2.setColor(color);

        int[] xPoints = {
                position.x,             //levy bod
                position.x + a / 2,     //horni bod
                position.x + a          //pravy bod
        };

        int[] yPoints = {
                position.y + a,         //levy bod
                position.y,             //horni bod
                position.y + a          //pravy bod
        };

        g2.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean contains(Point p) {
        int[] xPoints = {
                position.x,            //levy dolni vrchol
                position.x + a / 2,    //horni vrchol
                position.x + a         //pravy dolno vrchol
        };

        int[] yPoints = {
                position.y + a,        //levy dolni vrchol
                position.y,            //horni vrchol
                position.y + a         //pravy dolni vrchol
        };

        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        return triangle.contains(p);
    }
}