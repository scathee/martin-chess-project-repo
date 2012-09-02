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
public class Pawn extends Piece{
    boolean hasMoved;//for enponsont and stuff
    boolean firstMoveDouble;//for enponsont literally it just is true if the first turn a pawn moved was a double and it hasnt moved sience
    public Pawn(boolean black, int x, int y){
        super(black, x, y);
    }
    public Pawn(boolean black, Location l){
        super(black, l);
    }
    @Override
    public int getValue() {
        return (Maths.PawnValue);
    }
    public boolean getHasMoved(){
        return hasMoved;
    }
    public void setHasMoved(boolean b){
        hasMoved=b;
    }
    public boolean getFirstMoveDouble(){
        return firstMoveDouble;
    }
    public void setFirstMoveDouble(boolean b){
        firstMoveDouble=b;
    }
    @Override
    public String toString(){
        return super.toString()+(" P");
    }
}
