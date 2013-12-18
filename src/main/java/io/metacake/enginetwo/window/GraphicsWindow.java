package io.metacake.enginetwo.window;

import io.metacake.core.common.window.CakeWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsWindow extends CakeWindow<JFrame> {
    private JFrame frame = new JFrame();

    public GraphicsWindow(int width, int height) {
        frame.setVisible(true);
        Insets insets = frame.getInsets();
        frame.setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });
    }

    @Override
    public void dispose() {
        frame.dispose();
    }

    @Override
    public int getX() {
        return frame.getX();
    }

    @Override
    public int getY() {
        return frame.getY();
    }

    @Override
    public int getWidth() {
        return frame.getWidth();
    }

    @Override
    public int getHeight() {
        return frame.getHeight();
    }

    @Override
    public JFrame getRawWindow() {
        return frame;
    }
}