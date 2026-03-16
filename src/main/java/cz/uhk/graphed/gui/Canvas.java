package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.AbstractGrapicObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private List<AbstractGrapicObject> grapicObjects = new ArrayList<>();

    public Canvas() {
        setPreferredSize(new Dimension(800, 600));
    }

    public void add(AbstractGrapicObject object) {
        grapicObjects.add(object);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (var o : grapicObjects) {
            o.draw(g);
        }
    }
}
