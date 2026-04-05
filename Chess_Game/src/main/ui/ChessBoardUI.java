package main.ui;

import main.model.*;

import javax.swing.*;
import java.awt.*;

public class ChessBoardUI {
    private int selectedRow=-1;
    private int selectedCol=-1;
    private JPanel[][] cells=new JPanel[8][8];
    public ChessBoardUI(){
        initializePieces();
        JFrame frame=new JFrame("Chess Game");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel board= new JPanel(new GridLayout(8,8));
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                JPanel cell=new JPanel();
                if((row+col)%2==0){
                    cell.setBackground(Color.WHITE);
                }
                else{
                    cell.setBackground(Color.BLACK);
                }

                cells[row][col]=cell;
                board.add(cell);

                int FinalRow=row;
                int FinalCol=col;
                cell.addMouseListener(new java.awt.event.MouseAdapter(){
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent e) {
                        handleClick(FinalRow,FinalCol);
                    }
                });
            }
        }
        refreshBoard();
        frame.add(board);
        frame.setVisible(true);
    }
    public Piece[][] boardState=new Piece[8][8];
    private void initializePieces(){
        for(int col=0;col<8;col++){
            boardState[1][col]=new Pawn("BLACK");
        }
        for(int col=0;col<8;col++){
            boardState[6][col]=new Pawn("WHITE");
        }

        //BLACK ROOK
        boardState[0][0]=new Rook("BLACK");
        boardState[0][7]=new Rook("BLACK");
        //WHITE ROOK
        boardState[7][0]=new Rook("WHITE");
        boardState[7][7]=new Rook("WHITE");

        //BLACK Knight
        boardState[0][1]=new Knight("BLACK");
        boardState[0][6]=new Knight("BLACK");
        //WHITE Knight
        boardState[7][1]=new Knight("WHITE");
        boardState[7][6]=new Knight("WHITE");

        //BLACK Bishop
        boardState[0][2]=new Bishop("BLACK");
        boardState[0][5]=new Bishop("BLACK");
        //WHITE Bishop
        boardState[7][2]=new Bishop("WHITE");
        boardState[7][5]=new Bishop("WHITE");

        //BLACK Queen
        boardState[0][3]=new Queen("BLACK");
        //WHITE Queen
        boardState[7][3]=new Queen("WHITE");

        //BLACK King
        boardState[0][4]=new King("BLACK");
        //WHITE King
        boardState[7][4]=new King("WHITE");
    }

    private void refreshBoard(){
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                cells[row][col].removeAll();
                if(boardState[row][col]!=null){
                    String text="";
                    Piece piece=boardState[row][col];
                    if(piece instanceof Pawn){
                        text="P";
                    } else if (piece instanceof Rook) {
                        text="R";
                    } else if (piece instanceof Knight) {
                        text="N";
                    } else if (piece instanceof Bishop) {
                        text="B";
                    } else if (piece instanceof King) {
                        text="K";
                    } else if (piece instanceof Queen) {
                        text="Q";
                    }
                    text=piece.getColor().equals("WHITE")?("W"+text):("B"+text);
                    JLabel label=new JLabel(text,SwingConstants.CENTER);
                    cells[row][col].setLayout(new BorderLayout());
                    cells[row][col].add(label,BorderLayout.CENTER);
                }
                cells[row][col].revalidate();
                cells[row][col].repaint();
            }
        }
    }

    private void handleClick(int row, int col){
        if(selectedRow==-1){
            if(boardState[row][col]!=null){
                selectedRow=row;
                selectedCol=col;
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.RED,3));
            }
        }
        else{
            Piece piece=boardState[selectedRow][selectedCol];

            if(piece!=null && piece.isValidMove(selectedRow,selectedCol,row,col)) {
                movePiece(selectedRow, selectedCol, row, col);
            }
            cells[selectedRow][selectedCol].setBorder(null);
            selectedRow=-1;
            selectedCol=-1;
            refreshBoard();
        }
    }

    private void movePiece(int sr,int sc,int er,int ec){
        boardState[er][ec]=boardState[sr][sc];
        boardState[sr][sc]=null;
    }

}
