import io.metacake.core.BootstrapBuilder;
import io.metacake.core.common.CustomizableMap;
import io.metacake.core.output.RenderingInstructionBundle;
import io.metacake.core.process.ActionRecognizer;
import io.metacake.core.process.ActionRecognizerName;
import io.metacake.core.process.state.GameState;
import io.metacake.core.process.state.UserState;
import io.metacake.enginetwo.output.DrawingDevice;
import io.metacake.enginetwo.window.GraphicsWindow;

import java.util.List;

public class Main {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String... args) {
        BootstrapBuilder builder = new BootstrapBuilder();
        builder.withWindow(new GraphicsWindow(WIDTH, HEIGHT));
        builder.withInitialState(new ExampleState());
        builder.withOutputDevices(new DrawingDevice());
        builder.createAndLaunch();
    }
}

class ExampleState extends UserState {
    @Override
    public GameState tick(long delta, CustomizableMap<ActionRecognizerName, ActionRecognizer> recognizers) {
        return this;
    }

    @Override
    public RenderingInstructionBundle renderingInstructions() {
        return RenderingInstructionBundle.EMPTY_BUNDLE;
    }
}