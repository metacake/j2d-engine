package io.metacake.game;

import io.metacake.core.process.ActionRecognizerName;
import io.metacake.enginetwo.input.KeyboardActionRecognizer;

class PressRecognizer implements KeyboardActionRecognizer {

    public static ActionRecognizerName generateName() {
        return new ActionRecognizerName();
    }

    private ActionRecognizerName name;
    private boolean isHeld;

    public PressRecognizer(ActionRecognizerName name) {
        this.name = name;
    }

    @Override
    public void keyPressed(long time) {
        isHeld = true;
    }

    @Override
    public void keyReleased(long time) {
        isHeld = false;
    }

    @Override
    public ActionRecognizerName getName() {
        return name;
    }

    @Override
    public boolean wasTriggered() {
        return isHeld;
    }

    @Override
    public int triggerWeight() {
        return 1;
    }

    @Override
    public void forgetActions() {
        isHeld = false;
    }
}