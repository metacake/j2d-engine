package io.metacake.j2d.output;

import io.metacake.core.common.TimedLoopThread;
import io.metacake.core.common.window.CakeWindow;
import io.metacake.core.output.OutputDeviceName;
import io.metacake.core.output.RenderingInstruction;
import io.metacake.core.output.system.OutputDevice;
import io.metacake.j2d.window.GraphicsWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Collection;

/**
 * @author florence
 * @author rpless
 */
public class DrawingDevice implements OutputDevice {
    private static final int NUM_BUFFERS = 2;

    public static final OutputDeviceName NAME = new OutputDeviceName();
    private GraphicsWindow window;
    private SyncState sync = new SyncState();
    private BufferStrategy bufferStrategy;
    private JFrame frame;
    private TimedLoopThread drawingThread;

    @Override
    public OutputDeviceName name() {
        return NAME;
    }

    @Override
    public void render(Collection<RenderingInstruction> r) {
        sync.setState(r);
    }

    @Override
    public void startOutputLoop() {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                draw(sync.getState());
            }
        };
        drawingThread = new TimedLoopThread(run);
        drawingThread.start();
    }

    @Override
    public void shutdown() {
        drawingThread.requestStop();
    }

    @Override
    public void bind(CakeWindow w) {
        window = (GraphicsWindow) w;
        frame = window.getRawWindow();
        frame.createBufferStrategy(NUM_BUFFERS);
        bufferStrategy = frame.getBufferStrategy();
    }

    private void draw(Collection<RenderingInstruction> instructions) {
        Graphics g = this.bufferStrategy.getDrawGraphics();
        Insets insets = this.frame.getInsets();
        g.translate(insets.right, insets.top);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
        for (RenderingInstruction d : instructions) {
            Graphics graphics = g.create();
            ((DrawInstruction) d).render(graphics);
            graphics.dispose();
        }
        g.dispose();
        this.bufferStrategy.show();
    }
}