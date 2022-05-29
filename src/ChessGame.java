import game.Chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChessGame extends JFrame {

    public static ChessGame frame;

    public static void main(String[] args) {

        frame = new ChessGame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Latest Chess");

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("images/board.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(799, 799, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        frame.setContentPane(new JLabel(imageIcon));

        new Chess(frame);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
