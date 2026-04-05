package main.model;

public class Bishop extends Piece{
    public Bishop(String color){
        super(color);
    }
    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        return true;
    }
}
