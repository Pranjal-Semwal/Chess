package main.model;

public class Queen extends Piece{
    public Queen(String color){
        super(color);
    }
    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        return true;
    }
}
