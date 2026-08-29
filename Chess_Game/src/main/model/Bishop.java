package main.model;

public class Bishop extends Piece{
    public Bishop(String color){
        super(color);
    }
    @Override
    public boolean isValidMove(int sr, int sc, int er, int ec, Piece[][] board) {
        if (sr == er && sc == ec) {
            return false;
        }

        int rowDiff = Math.abs(er - sr);
        int colDiff = Math.abs(ec - sc);
        if(rowDiff!=colDiff) return false;

        int rowStep = Integer.compare(er, sr);
        int colStep = Integer.compare(ec, sc);

        int row = sr + rowStep;
        int col = sc + colStep;

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
