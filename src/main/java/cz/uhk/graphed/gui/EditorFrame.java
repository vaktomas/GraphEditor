package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.Circle;
import cz.uhk.graphed.model.GraphicGroup;
import cz.uhk.graphed.model.Square;
import cz.uhk.graphed.model.Triangle;
import cz.uhk.graphed.model.Rectangle;
import cz.uhk.graphed.model.AbstractGraphicObject;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JToolBar;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends JFrame {

    private Canvas canvas = new Canvas();

    public EditorFrame() throws HeadlessException {
        super("FIM Graphic Editor");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(canvas, BorderLayout.CENTER);

        initSampleData();

        pack();


        //------------TOOLBAR--------------
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false); // lišta není plovoucí

        JButton addSquareButton = new JButton("Add Square");
        JButton addCircleButton = new JButton("Add Circle");
        JButton addTriangleButton = new JButton("Add Triangle");
        JButton addRectButton = new JButton("Add Rectangle");

        toolBar.add(addRectButton);
        toolBar.add(addSquareButton);
        toolBar.add(addCircleButton);
        toolBar.add(addTriangleButton);

        add(toolBar, BorderLayout.NORTH);

        addSquareButton.addActionListener(e -> addRandomObject("square"));
        addCircleButton.addActionListener(e -> addRandomObject("circle"));
        addTriangleButton.addActionListener(e -> addRandomObject("triangle"));
        addRectButton.addActionListener(e -> addRandomObject("rectangle"));
    }

    private void initSampleData() {
        canvas.add(new Square(new Point(50, 0), Color.BLACK, 50));
        canvas.add(new Square(new Point(50, 100), Color.BLUE, 50));
        canvas.add(new Square(new Point(50, 200), Color.GREEN, 50));

        canvas.add(new Triangle(new Point(200, 0), Color.BLACK, 50));
        canvas.add(new Triangle(new Point(200, 100), Color.BLACK, 50));
        canvas.add(new Triangle(new Point(200, 200), Color.BLACK, 50));

        canvas.add(new Circle(new Point(350, 0), Color.BLACK, 50));
        canvas.add(new Circle(new Point(350, 100), Color.BLACK, 50));
        canvas.add(new Circle(new Point(350, 200), Color.BLACK, 50));

        canvas.add(new Rectangle(new Point(550, 0), Color.BLACK, 100, 50));
        canvas.add(new Rectangle(new Point(550, 100), Color.MAGENTA, 100, 50));
        canvas.add(new Rectangle(new Point(550, 200), Color.ORANGE, 100, 50));


        GraphicGroup group = new GraphicGroup();
        Square s = new Square(new Point(150, 300), Color.RED, 100);
        Circle c = new Circle(new Point(150, 300), Color.RED, 100);

        canvas.add(s);
        canvas.add(c);

        group.add(s);
        group.add(c);

        canvas.add(group);
    }
    //-----------RANDOM OBJECT---------------
    private void addRandomObject(String type) {
        // generovani random pozice
        int size = (int) (Math.random() * 100) + 30; // Velikost mezi 30 a 130 px

        int limit;

        if (type.equals("circle")) {
            limit = size * 2;
        } else {
            limit = size;
        }

        int x = (int) (Math.random() * (canvas.getWidth() - limit)); // Šířka panelu - 100 pro omezení velikosti
        int y = (int) (Math.random() * (canvas.getHeight() - limit)); // Výška panelu - 100 pro omezení velikosti


        //vytvoreni objektu podle typu
        AbstractGraphicObject object = null;

        switch (type) {
            case "square":
                object = new Square(new Point(x, y), Color.BLACK, size);
                break;
            case "circle":
                object = new Circle(new Point(x, y), Color.BLACK, size);
                break;
            case "triangle":
                object = new Triangle(new Point(x, y), Color.BLACK, size);
                break;
            case "rectangle":
                int height = (int) (Math.random() * 100) + 30;
                object = new Rectangle(new Point(x, y), Color.BLACK, size, height);
                break;
        }

        //pridani objektu do canvas
        if (object != null) {
            canvas.add(object);
            canvas.repaint();
        }
    }
}
