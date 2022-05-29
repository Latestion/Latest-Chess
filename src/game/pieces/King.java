package game.pieces;

import game.Piece;
import game.Spot;

import java.util.ArrayList;
import java.util.List;

public class King extends PieceAbstract {

    public List<Spot> getMoveableSpots(Piece piece, Spot[][] spots) {
        List<Spot> sendSpots = new ArrayList<>();

        int x = piece.getSpot().getX();
        int y = piece.getSpot().getY();

        for (int i = -1; i <= 1; i++) {
            for (int i2 = -1; i2 <= 1; i2++) {
                int newX = x + i;
                int newY = y + i2;
                if (checkOutOfBound(newX)) continue;
                if (checkOutOfBound(newY)) continue;
                Spot s = spots[newX][newY];
                if (s.equals(piece.getSpot())) continue;
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
