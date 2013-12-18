import io.metacake.core.BootstrapBuilder;
import io.metacake.core.common.CustomizableMap;
import io.metacake.core.input.InputDeviceName;
import io.metacake.core.input.TriggeredEvent;
import io.metacake.core.output.RenderingInstructionBundle;
import io.metacake.core.process.state.GameState;
import io.metacake.core.process.state.TransitionState;
import io.metacake.core.process.state.UserState;
import io.metacake.enginetwo.input.Keyboard;
import io.metacake.enginetwo.input.KeyboardTrigger;
import io.metacake.enginetwo.output.DrawingDevice;
import io.metacake.enginetwo.window.GraphicsWindow;

import java.awt.event.KeyEvent;
import java.util.List;

public class Main {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String... args) {
        BootstrapBuilder builder = new BootstrapBuilder();
        KeyboardTrigger trigger = new KeyboardTrigger(KeyEvent.VK_S);
        builder.withWindow(new GraphicsWindow(WIDTH, HEIGHT))
               .withInitialState(TransitionState.transitionWithTriggers(new ExampleState(), trigger))
               .withInputDevices(new Keyboard())
               .withOutputDevices(new DrawingDevice())
               .createAndLaunch();
    }
}

class ExampleState extends UserState {
    @Override
    public GameState tick(long delta, CustomizableMap<InputDeviceName, List<TriggeredEvent>> events) {
        if (events.containsKey(Keyboard.NAME)) {
            events.get(Keyboard.NAME).forEach(System.out::println);
        }
        return this;
    }

    @Override
    public RenderingInstructionBundle renderingInstructions() {
        return RenderingInstructionBundle.EMPTY_BUNDLE;
    }
}