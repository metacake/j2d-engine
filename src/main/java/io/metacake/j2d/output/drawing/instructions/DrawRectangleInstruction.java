package io.metacake.j2d.output.drawing.instructions;

import java.awt.*;

/**
 *
 */
public class DrawRectangleInstruction extends ColoredDrawInstruction {

    public DrawRectangleInstruction(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void render(Graphics2D context) {
        super.render(context);
        context.fillRect(x, y, getWidth(), getHeight());
    }
}