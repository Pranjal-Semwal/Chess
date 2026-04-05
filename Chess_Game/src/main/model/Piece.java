package main.model;

public abstract class Piece {
    protected String color;
    public Piece(String color){
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean isValidMove(int startRow,int startCol,int endRow,int endCol);
}
