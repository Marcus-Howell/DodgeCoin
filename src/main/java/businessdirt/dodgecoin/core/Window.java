package businessdirt.dodgecoin.core;

import javax.swing.*;
import java.awt.*;
import java.nio.IntBuffer;

public class Window {

    private static Window instance;
    private static JFrame jf;
    private int width, height;

    private Window() {
        this.width = 1280;
        this.height = 720;
    }

    public static void start() {
        jf = new JFrame();
        jf.setSize(Window.get().width, Window.get().height);
        jf.setResizable(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setMinimumSize(new Dimension(Window.get().width, Window.get().height));
        jf.setTitle("DodgeCoin");

        /*Draw draw = new Draw();
        jf.setBounds(0, 0, width, height);
        draw.setVisible(true);
        jf.add(draw);*/

        jf.setVisible(true);
    }

    public static Window get() {
        if (Window.instance == null) Window.instance = new Window();
        return Window.instance;
    }
}

