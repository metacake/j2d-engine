package io.metacake.game;

import io.metacake.core.BootstrapBuilder;
import io.metacake.core.process.state.TransitionState;
import io.metacake.enginetwo.input.Keyboard;
import io.metacake.enginetwo.output.DrawingDevice;
import io.metacake.enginetwo.window.GraphicsWindow;

public class Main {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String... args) {
        GameConfig config = new GameConfig();

        BootstrapBuilder builder = new BootstrapBuilder();
        builder.withWindow(new GraphicsWindow(WIDTH, HEIGHT));
        builder.withInitialState(TransitionState.transition(new ExampleState(), config.getTriggers(), config.getRecognizers()));
        builder.withInputDevices(new Keyboard());
        builder.withOutputDevices(new DrawingDevice());
        builder.createAndLaunch();
    }
}