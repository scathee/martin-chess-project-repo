/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import Board.Location;
import ChessGame.Maths;
/**
 *
 * @author hzwerlla14
 */
public class King extends Piece{
    boolean hasMoved;//for castling
    public King(boolean black, int x, int y){
        super(black, x, y);
        hasMoved=false;
    }
    public King(boolean black, Location l){
        super(black, l);
    }
    public int getValue() {
        return Maths.KingValue;
    }
    public boolean getHasMoved(){
        return hasMoved;
    }
    public void setHasMoved(boolean m){
        hasMoved=m;
    }
    @Override
    public String toString(){
        return super.toString()+(" K");
    }
}
