package io.metacake.j2d.output.drawing.instructions;

import java.awt.*;

/**
 * Draws a rectangle centered on (x, y) with the given width, height, and color.
 */
public class DrawRectangleInstruction extends ColoredDrawInstruction {

    private int width, height;

    public DrawRectangleInstruction(int x, int y, int width, int height, Color color) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics2D context) {
        super.render(context);
        context.fillRect(x - (width / 2), y - (height / 2), width, height);
    }
}