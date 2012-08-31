/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessGame;

import Board.Mat;
/**
 *
 * @author Marucci, Werlla
 */
public class Chess {
    public static void main(String[] args) {
        Mat theBoard=new Mat();
        for(;;){
            theBoard.printOutBoard();
            break;
        }
        System.out.println("thanks for playing");
    }
}
