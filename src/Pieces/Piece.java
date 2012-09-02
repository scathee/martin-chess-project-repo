/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import Board.Location;
/**
 * @author hzwerlla14
 * interface for pieces
 */
public abstract class Piece {
    boolean black;
    Location l;
    public Piece(boolean b,int x,int y){
        black=b;
        setLocation(x,y);
    }
    public Piece(boolean b,Location l){
        this.l=l;
        black=b;
    }
    public boolean isBlack(){
        return black;
    }
    public Location getLocation(){
        return l;
    }
    public final void setLocation(int x, int y){
        l=new Location(x,y);
    }
    public final boolean isSameColor(Piece a){
        if(this.isBlack()==a.isBlack())
            return true;
        return false;
    }
    public abstract int getValue();
}
