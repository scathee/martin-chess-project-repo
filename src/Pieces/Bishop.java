/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieces;

import Board.Location;

/**
 * @author ajmarucci14
 * @author hzwerlla14
 */
public class Bishop implements Piece{
    boolean black;
    Location l;
    int v;
    
    public Bishop(boolean gangnam, Location style, int oppa){
        black=gangnam;
        l=style;
        v=oppa;
    }
    public boolean isBlack() {
        return black;
    }

    public Location getLocation() {
        return l;
    }

    public void setLocation(Location style) {
        l=style;
    }

    public int getValue() {
        return v;
    }
    
}
