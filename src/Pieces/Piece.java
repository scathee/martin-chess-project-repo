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
public interface Piece {
    public boolean isBlack();
    public Location getLocation();
    public void setLocation(int x, int y);
    public int getValue();
}
