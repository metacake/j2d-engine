package io.metacake.enginetwo.input;


import io.metacake.core.common.window.CakeWindow;
import io.metacake.core.input.ActionTrigger;
import io.metacake.core.input.InputDeviceName;
import io.metacake.core.input.system.InputDevice;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;

public class Keyboard implements InputDevice, KeyListener {
    public static final InputDeviceName NAME = new InputDeviceName();
    private Collection<KeyboardActionTrigger> triggers = new ArrayList<>();

    @Override
    public InputDeviceName name() {
        return NAME;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void bind(CakeWindow w) {
        CakeWindow<JFrame> jFrameCakeWindow = (CakeWindow<JFrame>) w;
        jFrameCakeWindow.getRawWindow().addKeyListener(this);
    }

    @Override
    public void addTrigger(ActionTrigger trigger) {
        triggers.add((KeyboardActionTrigger) trigger);
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
    public void keyTyped(KeyEvent e) {
        e.consume();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        triggers.forEach(trigger -> {
            if (trigger.isTriggeredBy(e)) {
                trigger.keyPressed();
            }
        });
    }

    @Override
    public void keyReleased(KeyEvent e) {
        triggers.forEach(trigger -> {
            if (trigger.isTriggeredBy(e)) {
                trigger.keyReleased();
            }
        });
    }
}