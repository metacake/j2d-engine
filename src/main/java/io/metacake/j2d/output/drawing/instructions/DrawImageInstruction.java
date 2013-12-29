package io.metacake.j2d.output.drawing.instructions;

import io.metacake.j2d.output.drawing.DrawInstruction;

import java.awt.*;

public class DrawImageInstruction extends DrawInstruction {

    private Image image;

    public DrawImageInstruction(Image image, int x, int y) {
        super(x, y);
        this.image = image;
    }

    @Override
    public void render(Graphics2D context) {
        context.drawImage(image, x, y, null);
    }
}