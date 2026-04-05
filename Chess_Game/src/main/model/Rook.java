package main.model;

public class Rook extends Piece{
    public Rook(String color){
        super(color);
    }
    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        return true;
    }
}
