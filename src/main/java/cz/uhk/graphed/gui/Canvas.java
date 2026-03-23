package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.AbstractGrapicObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private List<AbstractGrapicObject> grapicObjects = new ArrayList<>();
    private AbstractGrapicObject selectedObject = null; // aktualne vybrany objekt
    private Point dragOffset = null; // posun mezi kliknutim a pozici objektu

    public Canvas() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 600));

        // dragovani objektu
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedObject != null && dragOffset != null) {
                    // posun objektu podle offsetu
                    int newX = e.getX() - dragOffset.x;
                    int newY = e.getY() - dragOffset.y;
                    selectedObject.setPosition(new Point(newX, newY));
                    repaint();
                }
            }
        });

        // kliknuti a uvolneni mys
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // vyber objekt pod mysi
                selectedObject = findObjectContaining(e.getPoint());
                if (selectedObject != null) {
                    // spocitame offset mezi kliknutim a pozici objektu
                    Point pos = selectedObject.getPosition();
                    dragOffset = new Point(e.getX() - pos.x, e.getY() - pos.y);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // uvolnime objekt
                selectedObject = null;
                dragOffset = null;
            }
        });
    }

    // najde prvni objekt obsahujici bod
    private AbstractGrapicObject findObjectContaining(Point point) {
        for (int i = grapicObjects.size() - 1; i >= 0; i--) {
            AbstractGrapicObject object = grapicObjects.get(i);
            if (object.contains(point)) {
                return object;
            }
        }
        return null;
    }

    // pridani objektu
    public void add(AbstractGrapicObject object) {
        grapicObjects.add(object);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (var o : grapicObjects) {
            o.draw(g);
        }
    }
}