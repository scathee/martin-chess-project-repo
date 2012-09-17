/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessGame;

import Board.Location;
import Pieces.*;

/**
 *
 * @author hzwerlla14
 */
public class WeightedMove {
    Piece piece;
    double weight;
    Location location;
    public WeightedMove(Piece p,Location l,double w){
        piece=p;
        weight=w;
        location=l;
    }
    public void setWeight(double a){
        weight=a;
    }
    public void setPiece(Piece p){
        piece=p;
    }
    public void setLocation(Location l){
        location=l;
    }
    public Location getLocation(){
        return location;
    }
    public double getWeight(){
        return weight;
    }
    public Piece getPiece(){
        return piece;
    }
}
