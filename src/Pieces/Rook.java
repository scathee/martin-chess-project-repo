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
public class Rook extends Piece{
    boolean black;
    public Rook(boolean black, int x, int y){
        super(black, x, y);
    }
    public Rook(boolean black, Location l){
        super(black, l);
    }
    @Override
    public int getValue() {
        return (Maths.RookValue);
    }
    
}
