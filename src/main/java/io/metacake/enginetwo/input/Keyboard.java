package io.metacake.enginetwo.input;


import io.metacake.core.common.window.CakeWindow;
import io.metacake.core.input.ActionTrigger;
import io.metacake.core.input.InputDeviceName;
import io.metacake.core.input.TriggeredEvent;
import io.metacake.core.input.system.InputDevice;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * @author florence
 * @author rpless
 */
public class Keyboard implements InputDevice, KeyListener {
    public static final InputDeviceName NAME = new InputDeviceName();
    private List<KeyboardTrigger> triggers = new ArrayList<>();
    private List<TriggeredEvent> queuedEvents = new ArrayList<>();

    @Override
    public InputDeviceName name() {
        return NAME;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void bind(CakeWindow window) {
        CakeWindow<JFrame> jWindow = (CakeWindow<JFrame>) window;
        jWindow.getRawWindow().addKeyListener(this);
    }

    @Override
    public void addTrigger(ActionTrigger trigger) {
        triggers.add((KeyboardTrigger) trigger);
    }

    @Override
    public void releaseTriggers() {
        triggers.clear();
    }

    @Override
    public void startInputLoop() {}

    @Override
    public void shutdown() {}

    @Override
    public List<TriggeredEvent> getTriggeredEvents() {
        List<TriggeredEvent> events = new ArrayList<>(queuedEvents);
        queuedEvents.clear();
        return events;
    }

    @Override
    public void keyTyped(KeyEvent event) {
        event.consume();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        handleKeyEvent(event);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        handleKeyEvent(event);
    }

    private void handleKeyEvent(KeyEvent event) {
        triggers.forEach(trigger -> {
            Optional<TriggeredKeyboardEvent> optionalEvent = trigger.trigger(event);
            if (optionalEvent.isPresent()) {
                queuedEvents.add(optionalEvent.get());
            }
        });
    }
}