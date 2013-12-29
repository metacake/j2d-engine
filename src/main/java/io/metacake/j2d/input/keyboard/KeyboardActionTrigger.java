package io.metacake.j2d.input.keyboard;

import io.metacake.core.input.ActionTrigger;
import io.metacake.core.input.InputDeviceName;
import io.metacake.j2d.input.GameActionTrigger;
import io.metacake.j2d.process.KeyboardActionRecognizer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * A {@code KeyboardActionTrigger} is an {@link io.metacake.core.input.ActionTrigger} that recognizes
 * {@link java.awt.event.KeyEvent}s.
 * <p>
 *     There are several notable implementation details.
 *     Firstly, see the concern below.
 *     Secondly, the timestamp is set externally (by the @{link KeyboardDevice}) rather than internally on a call to
 *     {@link KeyboardActionTrigger#keyPressed()} or {@link KeyboardActionTrigger#keyReleased()}. This decision was made for
 *     the performance gain of making a system call once in the {@link KeyboardDevice} instead
 *     of every time a call to a recognizer is made. Basically, we lose accuracy (and a several method arguments) in favor of performance.
 * </p>
 * TODO: Currently, we only accept one KeyCode. What we really need is to accept multiple keycodes as well as Shift/alt/function Masks
 */
public class KeyboardActionTrigger extends GameActionTrigger<KeyEvent> {

    private int keyCode;
    private Collection<KeyboardActionRecognizer> recognizers = new ArrayList<>();

    public KeyboardActionTrigger(int keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public boolean isTriggeredBy(KeyEvent event) {
        return event.getKeyCode() == this.keyCode;
    }

    @Override
    public InputDeviceName bindingDevice() {
        return KeyboardDevice.NAME;
    }

    public KeyboardActionTrigger bindRecognizers(KeyboardActionRecognizer... recognizers) {
        this.recognizers.addAll(Arrays.asList(recognizers));
        return this;
    }

    public void keyPressed() {
        recognizers.forEach(trigger -> trigger.keyPressed(this.getTimestamp()));
    }

    public void keyReleased() {
        recognizers.forEach(trigger -> trigger.keyReleased(this.getTimestamp()));
    }
}