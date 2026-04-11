package cz.uhk.graphed;

import cz.uhk.graphed.gui.EditorFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                ()-> new EditorFrame().setVisible(true)
        );


    }
}
