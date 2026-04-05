package main.model;

public class Pawn extends Piece{
    public Pawn(String color){
        super(color);
    }
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol) {
        int direction=color.equals("WHITE")?-1:1;
        if(startCol==endCol && endRow==startRow+direction){
            return true;
        }
        if(startCol==endCol && ((color.equals("WHITE") && startRow==6) || (color.equals("BLACK") && startRow==1))){
            return true;
        }
        if(Math.abs(startCol-endCol)==1 && endRow==startRow+direction){
            return true;
        }
        return false;
    }
}
