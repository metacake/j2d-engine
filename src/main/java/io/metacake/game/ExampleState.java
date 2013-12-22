package io.metacake.game;

import io.metacake.core.common.CustomizableMap;
import io.metacake.core.output.RenderingInstructionBundle;
import io.metacake.core.process.ActionRecognizer;
import io.metacake.core.process.ActionRecognizerName;
import io.metacake.core.process.state.GameState;
import io.metacake.core.process.state.UserState;

class ExampleState extends UserState {
    @Override
    public GameState tick(long delta, CustomizableMap<ActionRecognizerName, ActionRecognizer> recognizers) {
        if(recognizers.containsKey(GameConfig.PRESS_W) && recognizers.get(GameConfig.PRESS_W).wasTriggered()) {
            System.out.println("Pressed W");
        }
        return this;
    }

    @Override
    public RenderingInstructionBundle renderingInstructions() {
        return RenderingInstructionBundle.EMPTY_BUNDLE;
    }
}