package game;

import game.pieces.*;
import game.pieces.enums.PieceColor;
import game.pieces.enums.PieceType;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Chess {

    private JFrame frame;
    public Spot[][] spots = new Spot[8][8];

    public Chess(JFrame frame) {
        this.frame = frame;
        startGame();
    }

    public boolean whiteTurn = true;

    public void startGame() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                new Spot(this, x, y);
            }
        }

        for (int x = 0; x < 8; x++) {
            spots[x][6].setPiece(new Piece(PieceType.SOLDIER, PieceColor.WHITE, this));
            spots[x][1].setPiece(new Piece(PieceType.SOLDIER, PieceColor.BLACK, this));
        }

        // ROOK
        spots[0][0].setPiece(new Piece(PieceType.ROOK, PieceColor.BLACK, this));
        spots[7][0].setPiece(new Piece(PieceType.ROOK, PieceColor.BLACK, this));
        spots[0][7].setPiece(new Piece(PieceType.ROOK, PieceColor.WHITE, this));
        spots[7][7].setPiece(new Piece(PieceType.ROOK, PieceColor.WHITE, this));

        // HORSE
        spots[1][0].setPiece(new Piece(PieceType.HORSE, PieceColor.BLACK, this));
        spots[6][0].setPiece(new Piece(PieceType.HORSE, PieceColor.BLACK, this));
        spots[1][7].setPiece(new Piece(PieceType.HORSE, PieceColor.WHITE, this));
        spots[6][7].setPiece(new Piece(PieceType.HORSE, PieceColor.WHITE, this));

        // BISHOP
        spots[2][0].setPiece(new Piece(PieceType.BISHOP, PieceColor.BLACK, this));
        spots[5][0].setPiece(new Piece(PieceType.BISHOP, PieceColor.BLACK, this));
        spots[2][7].setPiece(new Piece(PieceType.BISHOP, PieceColor.WHITE, this));
        spots[5][7].setPiece(new Piece(PieceType.BISHOP, PieceColor.WHITE, this));

        // KING & QUEEN
        spots[4][0].setPiece(new Piece(PieceType.KING, PieceColor.BLACK, this));
        spots[3][0].setPiece(new Piece(PieceType.QUEEN, PieceColor.BLACK, this));
        spots[4][7].setPiece(new Piece(PieceType.KING, PieceColor.WHITE, this));
        spots[3][7].setPiece(new Piece(PieceType.QUEEN, PieceColor.WHITE, this));

    }

    public JFrame getFrame() {
        return frame;
    }

    public boolean getLegalMoves(Piece piece, Spot newSpot) {
        PieceType type = piece.getType();
        return type.getPiece().getMoveableSpots(piece, spots).contains(newSpot);
    }

}
