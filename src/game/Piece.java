package game;

import game.pieces.enums.PieceColor;
import game.pieces.enums.PieceType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Piece {

    private final PieceType type;
    private final PieceColor color;
    private final Chess chess;

    private Spot spot;

    private JLabel label;
    private final ImageIcon icon;

    public Piece(PieceType type, PieceColor color, Chess chess) {
        this.type = type;
        this.color = color;
        this.chess = chess;
        icon = new ImageIcon("images/" + getColor().toString().toLowerCase() + "/" + type.toString().toLowerCase() + ".png");
        ClickListener click = new ClickListener();
        chess.getFrame().addMouseListener(click);
    }

    public PieceType getType() {
        return type;
    }

    public PieceColor getColor() {
        return color;
    }

    public void setSpot(Spot s) {
        if (spot != null) {
            spot.setPiece(null);
        }
        spot = s;


        Container c = chess.getFrame().getContentPane(); //Gets the content layer

        if (label == null) label = new JLabel();
        label.setIcon(icon);
        Dimension size = label.getPreferredSize();
        int x = s.getMiddleCordX();
        int y = s.getMiddleCordY();
        label.setBounds(x, y, size.width, size.height);
        c.add(label);
    }

    public Spot getSpot() {
        return spot;
    }




    /*
        CHECK MOVEMENT
     */

    private boolean us;
    List<Spot> realMoves = new ArrayList<>();

    private class ClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            Point currentPt = e.getPoint();
            int x = (int) currentPt.getX() / 100;
            int y = (int) currentPt.getY() / 100;
            if (x == 8) x--;
            if (y == 8) y--;
            Spot checkSpot = chess.spots[x][y];
            if (checkSpot.getPiece() == null) return;
            if (checkSpot.getPiece().getColor() == PieceColor.BLACK &&  chess.whiteTurn) return;
            us = checkSpot.getPiece() == spot.getPiece();
            if (us) {
                realMoves = type.getPiece().getMoveableSpots(checkSpot.getPiece(), chess.spots);
            }
        }

        public void mouseReleased(MouseEvent e) {
            if (!us) return;
            int x = e.getX() / 100; if (x == 8) x--;
            int y = e.getY() / 100; if (y == 8) y--;
            Spot newSpot = chess.spots[x][y];
            if (newSpot == spot) return;
            if (newSpot.getPiece() != null) return;
            Piece piece = spot.getPiece();
            if (piece == null) return;
            boolean legalMove = realMoves.contains(newSpot);
            if (!legalMove) return;
            newSpot.setPiece(piece);
            us = false;
            if (getColor() == PieceColor.BLACK) chess.whiteTurn = true;
            else chess.whiteTurn = false;
        }

    }
}
