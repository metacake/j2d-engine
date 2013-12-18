package io.metacake.enginetwo.input;

import io.metacake.core.input.ActionTrigger;
import io.metacake.core.input.InputDeviceName;
import io.metacake.core.input.TriggeredEvent;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * This recognizer only recognizes if a key has been activated in ANY way. This means press, release, or hold.
 */
public class KeyboardTrigger implements ActionTrigger<KeyEvent> {
    private List<Integer> codes;

    public KeyboardTrigger(Integer... codes) {
        this.codes = Arrays.asList(codes);
    }

    @Override
    public Optional<TriggeredKeyboardEvent> trigger(KeyEvent event) {
        return (codes.contains(event.getKeyCode())) ? Optional.of(new TriggeredKeyboardEvent()) : Optional.<TriggeredKeyboardEvent>empty();
    }

    @Override
    public InputDeviceName bindingDevice() {
        return Keyboard.NAME;
    }
}