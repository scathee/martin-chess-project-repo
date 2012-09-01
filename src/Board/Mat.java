/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;
import Pieces.*;//need to use all of them

import java.util.ArrayList;
/**
 * 
 * @author hzwerlla14
 * this class just holds the board which is a simple 2d array
 * and has some utilities for interacting with pieces on the board
 * because those don't really fit in the piece anything
 */
public class Mat {
    Piece board[][];
    public Mat(){
        board=new Piece[8][8];
        addPieces();//made into its own function for constructor readability
    }
    /*
     * prints
     */
    public void printOutBoard(){
        for(int y=0;y<8;y++){
            System.out.print((y+1)+"  ");
            for(int x=0;x<8;x++){
                if(board[x][y]!=null){
                    String b=(board[x][y].isBlack()) ? "B":"W";//tetrinary operator if you don't recognize it
                    System.out.print(b+board[x][y]+" ");
                }
                else
                    System.out.print("   ");
            }
            System.out.print("\n");
        }
        System.out.println("   A  B  C  D  E  F  G  H");
    }
    //moves pieces returns false if you can't do that
    public boolean movePiece(Location oldLoc, Location newLoc){
        board[newLoc.getX()-1][newLoc.getY()-1]=board[oldLoc.getX()-1][oldLoc.getY()-1];
        board[oldLoc.getX()-1][oldLoc.getY()-1]=null;
        return true;
    }
    public boolean isOccupied(Location l){
        if(board[l.getX()-1][l.getY()-1]!=null){
            return true;
        }
        return false;
    }
    public ArrayList<Location> getValidMoves(Piece a){
        ArrayList<Location> list=new ArrayList<Location>();
        if(a instanceof Bishop){
            
        }
        if(a instanceof Pawn){
            
        }
        if(a instanceof Knight){
            
        }
        if(a instanceof Rook){
            
        }
        if(a instanceof Queen){
            
        }
        if(a instanceof King){
            
        }
        return list;
    }
    /*
    * sadly this is the best way to do it
    */
    public void addPieces(){
        //white pieces
        for(int i=0;i<8;i++){
            board[i][1]=new Pawn(false, 2, i);
        }
        board[0][0]=new Rook(false,1,1);
        board[7][0]=new Rook(false,1,8);
        board[6][0]=new Knight(false,1,7);
        board[1][0]=new Knight(false,1,2);
        board[5][0]=new Bishop(false,1,6);
        board[2][0]=new Bishop(false,1,3);
        board[4][0]=new King(false,1,5);
        board[3][0]=new Queen(false,1,4);
        //black pieces
        for(int i=0;i<8;i++){
            board[i][6]=new Pawn(true, 7, i);
        }
        board[0][7]=new Rook(true,8,1);
        board[7][7]=new Rook(true,8,8);
        board[6][7]=new Knight(true,8,7);
        board[1][7]=new Knight(true,8,2);
        board[5][7]=new Bishop(true,8,6);
        board[2][7]=new Bishop(true,8,3);
        board[4][7]=new King(true,8,5);
        board[3][7]=new Queen(true,8,4);
    }
    /*
     * for output
     */
    public int convertRowToArrayRow(int i){
        return --i;
    }
    public int convertArrayRowToRow(int i){
        return ++i;
    }
    public static char rowNumberToChar(int i){
        char c=0;
        switch(i){
            case 1:
                c='A';
                break;
            case 2:
                c='B';
                break;
            case 3:
                c='C';
                break;
            case 4:
                c='D';
                break;
            case 5:
                c='E';
                break;
            case 6:
                c='F';
                break;
            case 7:
                c='G';
                break;
            case 8:
                c='H';
                break;
            default:
                c='Z';
                break;
        }
        return c;
    }
    //for input
    public static int rowCharToNumber(char c){
        int i;
        switch(c){
            case 'A':
                i=1;
                break;
            case 'B':
                i=2;
                break;
            case 'C':
                i=3;
                break;
            case 'D':
                i=4;
                break;
            case 'E':
                i=5;
                break;
            case 'F':
                i=6;
                break;
            case 'G':
                i=7;
                break;
            case 'H':
                i=8;
                break;
            default:
                i=-1;
        }
        return i;
    }
    public static int rowNumberCharToNumber(char c){
        int i=0;
        switch(c){
            case '1':
                i=1;
                break;
            case '2':
                i=2;
                break;
            case '3':
                i=3;
                break;
            case '4':
                i=4;
                break;
            case '5':
                i=5;
                break;
            case '6':
                i=6;
                break;
            case '7':
                i=7;
                break;
            case '8':
                i=8;
                break;
            default:
                i=-1;
                break;
        }
        return i;
    }
    public static String getFullPieceNameFromChar(char c){
        switch(c){
            case 'k':
            case 'K':
                return "King";
            case 'Q':
            case 'q':
                return "Queen";
            case 'N':
            case 'n':
                return "Knight";
            case 'B':
            case 'b':
                return "Bishop";
            case 'R':
            case 'r':
                return "Rook";
            case 'p':
            case 'P':
                return "Pawn";
        }
        return null;///this makes netbeans happy because it wouldent accept my default case
    }

}
