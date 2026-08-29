package main.model;

public class Rook extends Piece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public boolean isValidMove(
            int sr,
            int sc,
            int er,
            int ec,
            Piece[][] board) {
        if (sr == er && sc == ec) {
            return false;
        }

        // Must move horizontally or vertically
        if (sr != er && sc != ec) {
            return false;
        }

        int rowStep = Integer.compare(er, sr);
        int colStep = Integer.compare(ec, sc);

        int row = sr + rowStep;
        int col = sc + colStep;

        // Check squares between start and destination
        while (row != er || col != ec) {

            if (board[row][col] != null) {
                return false;
            }

            row += rowStep;
            col += colStep;
        }

        return true;
    }
}
