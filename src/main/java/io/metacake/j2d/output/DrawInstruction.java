package io.metacake.j2d.output;

import io.metacake.core.output.RenderingInstruction;

import java.awt.*;

/**
 * @author florence
 * @author rpless
 */
public abstract class DrawInstruction implements RenderingInstruction<Graphics> {
    public static final Color DEFAULT_COLOR = Color.BLACK;
    protected int x, y;
    protected Color c;

    public DrawInstruction(int x, int y) {
        this(x, y, DEFAULT_COLOR);
    }

    public DrawInstruction(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public abstract void render(Graphics g);
}