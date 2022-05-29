package game.pieces;

import game.Piece;
import game.Spot;
import game.pieces.enums.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class Soldier extends PieceAbstract {

    public List<Spot> getMoveableSpots(Piece piece, Spot[][] spots) {
        List<Spot> sendSpots = new ArrayList<>();

        int x = piece.getSpot().getX();
        int y = piece.getSpot().getY();

        if (piece.getColor() == PieceColor.WHITE) {
            if (y == 6) sendSpots.add(spots[x][y - 2]);
            sendSpots.add(spots[x][y - 1]);
        }

        else {
            if (y == 1) sendSpots.add(spots[x][y + 2]);
            sendSpots.add(spots[x][y + 1]);
        }

        sendSpots.remove(piece.getSpot());
        return sendSpots;
    }

}
