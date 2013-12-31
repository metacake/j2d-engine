package io.metacake.j2d.process.mouserecognizers;

import io.metacake.core.process.ActionRecognizer;

public interface MouseActionRecognizer extends ActionRecognizer {

    void mousePressed(long timestamp, int x, int y);

    void mouseReleased(long timestamp, int x, int y);

    int getX();

    int getY();
}