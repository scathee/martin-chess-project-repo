/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Pieces.Piece;
import java.util.ArrayList;

/**
 * this class just has a bunch of static methods for finding if a move is valid 
 * or not
 * @author instantcake
 */
public class ValidMoves {
    //so the final commands look like ValidMoves.ForPawn()...ect...it looks nice
    //easiest one
    /**
     *
     * @param p the piece you're testing
     * @param m the board you are using
     * @return
     */
    public static ArrayList<Location> ForRook(Piece piece, Mat mat){
        ArrayList<Location> moves=new ArrayList<Location>();
        int x=piece.getLocation().getX();
        int y=piece.getLocation().getY();
        Piece[][]board=mat.getBoard();
        //need four of them, check to left then right and glad i put this in its own class becasue so long
        //check to the right
        //makes sure not on rightmost so it won't throw an indexoutofbounds
        if(x!=8){
            for(int z=x;z<9;z++){
                if(board[z][y-1]==null)
                    moves.add(new Location(z,y));
                else if(!piece.isSameColor(board[z-1][y-1])){
                    moves.add(new Location(z,y));
                    break;
                }
                else{
                    break;
                }
            }
        }
        //check to the left
        //checks if its on 1 so its doenst go out of bounds
        //and wont have to check it
        if(x!=1){
            for(int z=x;z>0;z--){
                if(board[z-2][y-1]==null)
                    moves.add(new Location(z,y));
                else if(!piece.isSameColor(board[z-1][y-1])){
                    moves.add(new Location(z,y));
                    break;
                }
                else{
                    break;
                }
            }
        }
        //now check up and down
        //up
        if(y!=1){
            for(int z=x;z<9;z++){
                if(board[z][y-1]==null)
                    moves.add(new Location(x,z));
                else if(!piece.isSameColor(board[x-1][z-1])){
                    moves.add(new Location(x,z));
                    break;
                }
                else{
                    break;
                }
            }
        }
        //down
        if(y!=1){
            for(int z=x;z>0;z--){
                if(board[z-2][y-1]==null)
                    moves.add(new Location(x,z));
                else if(!piece.isSameColor(board[x-1][z-1])){
                    moves.add(new Location(x,z));
                    break;
                }
                else{
                    break;
                }
            }
        }
        return moves;
    }
    public static ArrayList<Location> ForKnight(Piece p,Mat mat){
        ArrayList<Location> moves=new ArrayList<Location>();
        int x=p.getLocation().getX();
        int y=p.getLocation().getY();
        return moves;
    }
    public static ArrayList<Location> ForBishop(Piece p,Mat mat){
        ArrayList<Location> moves=new ArrayList<Location>();
        int x=p.getLocation().getX();
        int y=p.getLocation().getY();
        return moves;
    }
    public static ArrayList<Location> ForQueen(Piece p,Mat mat){
        ArrayList<Location> moves=new ArrayList<Location>();
        int x=p.getLocation().getX();
        int y=p.getLocation().getY();
        return moves;
    }
    //king and pawn's have a bunch of exceptions so they are at the bottom
    public static ArrayList<Location> ForKing(Piece p,Mat mat){
        return null;
    }
    public static ArrayList<Location> ForPawn(Piece p,Mat mat){
        return null;
    }
}
