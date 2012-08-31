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
        for(int i=0;i<8;i++){
            System.out.print((i+1)+"  ");
            for(int y=0;y<8;y++){
                if(board[i][y]!=null){
                    String b=(board[i][y].isBlack()) ? "B":"W";//tetrinary operator if you don't recognize it
                    System.out.print(b+board[i][y]+" ");
                }
                else
                    System.out.print("   ");
            }
            System.out.print("\n");
        }
        System.out.println("   A  B  C  D  E  F  G  H");
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
    * this method is redicuously huge becasue can't find a better way to do it
    * a file would be stupid and prettymuch thats all the other option
    * !adds all 32 pieces
    */
    public void addPieces(){
        //white pieces
        for(int i=0;i<8;i++){
            board[1][i]=new Pawn(false, 2, i);
        }
        board[0][0]=new Rook(false,1,1);
        board[0][7]=new Rook(false,1,8);
        board[0][6]=new Knight(false,1,7);
        board[0][1]=new Knight(false,1,2);
        board[0][5]=new Bishop(false,1,6);
        board[0][2]=new Bishop(false,1,3);
        board[0][4]=new King(false,1,5);
        board[0][3]=new Queen(false,1,4);
        //black pieces
        for(int i=0;i<8;i++){
            board[6][i]=new Pawn(true, 7, i);
        }
        board[7][0]=new Rook(false,8,1);
        board[7][7]=new Rook(false,8,8);
        board[7][6]=new Knight(false,8,7);
        board[7][1]=new Knight(false,8,2);
        board[7][5]=new Bishop(false,8,6);
        board[7][2]=new Bishop(false,8,3);
        board[7][4]=new King(false,8,5);
        board[7][3]=new Queen(false,8,4);
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
    public char rowNumberToChar(int i){
        char c;
        switch(i){
            case 0:
                c='A';
                break;
            case 1:
                c='A';
                break;
            case 2:
                c='A';
                break;
            case 3:
                c='A';
                break;
            case 4:
                c='A';
                break;
            case 5:
                c='A';
                break;
            case 6:
                c='A';
                break;
            case 7:
                c='A';
                break;
            default:
                c='Z';
                break;
        }
        return c;
    }
    //for input
    public int rowCharToNumber(char c){
        int i;
        switch(c){
            case 'A':
                i=0;
                break;
            case 'B':
                i=1;
                break;
            case 'C':
                i=2;
                break;
            case 'D':
                i=3;
                break;
            case 'E':
                i=4;
                break;
            case 'F':
                i=5;
                break;
            case 'G':
                i=6;
                break;
            case 'H':
                i=7;
                break;
            default:
                i=-1;
        }
        return i;
    }
}
