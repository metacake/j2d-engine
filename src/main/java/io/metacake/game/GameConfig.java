package io.metacake.game;

import io.metacake.core.input.ActionTrigger;
import io.metacake.core.process.ActionRecognizer;
import io.metacake.core.process.ActionRecognizerName;
import io.metacake.enginetwo.input.KeyboardActionRecognizer;
import io.metacake.enginetwo.input.KeyboardActionTrigger;

import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.LinkedList;

public class GameConfig {
    public static ActionRecognizerName PRESS_W = PressRecognizer.generateName();

    private KeyboardActionRecognizer recognizer = new PressRecognizer(PRESS_W);
    private KeyboardActionTrigger trigger = new KeyboardActionTrigger(KeyEvent.VK_W).bindRecognizers(recognizer);

    public Collection<ActionTrigger> getTriggers() {
        System.out.println("First: " + PRESS_W);
        Collection<ActionTrigger> triggers = new LinkedList<>();
        triggers.add(trigger);
        return triggers;
    }

    public Collection<ActionRecognizer> getRecognizers() {
        Collection<ActionRecognizer> recognizers = new LinkedList<>();
        recognizers.add(recognizer);
        return recognizers;
    }
}