package main.model;

public class Pawn extends Piece{
    public Pawn(String color){
        super(color);
    }
    @Override
    public boolean isValidMove(int sr, int sc, int er, int ec, Piece[][] board) {

        int direction = color.equals("WHITE") ? -1 : 1;

        // Forward move (1 step)
        if (sc == ec && er == sr + direction && board[er][ec] == null) {
            return true;
        }

        // First move (2 steps)
        if (sc == ec &&
                ((color.equals("WHITE") && sr == 6) || (color.equals("BLACK") && sr == 1)) &&
                er == sr + 2 * direction &&
                board[sr + direction][sc] == null &&
                board[er][ec] == null) {
            return true;
        }

        // Diagonal capture
        if (Math.abs(sc - ec) == 1 && er == sr + direction &&
                board[er][ec] != null &&
                !board[er][ec].getColor().equals(color)) {
            return true;
        }

        return false;
    }
}
