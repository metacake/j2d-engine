package io.metacake.j2d.input.keyboard;


import io.metacake.core.common.MilliTimer;
import io.metacake.core.common.window.CakeWindow;
import io.metacake.core.input.ActionTrigger;
import io.metacake.core.input.InputDeviceName;
import io.metacake.core.input.system.InputDevice;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 *
 */
public class KeyboardDevice implements InputDevice, KeyListener {
    public static final InputDeviceName NAME = new InputDeviceName("Keyboard");
    private Collection<KeyboardActionTrigger> triggers = new ArrayList<>();
    private MilliTimer timer = new MilliTimer();

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
    public void keyPressed(KeyEvent event) {
        keyHandler(event, KeyboardActionTrigger::keyPressed);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        keyHandler(event, KeyboardActionTrigger::keyReleased);
    }

    private void keyHandler(KeyEvent event, Consumer<KeyboardActionTrigger> consumer) {
        long time = timer.poll();
        triggers.forEach(trigger -> {
            if(trigger.isTriggeredBy(event)) {
                trigger.setTimestamp(time);
                consumer.accept(trigger);
            }
        });
    }
}