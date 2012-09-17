/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import ChessGame.*;
import Pieces.*;
import java.util.ArrayList;

/**
 *
 * @author hzwerlla14
 */
public class chooseBestMove {
    public static Move getBestMove(Mat m){
        ArrayList<Piece> listOfPieces=new ArrayList<>();
        Piece[][]a=m.getBoard();
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++)
                if(a[x][y]!=null)
                    if(a[x][y].isBlack()==true)
                        listOfPieces.add(a[x][y]);
        //for finding if the piece can be captured
        ArrayList<Location> allWhiteMoves=m.getAllPossibleWhiteMoves();
        ArrayList<WeightedMove>allWeightedMoves=new ArrayList<WeightedMove>();
        //now find weight for everything
        
        //now find best move out of all
        WeightedMove greatest=allWeightedMoves.get(0);
        for(WeightedMove z:allWeightedMoves)
            if(z.getWeight()>greatest.getWeight())
                greatest=z;
        return new Move('B',Mat.getPieceLetter(greatest.getPiece()),greatest.getPiece().getLocation(),greatest.getLocation());
    }
}
