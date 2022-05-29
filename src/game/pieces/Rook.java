package game.pieces;

import game.Piece;
import game.Spot;

import java.util.ArrayList;
import java.util.List;

public class Rook extends PieceAbstract {

    public List<Spot> getMoveableSpots(Piece piece, Spot[][] spots) {
        List<Spot> sendSpots = new ArrayList<>();

        int x = piece.getSpot().getX();
        int y = piece.getSpot().getY();

        for (int i = x; i >= 0; i--) {
            Spot spot = spots[i][y];
            if (spot == piece.getSpot()) continue;
            if (spot.getPiece() == null)
                sendSpots.add(spot);
            else if (spot.getPiece().getColor() != piece.getColor()) {
                sendSpots.add(spot);
            }
            else break;
        }
        for (int i = x; i < 8; i++) {
            Spot spot = spots[i][y];
            if (spot == piece.getSpot()) continue;
            if (spot.getPiece() == null) {
                sendSpots.add(spot);
            }
            else if (spot.getPiece().getColor() != piece.getColor()) {
                sendSpots.add(spot);
            }
            else break;
        }
        for (int i = y; i >= 0; i--) {
            Spot spot = spots[x][i];
            if (spot == piece.getSpot()) continue;
            if (spot.getPiece() == null)
                sendSpots.add(spot);
            else if (spot.getPiece().getColor() != piece.getColor()) {
                sendSpots.add(spot);
            }
            else break;

        }
        for (int i = y; i < 8; i++) {
            Spot spot = spots[x][i];
            if (spot == piece.getSpot()) continue;
            if (spot.getPiece() == null)
                sendSpots.add(spot);
            else if (spot.getPiece().getColor() != piece.getColor()) {
                sendSpots.add(spot);
            }
            else break;
        }

        return sendSpots;
    }


}
