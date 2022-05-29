package game.pieces;

import game.Piece;
import game.Spot;

import java.util.List;

public abstract class PieceAbstract {

    private boolean checkOutOfBound(int i) {
        return i > 7 || i < 0;
    }
    public abstract List<Spot> getMoveableSpots(Piece piece, Spot[][] spots);

}
