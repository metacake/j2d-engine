package io.metacake.j2d.process;

import io.metacake.core.process.ActionRecognizerName;

import java.awt.event.InputEvent;

public abstract class PressReleaseActionRecognizer extends GameActionRecognizer {

    public PressReleaseActionRecognizer(ActionRecognizerName name) {
        super(name);
    }

    public abstract void pressed(long timestamp);

    public abstract void released(long timestamp);
}