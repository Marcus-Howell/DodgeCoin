package businessdirt.dodgecoin.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.nio.IntBuffer;

public class Window {

    private static Window instance;
    private static JFrame jf;
    private final int width, height;
    private static Draw draw;

    private Window() {
        this.width = 720;
        this.height = 1080;
    }

    public static void start() {
        jf = new JFrame();
        jf.setSize(Window.get().width, Window.get().height);
        jf.setResizable(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setMinimumSize(new Dimension(Window.get().width, Window.get().height));
        jf.setResizable(false);
        jf.setTitle("DodgeCoin");

        jf.add(KeyBinding.getKeyListener());
        registerKeyBindings();

        Window.getDraw().setVisible(true);
        Window.getDraw().setLocation(0, 34);
        Window.getDraw().setSize(Window.instance.width, Window.instance.height - 34);
        jf.add(Window.getDraw());

        jf.setVisible(true);
    }

    private static void registerKeyBindings() {

        new KeyBinding(KeyEvent.VK_A, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Image player = Window.getDraw().getPlayer();
                if (player.getX() > 0) {
                    int newX = player.getX() - 25;
                    player.setX(Math.max(newX, 0));
                }
            }
        });

        new KeyBinding(KeyEvent.VK_D, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Image player = Window.getDraw().getPlayer();
                if (player.getX() < Window.get().getWidth() - player.getWidth()) {
                    System.out.println("test");
                    int newX = player.getX() - 25;
                    player.setX(player.getX() + 25);
                }
            }
        });
    }

    public static Window get() {
        if (Window.instance == null) Window.instance = new Window();
        return Window.instance;
    }

    public static Draw getDraw() {
        if (Window.draw == null) Window.draw = new Draw();
        return Window.draw;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

