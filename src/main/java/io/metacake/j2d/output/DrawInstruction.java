package io.metacake.j2d.output;

import io.metacake.core.output.RenderingInstruction;

import java.awt.*;

/**
 * @author florence
 * @author rpless
 */
public abstract class DrawInstruction implements RenderingInstruction<Graphics> {
    protected int x, y, width, height;

    public DrawInstruction(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}