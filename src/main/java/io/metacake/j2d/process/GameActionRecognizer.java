package io.metacake.j2d.process;

import io.metacake.core.process.ActionRecognizer;
import io.metacake.core.process.ActionRecognizerName;

/**
 * The {@code GameActionRecognizer} is the parent class for all {@link io.metacake.core.process.ActionRecognizer}s
 * in the Java 2D Engine.
 * <p>
 *     The main piece of shared behavior that it encapsulates, is the presence of an {@link io.metacake.core.process.ActionRecognizerName}
 *     in all subclasses of {@code GameActionRecognizer}.
 */
public abstract class GameActionRecognizer implements ActionRecognizer {

    /**
     * @return Generate a new Name for an {@code ActionRecognizer}.
     */
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