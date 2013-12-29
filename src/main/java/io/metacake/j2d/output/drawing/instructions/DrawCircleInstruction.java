package io.metacake.j2d.output.drawing.instructions;

import java.awt.*;

/**
 * Draw a circle centered on (x,y) with a the given radius and color. The circle is filled with the given color.
 */
public class DrawCircleInstruction extends ColoredDrawInstruction {

    private int radius;

    public DrawCircleInstruction(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public void render(Graphics2D context) {
        super.render(context);
        int diameter = 2 * radius;
        context.fillOval(x - radius, y - radius, diameter, diameter);
    }
}