/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import Board.Location;
import ChessGame.Maths;

/**
 * @author ajmarucci14
 * @author hzwerlla14
 */
public class Knight extends Piece{
    public Knight(boolean black, int x, int y){
        super(black, x, y);
    }
    public Knight(boolean black, Location l){
        super(black, l);
    }
    @Override
    public int getValue() {
        return (Maths.KnightValue);
    }
    @Override
    public String toString(){
        return super.toString()+(" N");
    }
}
