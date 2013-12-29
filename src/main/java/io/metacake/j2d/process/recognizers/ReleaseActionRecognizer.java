package io.metacake.j2d.process.recognizers;


import io.metacake.core.process.ActionRecognizerName;
import io.metacake.j2d.process.PressReleaseActionRecognizer;

/**
 * The {@code ReleaseActionRecognizer} recognizes actions that involve releasing a key.
 */
public class ReleaseActionRecognizer extends PressReleaseActionRecognizer {

    private boolean triggered = false;

    public ReleaseActionRecognizer(ActionRecognizerName name) {
        super(name);
    }

    @Override
    public void pressed(long timestamp) {}

    @Override
    public void released(long timestamp) {
        triggered = true;
    }

    /**
     * Effect: Always reset the Recognizer.
     * @return true if triggered.
     */
    @Override
    public boolean wasTriggered() {
        boolean isTriggered = triggered;
        triggered = false;
        return isTriggered;
    }

    @Override
    public int triggerWeight() {
        return 1;
    }

    @Override
    public void forgetActions() {
        triggered = false;
    }
}