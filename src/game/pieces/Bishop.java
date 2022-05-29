package game.pieces;

import game.Piece;
import game.Spot;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends PieceAbstract {

    public List<Spot> getMoveableSpots(Piece piece, Spot[][] spots) {
        List<Spot> sendSpots = new ArrayList<>();

        int x = piece.getSpot().getX();
        int y = piece.getSpot().getY();

        boolean x1 = true;
        boolean x2 = true;

        for (int i = y; i >= 0; i--) {
            int xMultiplier = Math.abs(y - i);
            int newX1 = x + xMultiplier;
            int newX2 = x - xMultiplier;
            if (checkOutOfBound(i)) continue;
            if (!checkOutOfBound(newX1) && x1) {
                Spot spot = spots[newX1][i];
                if (spot == piece.getSpot()) {
                    continue;
                }
                else if (spot.getPiece() == null)
                    sendSpots.add(spot);
                else if (spot.getPiece().getColor() != piece.getColor()) {
                    sendSpots.add(spot);
                }
                else x1 = false;
            }
            if (!checkOutOfBound(newX2) && x2) {
                Spot spot = spots[newX2][i];
                if (spot == piece.getSpot()) {
                    continue;
                }
                else if (spot.getPiece() == null)
                    sendSpots.add(spot);
                else if (spot.getPiece().getColor() != piece.getColor()) {
                    sendSpots.add(spot);
                }
                else x2 = false;
            }
        }

        x1 = true;
        x2 = true;
        for (int i = y; i < 8; i++) {
            int xMultiplier = Math.abs(y - i);
            int newX1 = x + xMultiplier;
            int newX2 = x - xMultiplier;
            if (checkOutOfBound(i)) continue;
            if (!checkOutOfBound(newX1) && x1) {
                Spot spot = spots[newX1][i];
                if (spot == piece.getSpot()) {
                    continue;
                }
                else if (spot.getPiece() == null)
                    sendSpots.add(spot);
                else if (spot.getPiece().getColor() != piece.getColor()) {
                    sendSpots.add(spot);
                }
                else x1 = false;
            }
            if (!checkOutOfBound(newX2) && x2) {
                Spot spot = spots[newX2][i];
                if (spot == piece.getSpot()) {
                }
                else if (spot.getPiece() == null)
                    sendSpots.add(spot);
                else if (spot.getPiece().getColor() != piece.getColor()) {
                    sendSpots.add(spot);
                }
                else x2 = false;
            }
        }

        return sendSpots;
    }

    private static boolean checkOutOfBound(int i) {
        return i > 7 || i < 0;
    }


}
