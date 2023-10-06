package org.example.lect_2;

import java.awt.*;

public interface Interactable {
    void update(MainCanvas canvas, float deltaTime);

    void render(MainCanvas canvas, Graphics g);
}
