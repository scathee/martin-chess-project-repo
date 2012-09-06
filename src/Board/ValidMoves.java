/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Pieces.Pawn;
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
        //need four of them, check to left then right and glad i put this in its own class becasue so long
        //check to the right
        //makes sure not on rightmost so it won't throw an indexoutofbounds
        if(x!=8){
            for(int z=x+1;z<9;z++){
                if(mat.getPiece(z, y)==null)
                    moves.add(new Location(z,y));
                else if(!piece.isSameColor(mat.getPiece(z, y))){
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
            for(int z=x-1;z>0;z--){
                if(mat.getPiece(z, y)==null)
                    moves.add(new Location(z,y));
                else if(!piece.isSameColor(mat.getPiece(z, y))){
                    moves.add(new Location(z,y));
                    break;
                }
                else{
                    break;
                }
            }
        }
        //now check up and down
        //down
        if(y!=1){
            for(int z=y-1;z>0;z--){
                if(mat.getPiece(z, y)==null)
                    moves.add(new Location(x,z));
                else if(!piece.isSameColor(mat.getPiece(z, y))){
                    moves.add(new Location(x,z));
                    break;
                }
                else{
                    break;
                }
            }
        }
        //up
        if(y!=8){
            for(int z=y+1;z<9;z++){
                if(mat.getPiece(z, y)==null)
                    moves.add(new Location(x,z));
                else if(!piece.isSameColor(mat.getPiece(z, y))){
                    moves.add(new Location(x,z));
                    break;
                }
                else{
                    break;
                }
            }
        }
        return mat.getAllLocations();
    }
    public static ArrayList<Location> ForBishop(Piece p,Mat mat){
        ArrayList<Location> moves=new ArrayList<Location>();
        int x=p.getLocation().getX();
        int y=p.getLocation().getY();/*
        if(y!=8&&x!=8){
            for(int z=y+1;z<9;z++){
                if(mat.getPiece(z, y)==null)
                    moves.add(new Location(x,z));
                else if(!piece.isSameColor(mat.getPiece(z, y))){
                    moves.add(new Location(x,z));
                    break;
                }
                else{
                    break;
                }
            }
        }*/
        return mat.getAllLocations();
    }
    public static ArrayList<Location> ForQueen(Piece p,Mat mat){
        ArrayList<Location> moves=new ArrayList<Location>();
        int x=p.getLocation().getX();
        int y=p.getLocation().getY();
        return mat.getAllLocations();
    }
     //fixed
    public static ArrayList<Location> ForKnight(Piece p,Mat mat){
        ArrayList<Location> moves=new ArrayList<Location>();
        int x=p.getLocation().getX();
        int y=p.getLocation().getY();
        //basically hard add them then remove the ones that don't work
        moves.add(new Location(x+1,y+2));
        moves.add(new Location(x+1,y-2));
        moves.add(new Location(x-1,y+2));
        moves.add(new Location(x-1,y-2));
        moves.add(new Location(x+2,y+1));
        moves.add(new Location(x+2,y-1));
        moves.add(new Location(x-2,y+1));
        moves.add(new Location(x-2,y-1));
        for(int i=0;i<moves.size();i++){
            if(Location.isValid(moves.get(i))==false){
                moves.remove(i);
                i--;
            }        
        }
        for(int i=0;i<moves.size();i++){
            if(mat.getPiece(moves.get(i))!=null){
                if(mat.getPiece(moves.get(i)).isSameColor(p)){
                    moves.remove(i);
                    i--;
                }
            }
        }
        return moves;
    }
    //king and pawn's have a bunch of exceptions so they are at the bottom
    public static ArrayList<Location> ForKing(Piece p,Mat mat){
        int x=p.getLocation().getX();
        int y=p.getLocation().getY();
        ArrayList<Location>validLocations=new ArrayList<Location>();
        validLocations.add(new Location(x+1,y+1));
        validLocations.add(new Location(x+1,y-1));
        validLocations.add(new Location(x-1,y+1));
        validLocations.add(new Location(x-1,y-1));
        validLocations.add(new Location(x+1,y));
        validLocations.add(new Location(x-1,y));
        validLocations.add(new Location(x,y+1));
        validLocations.add(new Location(x,y-1));
        //remove off board moves
        for(int i=0;i<validLocations.size();i++){
            if(Location.isValid(validLocations.get(i))==false){
                validLocations.remove(i);
                i--;
            }        
        }
        //removes when running over same color
        for(int i=0;i<validLocations.size();i++){
            if(mat.getPiece(validLocations.get(i))!=null){
                if(mat.getPiece(validLocations.get(i)).isBlack()==p.isBlack()){
                    validLocations.remove(i);
                    i--;
                }
            }
        }
        return mat.getAllLocations();
    }
    public static ArrayList<Location> ForPawn(Piece p,Mat mat){/*
        int x=p.getLocation().getX();
        int y=p.getLocation().getY();
        System.out.println(x+" "+y);
        ArrayList<Location>move=new ArrayList<Location>();
        if(p.isBlack()){
            if(mat.getPiece(x, y-1)==null)
                move.add(new Location(x,y-1));
        }
        else{
            if(mat.getPiece(x, y+1)==null)
                move.add(new Location(x,y+1));
        }
        System.out.println(move);
        return move;*/
        return mat.getAllLocations();
    }
}
