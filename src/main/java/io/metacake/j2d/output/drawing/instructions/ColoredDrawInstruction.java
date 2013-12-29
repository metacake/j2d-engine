package io.metacake.j2d.output.drawing.instructions;

import io.metacake.j2d.output.drawing.DrawInstruction;

import java.awt.*;

/**
 * The {@code ColoredDrawInstruction} represents {@link io.metacake.j2d.output.drawing.DrawInstruction}s that have a color.
 */
public abstract class ColoredDrawInstruction extends DrawInstruction {
    private Color color;

    protected ColoredDrawInstruction(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    protected Color getColor() {
        return color;
    }

    /**
     * Sets the color for the Instruction.
     * @param context The {@link java.awt.Graphics2D} to draw with.
     */
    @Override
    public void render(Graphics2D context) {
        context.setColor(color);
    }
}