/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessGame;

import Board.Location;
import Board.Mat;

/**
 * this class needs no setters!
 * hold move data which is written to a log
 * 
 * @author yasdksdgdsd
 */
public class Move {
    char pieceName, color;
    Location oldLoc,newLoc;
    public Move(char c,char p,Location oldLoc, Location newLoc){
        color=c;
        pieceName=p;
        this.oldLoc=oldLoc;
        this.newLoc=newLoc;
    }
    public Move(Location oldLoc, Location newLoc){
        color='z';
        pieceName='z';
        this.oldLoc=oldLoc;
        this.newLoc=newLoc;
    }
    public String toString(){
        return color+" "+Mat.getFullPieceNameFromChar(pieceName)+" "+oldLoc+" "+newLoc;
    }
    public int getOldX(){
        return oldLoc.getX();
    }
    public int getOldY(){
        return oldLoc.getY();
    }
    public int getNewX(){
        return newLoc.getX();
    }
    public int getNewY(){
        return newLoc.getY();
    }
    public Location getOldLoc(){
        return oldLoc;
    }
    public Location getNewLoc(){
        return newLoc;
    }
    public char getColor(){
        return color;
    }
}
