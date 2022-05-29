package game.pieces;

import game.Piece;
import game.Spot;
import game.pieces.enums.PieceType;

import java.util.List;

public class Queen extends PieceAbstract {

    @Override
    public List<Spot> getMoveableSpots(Piece piece, Spot[][] spots) {
        List<Spot> send = PieceType.ROOK.getPiece().getMoveableSpots(piece, spots);
        send.addAll(PieceType.BISHOP.getPiece().getMoveableSpots(piece, spots));
        return send;
    }
}
