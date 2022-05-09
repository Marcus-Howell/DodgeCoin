package businessdirt.dodgecoin.core;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Draw extends JLabel {

    private List<Image> coins = new ArrayList<>();
    private Image player;
    private Image background;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.fillRect(0, 0, 50, 50);

        // draw background
        if (background != null) g2d.drawImage(background.getImage(), background.getX(), background.getY(), background.getWidth(), background.getHeight(), this);

        // draw images
        for (Image coin : coins) {
            g2d.drawImage(coin.getImage(), coin.getX(), coin.getY(), coin.getWidth(), coin.getHeight(), this);
        }

        // draw player
        if (player != null) g2d.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);
    }

    public void addCoin(Image coin) {
        this.coins.add(coin);
    }

    public void setPlayer(Image player) {
        this.player = player;
    }

    public Image getPlayer() {
        return this.player;
    }

    public void setBackground(Image background) {
        this.background = background;
    }
}
