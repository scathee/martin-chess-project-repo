/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessGame;

import Board.*;
import Pieces.Piece;
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
        Move parsedData=null;
        ArrayList<Move>log=new ArrayList<Move>();
        theBoard.printOutBoard();
        //main loop of execution
        //checks if its checkmate or only 2 kings left
        //also checks if its stalemate
        //finally chaecks if king is in check
        //then excepts user input with the syntax "PIECENAME SPACE NEWSPACE" ex:
        //K H1 H5 which wouldent work and they would have to remove
        for(;;){
            boolean canMoveThere=false;
            while(canMoveThere==false){
                String input=omnomnom.nextLine();
                if(input.equals("log")){
                    for(Move m:log)
                        System.out.println(m);
                    continue;//jump back to top of loop
                }
                if(input.length()!=7){
                    System.out.println("Wrong Syntax1111!");
                    continue;
                }
                parsedData=parseInput(input,theBoard);
                if(parsedData!=null){
                    ArrayList<Location>possibleMoves=theBoard.getValidMoves(theBoard.getPiece(parsedData.getOldLoc()));
                    if(possibleMoves!=null){
                        for(Location loc:possibleMoves){
                            if(loc.equals(parsedData.getNewLoc())){
                                canMoveThere=true;
                                break;
                            }
                        }
                    }
                    if(canMoveThere==true){
                        log.add(parsedData);
                        theBoard.movePiece(parsedData.getOldLoc(),parsedData.getNewLoc());
                    }
                    else{
                        System.out.println("illegal move\n\n");
                    }
                }
                else{
                    System.out.println("that move goes off the board!");
                }
                theBoard.printOutBoard();
            }
            //now begins computer prtion
            //nope
            canMoveThere=false;
            while(canMoveThere==false){
                String input=omnomnom.nextLine();
                if(input.equals("log")){
                    for(Move m:log)
                        System.out.println(m);
                    continue;//jump back to top of loop
                }
                if(input.length()!=7){
                    System.out.println("Wrong Syntax1111!");
                    continue;
                }
                parsedData=parseInput(input,theBoard);
                if(parsedData!=null){
                    ArrayList<Location>possibleMoves=theBoard.getValidMoves(theBoard.getPiece(parsedData.getOldLoc()));
                    if(possibleMoves!=null){
                        for(Location loc:possibleMoves){
                            if(loc.equals(parsedData.getNewLoc())){
                                canMoveThere=true;
                                break;
                            }
                        }
                    }
                    if(canMoveThere==true){
                        log.add(parsedData);
                        theBoard.movePiece(parsedData.getOldLoc(),parsedData.getNewLoc());
                        //debug
                        for(Location l:ValidMoves.ForRook(theBoard.getPiece(1, 1), theBoard)){
                            System.out.println(l);
                        }
                    }
                    else{
                        System.out.println("illegal move\n\n");
                    }
                }
                else{
                    System.out.println("that move goes off the board!");
                }
                theBoard.printOutBoard();
            }
            //out of main loop of execution
            //this thing is horribally done but done in a rush to work will be refined later
            //checks if game is over
            if(Mat.isThereKing(theBoard.getBoard())==false){
                if(Mat.isThereBlackKing(theBoard.getBoard())){
                    System.out.println("Black Wins");
                    break;
                }
                System.out.println("White Wins");
                break;
            }
            theBoard.printOutBoard();
        }
        //System.out.println("thanks for playing");
    }
    public static Move parseInput(String s, Mat b){
        //checks if number is too big, too small, or if theres nothing there
        Location oldLoc=new Location(s.charAt(2),s.charAt(3));
        Location newLoc=new Location(s.charAt(5),s.charAt(6));
        Move guy=new Move('W',s.charAt(0),oldLoc,newLoc);
        System.out.println(guy.getOldX());
        if(guy.getOldX()>8||guy.getOldX()<1||guy.getOldY()<1||guy.getOldY()>8||!b.isOccupied(guy.getOldLoc())){
            return null;
        }
        return guy;
    }
}
