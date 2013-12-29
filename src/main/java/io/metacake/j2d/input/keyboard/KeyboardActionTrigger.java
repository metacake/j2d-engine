package io.metacake.j2d.input.keyboard;

import io.metacake.core.input.ActionTrigger;
import io.metacake.core.input.InputDeviceName;
import io.metacake.j2d.process.KeyboardActionRecognizer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class KeyboardActionTrigger implements ActionTrigger<KeyEvent> {

    private int keyCode;
    private Collection<KeyboardActionRecognizer> recognizers = new ArrayList<>();
    private long timestamp = 0;

    public KeyboardActionTrigger(int keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public boolean isTriggeredBy(KeyEvent event) {
        return event.getKeyCode() == this.keyCode;
    }

    @Override
    public InputDeviceName bindingDevice() {
        return Keyboard.NAME;
    }

    public KeyboardActionTrigger bindRecognizers(KeyboardActionRecognizer... recognizers) {
        this.recognizers.addAll(Arrays.asList(recognizers));
        return this;
    }

    public void keyPressed() {
        recognizers.forEach(trigger -> trigger.keyPressed(timestamp));
    }

    public void keyReleased() {
        recognizers.forEach(trigger -> trigger.keyReleased(timestamp));
    }

    void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}