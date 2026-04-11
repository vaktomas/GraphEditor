package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.Circle;
import cz.uhk.graphed.model.GraphicGroup;
import cz.uhk.graphed.model.Square;
import cz.uhk.graphed.model.Triangle;
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

        toolBar.add(addSquareButton);
        toolBar.add(addCircleButton);
        toolBar.add(addTriangleButton);

        add(toolBar, BorderLayout.NORTH);

        addSquareButton.addActionListener(e -> addRandomObject("square"));
        addCircleButton.addActionListener(e -> addRandomObject("circle"));
        addTriangleButton.addActionListener(e -> addRandomObject("triangle"));
    }

    private void initSampleData() {
        canvas.add(new Square(new Point(100,100), Color.BLACK, 50));
        canvas.add(new Square(new Point(100,200), Color.BLUE, 50));
        canvas.add(new Square(new Point(200,100), Color.GREEN, 50));

        canvas.add(new Triangle(new Point(300,100), Color.BLACK, 50));
        canvas.add(new Triangle(new Point(300,200), Color.BLACK, 50));
        canvas.add(new Triangle(new Point(400,100), Color.BLACK, 50));

        canvas.add(new Circle(new Point(500,100), Color.BLACK, 50));
        canvas.add(new Circle(new Point(500,200), Color.BLACK, 50));
        canvas.add(new Circle(new Point(600,100), Color.BLACK, 50));


        GraphicGroup group = new GraphicGroup();
        Square s = new Square(new Point(200, 200), Color.RED, 100);
        Circle c = new Circle(new Point(200, 200), Color.RED, 100);

        canvas.add(s);
        canvas.add(c);

        group.add(s);
        group.add(c);

        canvas.add(group);
    }
    //-----------RANDOM OBJECT---------------
    private void addRandomObject(String type) {
        // generovani random pozice
        int x = (int) (Math.random() * (canvas.getWidth() - 100)); // Šířka panelu - 100 pro omezení velikosti
        int y = (int) (Math.random() * (canvas.getHeight() - 100)); // Výška panelu - 100 pro omezení velikosti
        int size = (int) (Math.random() * 100) + 30; // Velikost mezi 30 a 130 px

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
        }

        //pridani objektu do canvas
        if (object != null) {
            canvas.add(object);
            canvas.repaint();
        }
    }
}
