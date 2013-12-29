package io.metacake.j2d.window;

import io.metacake.core.common.window.CakeWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * The {@code GraphicsWindow} is a {@link io.metacake.core.common.window.CakeWindow} that uses a {@link javax.swing.JFrame}
 * as its raw window.
 * <p>
 *      There are several notable points about hte {@code GraphicsWindow}'s implementation.
 *      Firstly, it uses a {@link java.awt.event.WindowAdapter} to call {@link io.metacake.j2d.window.GraphicsWindow#close()}.
 *      It is called during the {@link java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)} event callback.
 *      Second, it's size is not actually the width and height that is specified in the constructor. The {@link javax.swing.JFrame}'s
 *      actual size includes the size of the insets on all sides, so that drawing area is the size of the given width and height.
 */
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