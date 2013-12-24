package io.metacake.j2d.input;

import io.metacake.core.process.ActionRecognizer;

public interface KeyboardActionRecognizer extends ActionRecognizer {
    public void keyPressed(long timestamp);
    public void keyReleased(long timestamp);
}