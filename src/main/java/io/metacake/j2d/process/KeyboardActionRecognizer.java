package io.metacake.j2d.process;

import io.metacake.core.process.ActionRecognizerName;

public abstract class KeyboardActionRecognizer extends GameActionRecognizer {

    public KeyboardActionRecognizer(ActionRecognizerName name) {
        super(name);
    }

    public abstract void keyPressed(long timestamp);
    public abstract void keyReleased(long timestamp);
}