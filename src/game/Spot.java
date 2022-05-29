package game;

public class Spot {

    private int x;
    private int y;

    private Chess chess;
    private Piece piece = null;

    public Spot(Chess chess, int x, int y) {
        this.chess = chess;
        chess.spots[x][y] = this;
        this.x = x;
        this.y = y;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece != null) piece.setSpot(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMiddleCordX() {
        return x * 100;
    }

    public int getMiddleCordY() {
        return y * 100;
    }

    public Piece getPiece() {
        return piece;
    }

    public String debug() {
        return x + " " + y;
    }
}
