package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.AbstractGraphicObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JPanel {
    private List<AbstractGraphicObject> grapicObjects = new ArrayList<>();
    private AbstractGraphicObject selectedObject = null; // aktualne vybrany objekt
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
                    int dx = e.getX() - dragOffset.x - selectedObject.getPosition().x;
                    int dy = e.getY() - dragOffset.y - selectedObject.getPosition().y;

                    selectedObject.move(dx, dy);
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
    private AbstractGraphicObject findObjectContaining(Point point) {
        for (int i = grapicObjects.size() - 1; i >= 0; i--) {
            AbstractGraphicObject object = grapicObjects.get(i);
            if (object.contains(point)) {
                return object;
            }
        }
        return null;
    }

    // pridani objektu
    public void add(AbstractGraphicObject object) {
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