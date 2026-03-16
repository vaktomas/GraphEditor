package cz.uhk.graphed.gui;

import cz.uhk.graphed.model.Circle;
import cz.uhk.graphed.model.Square;
import cz.uhk.graphed.model.Triangle;

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
    }
}
