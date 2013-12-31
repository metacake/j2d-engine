package io.metacake.j2d.process.keyrecognizers;

import io.metacake.core.process.ActionRecognizer;

public interface KeyActionRecognizer extends ActionRecognizer {

    void keyPressed(long timestamp);

    void keyReleased(long timestamp);
}