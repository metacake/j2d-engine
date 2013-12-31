package io.metacake.j2d.input.mouse;

import io.metacake.core.common.MilliTimer;
import io.metacake.core.common.window.CakeWindow;
import io.metacake.core.input.ActionTrigger;
import io.metacake.core.input.InputDeviceName;
import io.metacake.core.input.system.InputDevice;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MouseDevice extends MouseAdapter implements InputDevice {
    public static final InputDeviceName NAME = new InputDeviceName("Mouse");

    private Collection<MouseClickActionTrigger> clickTriggers = new ArrayList<>();
    private MilliTimer timer = new MilliTimer();

    @Override
    public InputDeviceName name() {
        return NAME;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void bind(CakeWindow w) {
        JFrame frame = ((CakeWindow<JFrame>) w).getRawWindow();
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
    }

    @Override
    public void addTrigger(ActionTrigger trigger) {
        if (trigger instanceof MouseClickActionTrigger) {
            clickTriggers.add((MouseClickActionTrigger) trigger);
        }
    }

    @Override
    public void releaseTriggers() {
        clickTriggers = new ArrayList<>();
    }

    @Override
    public void startInputLoop() {}

    @Override
    public void shutdown() {}

    @Override
    public void mousePressed(MouseEvent event) {
        mouseHandler(event, MouseClickActionTrigger::mousePressed);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        mouseHandler(event, MouseClickActionTrigger::mouseReleased);
    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }

    @Override
    public void mouseMoved(MouseEvent event) {

    }

    private void mouseHandler(MouseEvent event, BiConsumer<MouseClickActionTrigger, MouseEvent> consumer) {
        long time = timer.poll();
        clickTriggers.forEach(trigger -> {
            if(trigger.isTriggeredBy(event)) {
                trigger.setTimestamp(time);
                consumer.accept(trigger, event);
            }
        });
    }
}