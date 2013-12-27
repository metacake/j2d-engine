package io.metacake.j2d.process.recognizers;


import io.metacake.core.process.ActionRecognizerName;
import io.metacake.j2d.process.KeyboardActionRecognizer;

public class ReleaseActionRecognizer extends KeyboardActionRecognizer {

    private boolean triggered = false;

    public ReleaseActionRecognizer(ActionRecognizerName name) {
        super(name);
    }

    @Override
    public void keyPressed(long timestamp) {}

    @Override
    public void keyReleased(long timestamp) {
        triggered = true;
    }

    @Override
    public boolean wasTriggered() {
        return false;
    }

    @Override
    public int triggerWeight() {
        int weight = (triggered) ? 1 : 0;
        triggered = false;
        return weight;
    }

    @Override
    public void forgetActions() {
        triggered = false;
    }
}