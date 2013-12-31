package io.metacake.j2d.process.mouserecognizers;

import io.metacake.core.process.ActionRecognizerName;
import io.metacake.j2d.process.PressReleaseActionRecognizer;
import io.metacake.j2d.process.recognizers.ReleaseActionRecognizer;

public class MouseReleaseActionRecognizer extends ReleaseActionRecognizer implements MouseActionRecognizer {
    private int x, y;

    public MouseReleaseActionRecognizer(ActionRecognizerName name) {
        super(name);
    }

    @Override
    public void mousePressed(long timestamp, int x, int y) {}

    @Override
    public void mouseReleased(long timestamp, int x, int y) {
        this.x = x;
        this.y = y;
        setTriggered(true);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}