package io.metacake.j2d.output.drawing.instructions;

import java.awt.*;

/**
 * Draw a circle centered on (x,y) with a the given radius and color. The circle is filled with the given color.
 */
public class DrawCircleInstruction extends ColoredDrawInstruction {

    public DrawCircleInstruction(int x, int y, int radius, Color color) {
        super(x, y, radius, radius, color);
    }

    protected int getRadius() {
        return getWidth();
    }

    @Override
    public void render(Graphics2D context) {
        super.render(context);
        int diameter = 2 * getRadius();
        context.fillOval(x - getRadius(), y - getRadius(), diameter, diameter);
    }
}