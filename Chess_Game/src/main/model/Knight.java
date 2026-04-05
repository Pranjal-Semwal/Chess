package main.model;

public class Knight extends Piece{
    public Knight(String color){
        super(color);
    }
    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        return true;
    }
}
