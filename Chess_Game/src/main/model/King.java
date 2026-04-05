package main.model;

public class King extends Piece{
    public King(String color){
        super(color);
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        return true;
    }
}
