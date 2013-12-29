package io.metacake.j2d.output.drawing;

import io.metacake.core.output.RenderingInstruction;

import java.awt.*;

/**
 * The {@code DrawInstruction} is the parent of all {@code RenderingInstruction}s in this engine.
 * @author florence
 * @author rpless
 */
public abstract class DrawInstruction implements RenderingInstruction<Graphics2D> {
    protected int x, y;

    public DrawInstruction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}