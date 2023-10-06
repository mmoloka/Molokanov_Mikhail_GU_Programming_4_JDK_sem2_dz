package org.example.lect_2;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 100;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final Interactable[] interactables = new Interactable[11];

    private MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setTitle("Circles");
        interactables[0] = new Background();
        for (int i = 1; i < interactables.length; i++) {
            interactables[i] = new Bricks();
        }
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
