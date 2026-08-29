package main.model;

public class Knight extends Piece{
    public Knight(String color){
        super(color);
    }
    @Override
    public boolean isValidMove(int sr, int sc, int er, int ec, Piece[][] board) {

        int rowDiff = Math.abs(er - sr);
        int colDiff = Math.abs(ec - sc);

        return (rowDiff == 2 && colDiff == 1)
                || (rowDiff == 1 && colDiff == 2);
    }
}
