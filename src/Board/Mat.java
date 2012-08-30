/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;
import Pieces.Piece;

import java.util.ArrayList;
/**
 * 
 * @author hzwerlla14
 * this class just holds the board which is a simple 2d array
 */
public class Mat {
    Piece board[][];
    public Mat(){
        board=new Piece[8][8];
    }
    /*
     * prints
     */
    public void printOutBoard(){
        for(int i=0;i<8;i++){
            for(int y=0;y<6;y++){
                
            }
        }
    }
    
    public ArrayList<Location> getValidMoves(Piece a){
        ArrayList<Location> list=new ArrayList<Location>();
        
        return list;
    }
}
