package io.metacake.j2d.process.keyrecognizers;

import io.metacake.core.process.ActionRecognizerName;
import io.metacake.j2d.process.recognizers.ReleaseActionRecognizer;

public class KeyReleaseRecognizer extends ReleaseActionRecognizer implements KeyActionRecognizer {

    public KeyReleaseRecognizer(ActionRecognizerName name) {
        super(name);
    }

    @Override
    public void keyPressed(long timestamp) {}

    @Override
    public void keyReleased(long timestamp) {
        setTriggered(true);
    }
}