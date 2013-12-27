package io.metacake.j2d.process.recognizers;

import io.metacake.core.process.ActionRecognizer;
import io.metacake.core.process.ActionRecognizerName;

public abstract class GameActionRecognizer implements ActionRecognizer {

    public static ActionRecognizerName generateName() {
        return new ActionRecognizerName();
    }

    private final ActionRecognizerName name;

    public GameActionRecognizer(ActionRecognizerName name) {
        this.name = name;
    }

    @Override
    public final ActionRecognizerName getName() {
        return name;
    }
}