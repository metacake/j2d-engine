package io.metacake.j2d.output.drawing.instructions;

import java.awt.*;

public class DrawTextInstruction extends ColoredDrawInstruction {

    private String text;

    protected DrawTextInstruction(String text, int x, int y, Color color) {
        super(x, y, color);
        this.text = text;
    }

    @Override
    public void render(Graphics2D context) {
        super.render(context);
        context.drawString(text, getX(), getY());
    }
}