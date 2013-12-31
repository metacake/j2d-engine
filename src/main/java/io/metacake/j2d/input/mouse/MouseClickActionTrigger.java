package io.metacake.j2d.input.mouse;

import io.metacake.core.input.InputDeviceName;
import io.metacake.j2d.input.GameActionTrigger;
import io.metacake.j2d.process.mouserecognizers.MouseActionRecognizer;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MouseClickActionTrigger extends GameActionTrigger<MouseEvent> {

    public int mouseCode;
    private Collection<MouseActionRecognizer> recognizers = new ArrayList<>();

    public MouseClickActionTrigger(int mouseCode) {
        this.mouseCode = mouseCode;
    }

    @Override
    public boolean isTriggeredBy(MouseEvent event) {
        return event.getButton() == this.mouseCode;
    }

    @Override
    public InputDeviceName bindingDevice() {
        return MouseDevice.NAME;
    }

    public MouseClickActionTrigger bindRecognizers(MouseActionRecognizer... recognizers) {
        this.recognizers.addAll(Arrays.asList(recognizers));
        return this;
    }

    public void mousePressed(MouseEvent event) {
        recognizers.forEach(recognizer -> recognizer.mousePressed(this.getTimestamp(), event.getX(), event.getY()));
    }

    public void mouseReleased(MouseEvent event) {
        recognizers.forEach(recognizer -> recognizer.mouseReleased(this.getTimestamp(), event.getX(), event.getY()));
    }
}