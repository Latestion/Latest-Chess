package game.pieces;

import game.Piece;
import game.Spot;
import game.pieces.enums.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class Horse extends PieceAbstract {

    public List<Spot> getMoveableSpots(Piece piece, Spot[][] spots) {
        List<Spot> sendSpots = new ArrayList<>();

        int x = piece.getSpot().getX();
        int y = piece.getSpot().getY();

        for (int i = -2; i < 3; i++) {
            for (int i1 = -2; i1 < 3; i1++) {
                if (i == i1) continue;
                if (i + i1 == 0) continue;
                if (i == 0 || i1 == 0) continue;
                int newX = x + i;
                int newY = y + i1;
                if (checkOutOfBound(newX)) continue;
                if (checkOutOfBound(newY)) continue;
                Spot s = spots[newX][newY];
                if (s == piece.getSpot()) continue;
                if (s.getPiece() != null)
                    if (s.getPiece().getColor() == piece.getColor())
                        continue;
                sendSpots.add(s);
            }
        }

        return sendSpots;
    }

    private static boolean checkOutOfBound(int i) {
        return i > 7 || i < 0;
    }

}
