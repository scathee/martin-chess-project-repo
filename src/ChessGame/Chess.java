/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessGame;

import Board.*;
import Pieces.King;
import Pieces.Pawn;
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
        boolean checkmate=false;
        while(checkmate==false){
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
                    ArrayList<Location>allPossibleMoves=theBoard.getAllPossibleBlackMoves();
                    if(possibleMoves!=null){
                        for(Location loc:possibleMoves){
                            if(loc.equals(parsedData.getNewLoc())){
                                canMoveThere=true;
                                break;
                            }
                        }
                    }
                    //check if king is in check
                    if(theBoard.isWhiteKingInCheck())
                    {
                        if(theBoard.isWhiteKingInCheckmate()){
                             checkmate=true;
                             canMoveThere=false;
                        }
                        if(!theBoard.moveDoesntPutInCheck(parsedData)){
                            System.out.println("you must get out of check!");
                            theBoard.printOutBoard();
                            continue;
                        }
                    }     
                    if(canMoveThere==true){
                        //check for pawn double move
                        if(theBoard.getPiece(parsedData.getOldLoc())instanceof Pawn){
                            Pawn p=(Pawn)(theBoard.getPiece(parsedData.getOldLoc()));
                            p.setHasMoved(true);
                            if(Math.abs(parsedData.getOldY()-parsedData.getNewY())==2){
                                p.setFirstMoveDouble(true);
                            }
                            else{
                                p.setFirstMoveDouble(false);
                            }
                        }
                        //check for king
                        if(theBoard.getPiece(parsedData.getOldLoc())instanceof King){
                            King p=(King)(theBoard.getPiece(parsedData.getOldLoc()));
                            p.setHasMoved(true);
                        }
                        if(theBoard.getPiece(parsedData.getOldLoc())instanceof King){
                          if(parsedData.getOldX()-parsedData.getNewX()==-2){
                              theBoard.movePiece(parsedData.getOldLoc(), parsedData.getNewLoc());
                              theBoard.movePiece(new Location(parsedData.getOldX()+3,parsedData.getOldY()), new Location(parsedData.getOldX()+1,parsedData.getOldY()));
                              canMoveThere=false;
                          }    
                        }
                        //einpawonsusonuttt
                        //do later
                        if(theBoard.getPiece(parsedData.getOldLoc())instanceof Pawn){
                            if(Math.abs(parsedData.getNewX()-parsedData.getOldX())==1){
                                if(theBoard.getPiece(parsedData.getOldLoc()).isBlack()){
                                
                                }
                                else{
                                
                                }
                            }
                        }
                        if(canMoveThere==true){
                            theBoard.movePiece(parsedData.getOldLoc(), parsedData.getNewLoc());
                        }
                        log.add(parsedData);
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
            //now checks if any pawns to upgrade:
            theBoard.getPawnUpgrade('W');
            //now begins computer prtion
           
            //out of main loop of execution
            //this thing is horribally done but done in a rush to work will be refined later
            
            //now checks if pawns for computer to upgrade
            theBoard.getPawnCompuUpgrade('B');
            //checks if game is over
            theBoard.printOutBoard();
        }
        System.out.println("thanks for playing");
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
