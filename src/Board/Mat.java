/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;
import Pieces.Pawn;
import Pieces.Piece;

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
                if(board[i][y]!=null)
                    System.out.print(board[i][y]+" ");
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
        System.out.println("   A B C D E F G H");
    }
    
    public ArrayList<Location> getValidMoves(Piece a){
        ArrayList<Location> list=new ArrayList<Location>();
        
        return list;
    }
    /*
    * this method is redicuously huge becasue can't find a better way to do it
    * a file would be stupid and prettymuch thats all the other option
    * !adds all 32 pieces
    */
    public void addPieces(){
        //can add pawns with loops
        //black pawns
        for(int i=0;i<8;i++){
            board[6][i]=new Pawn(true, 7, i);
        }
        //white pawns
        for(int i=0;i<8;i++){
            board[1][i]=new Pawn(false, 2, i);
        }
    }
    /*
     * for output
     */
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
