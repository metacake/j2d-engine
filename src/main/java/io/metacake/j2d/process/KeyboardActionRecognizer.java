package io.metacake.j2d.process;

import io.metacake.core.process.ActionRecognizerName;

/**
 * The {@code KeyboardActionRecognizer} represents a recognizer that is only used for the actions triggered by a
 * {@link io.metacake.j2d.input.keyboard.KeyboardDevice}.
 */
public abstract class KeyboardActionRecognizer extends GameActionRecognizer {

    public KeyboardActionRecognizer(ActionRecognizerName name) {
        super(name);
    }

    /**
     * Called by the {@link io.metacake.j2d.input.keyboard.KeyboardActionTrigger} to signal that the key has been pressed.
     * @param timestamp The time that the key press occurred
     */
    public abstract void keyPressed(long timestamp);

    /**
     * Called by the {@link io.metacake.j2d.input.keyboard.KeyboardActionTrigger} to signal that the key has been released.
     * @param timestamp The time that the key release occurred
     */
    public abstract void keyReleased(long timestamp);
}