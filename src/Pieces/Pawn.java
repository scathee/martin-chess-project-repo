/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import Board.Location;

/**
 *
 * @author hzwerlla14
 */
public class Pawn implements Piece{
    boolean black;
    boolean hasMoved;//for enponsont and stuff
    boolean firstMoveDouble;//for enponsont
    @Override
    public boolean isBlack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Location getLocation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setLocation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
