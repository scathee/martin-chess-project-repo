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
public class Queen extends Piece{
    public Queen(boolean black, int x, int y){
        super(black, x, y);
    }
    public Queen(boolean black, Location l){
        super(black, l);
    }
    @Override
    public int getValue() {
        return (Maths.QueenValue);
    }
    @Override
    public String toString(){
        return("Q");
    }
}
