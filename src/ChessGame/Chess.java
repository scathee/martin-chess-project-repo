/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessGame;

import Board.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Marucci, Werlla
 */
public class Chess {
    public static void main(String[] args) {
        Mat theBoard=new Mat();
        Scanner omnomnom=new Scanner(System.in);
        int[]parsedData=null;
        //main loop of execution
        //checks if its checkmate or only 2 kings left
        //also checks if its stalemate
        //finally chaecks if king is in check
        //then excepts user input with the syntax "PIECENAME SPACE NEWSPACE" ex:
        //K H1 H5 which wouldent work and they would have to remove
        for(;;){
            parsedData=parseInput(omnomnom.nextLine());
            if(parsedData!=null){
                theBoard.printOutBoard();
            }
            else{
                System.out.println("thatmove goes off the board!");
            }
        }
        //System.out.println("thanks for playing");
    }
    public static int[] parseInput(String s){
        return null;
    }
}
