package io.metacake.game;

import io.metacake.core.process.ActionRecognizerName;
import io.metacake.enginetwo.input.KeyboardActionRecognizer;

public class DoublePressRecognizer implements KeyboardActionRecognizer {

    private final ActionRecognizerName NAME;
    private final long INTERVAL = 550;
    private long lastTime = 0;
    private boolean clickHappened = false;
    private boolean isTriggered = false;

    public DoublePressRecognizer(ActionRecognizerName name) {
        this.NAME = name;
    }

    @Override
    public void keyPressed(long timestamp) {
        if(clickHappened) {
            if((timestamp - lastTime) <= INTERVAL) {
                isTriggered = true;
            } else {
                isTriggered = false;
                clickHappened = false;
            }
        } else {
            clickHappened = true;
        }
        lastTime = timestamp;
    }

    @Override
    public void keyReleased(long timestamp) {
        if (isTriggered) {
            isTriggered = false;
            clickHappened = false;
        }
    }

    @Override
    public ActionRecognizerName getName() {
        return NAME;
    }

    @Override
    public boolean wasTriggered() {
        return isTriggered;
    }

    @Override
    public int triggerWeight() {
        return 1;
    }

    @Override
    public void forgetActions() {
        isTriggered = false;
        clickHappened = false;
    }
}