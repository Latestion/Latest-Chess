package game.pieces.enums;

import game.Piece;
import game.pieces.*;

public enum PieceType {

    BISHOP(new Bishop()),
    HORSE(new Horse()),
    KING(new King()),
    QUEEN(new Queen()),
    ROOK(new Rook()),
    SOLDIER(new Soldier());

    private PieceAbstract piece;

    PieceType(PieceAbstract piece) {
        this.piece = piece;
    }

    public PieceAbstract getPiece() {
        return piece;
    }

}
