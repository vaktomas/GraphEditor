package cz.uhk.graphed.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//seskupeni grafickych objektu
public class GraphicGroup extends AbstractGraphicObject {
    private List<AbstractGraphicObject> items = new ArrayList<>();

    @Override
    public void draw(Graphics g) {
        for (var it : items) {
            it.draw(g);
        }
    }

    @Override
    public boolean contains(Point p) {

        for (var it : items) {
            if (it.contains(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(int dx, int dy) {
        for (var it : items) {
            it.move(dx, dy);
        }
    }

    @Override
    public Point getPosition() {
        if (items.isEmpty()) return new Point(0,0);
        return items.get(0).getPosition();
    }

    public void add(AbstractGraphicObject obj) {
        if (obj != null) {
            items.add(obj);
        }
    }
}
